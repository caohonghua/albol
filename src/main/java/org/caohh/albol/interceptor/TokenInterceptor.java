package org.caohh.albol.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.caohh.albol.vo.Result;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("X-Token");
        Result result;
        if (StringUtils.isEmpty(token)) {
            result = new Result(Result.Code.ILLEGAL, "Token is Null");
        } else if (StringUtils.isEmpty(request.getSession().getAttribute(token))) {
            result = new Result(Result.Code.EXPIRED, "Token is Expired");
        } else {
            return true;
        }
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(result);
        response.reset();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        pw.write(content);
        pw.flush();
        return false;
    }
}
