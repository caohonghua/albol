package org.caohh.albol.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.caohh.albol.mapper.UserDynamicSqlSupport;
import org.caohh.albol.mapper.UserMapper;
import org.caohh.albol.model.Role;
import org.caohh.albol.service.UserService;
import org.caohh.albol.vo.Result;
import org.caohh.albol.vo.User;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.where.WhereApplier;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.caohh.albol.mapper.RoleDynamicSqlSupport.role;
import static org.caohh.albol.mapper.UserDynamicSqlSupport.password;
import static org.caohh.albol.mapper.UserDynamicSqlSupport.user;
import static org.caohh.albol.mapper.UserRoleDynamicSqlSupport.userRole;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HttpSession session;

    @Override
    public Result search(org.caohh.albol.vo.User user) {
        Result result;
        try {
            WhereApplier whereApplier = abstractWhereDSL -> abstractWhereDSL.where(UserDynamicSqlSupport.name, isEqualToWhenPresent(user.getName()))
                    .and(password, isEqualToWhenPresent(user.getPassword()));
            SelectStatementProvider provider;
            long offset = user.offset();
            if (offset >= user.getMaxOffset()) {
                provider = select(userMapper.selectList)
                        .from(UserDynamicSqlSupport.user)
                        .where(UserDynamicSqlSupport.id, isGreaterThanOrEqualTo(
                                select(UserDynamicSqlSupport.id).from(UserDynamicSqlSupport.user).applyWhere(whereApplier)
                                        .limit(1).offset(offset)))
                        .limit(user.getPageSize()).build().render(RenderingStrategies.MYBATIS3);
            } else {
                provider = select(userMapper.selectList)
                        .from(UserDynamicSqlSupport.user)
                        .applyWhere(whereApplier)
                        .limit(user.getPageSize())
                        .offset(offset).build().render(RenderingStrategies.MYBATIS3);
            }
            result = new Result(Result.Code.SUCCESS, userMapper.selectMany(provider));
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "search fail");
        }
        return result;
    }

    @Transactional
    @Override
    public Result save(User user) {
        Result result;
        try {
            org.caohh.albol.model.User record = new org.caohh.albol.model.User();
            BeanUtils.copyProperties(user, record);
            result = new Result(Result.Code.SUCCESS, userMapper.insertSelective(record) > 0);
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "save fail");
        }
        return result;
    }

    @Override
    public Result delete(Long id) {
        Result result;
        try {
            result = new Result(Result.Code.SUCCESS, userMapper.deleteByPrimaryKey(id) > 0);
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "delete fail");
        }
        return result;
    }

    @Override
    public Result update(User user) {
        Result result;
        try {
            org.caohh.albol.model.User record = new org.caohh.albol.model.User();
            BeanUtils.copyProperties(user, record);
            result = new Result(Result.Code.SUCCESS, userMapper.updateByPrimaryKeySelective(record) > 0);
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "update fail");
        }
        return result;
    }

    @Override
    public Result reg(User user) {
        Result result;
        try {
            result = existsUser(user)
                    ? new Result(Result.Code.FAIL, "用户已存在")
                    : save(user);
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "reg fail");
        }
        return result;
    }

    private Boolean existsUser(User user) {
        WhereApplier whereApplier = abstractWhereDSL ->
                abstractWhereDSL.where(UserDynamicSqlSupport.name, isEqualToWhenPresent(user.getName()));
        SelectStatementProvider provider =
                select(UserDynamicSqlSupport.id).from(UserDynamicSqlSupport.user)
                        .applyWhere(whereApplier)
                        .limit(1).build().render(RenderingStrategies.MYBATIS3);
        return userMapper.selectOne(provider).isPresent();
    }

    @Override
    public Result login(User user) {
        Result result;
        try {
            SelectStatementProvider provider = select(UserDynamicSqlSupport.id).from(UserDynamicSqlSupport.user)
                    .where(UserDynamicSqlSupport.name, isEqualToWhenPresent(user.getName()))
                    .and(password, isEqualTo(user.getPassword()))
                    .limit(1).build().render(RenderingStrategies.MYBATIS3);
            if (userMapper.selectOne(provider).isPresent()) {
                String token = user.getName() + "-" + System.currentTimeMillis();
                session.setAttribute(token, user.getName());
                result = new Result(Result.Code.SUCCESS, (Object) token);
            } else {
                result = new Result(Result.Code.FAIL, "账号或密码错误");
            }
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "login fail");
        }
        return result;
    }

    @Override
    public Result logout(String token) {
        Result result;
        try {
            session.removeAttribute(token);
            result = new Result(Result.Code.SUCCESS, true);
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "logout fail");
        }
        return result;
    }

    @Override
    public Result info(String token) {
        Result result;
        try {
            Object obj = session.getAttribute(token);
            if (obj instanceof String) {
                String name = (String) obj;
                SelectStatementProvider provider = select(user.name, user.avatar, role.name.as("role_name"), role.desc.as("role_desc"))
                        .from(user, "u").join(userRole, "ur").on(user.id, equalTo(userRole.userId))
                        .join(role, "r").on(userRole.roleId, equalTo(role.id))
                        .where(UserDynamicSqlSupport.name, isEqualTo(name))
                        .limit(1).build().render(RenderingStrategies.MYBATIS3);
                Optional<org.caohh.albol.model.User> optional = userMapper.selectOne(provider);
                org.caohh.albol.model.User user = optional.orElse(null);
                if (optional.isPresent()) {
                    List<String> roles = user.getRoleList().stream().map(Role::getName).collect(Collectors.toList());
                    user.setRoles(roles);
                }
                result = new Result(Result.Code.SUCCESS, user);
            } else {
                result = new Result(Result.Code.ILLEGAL, "Token is Illegal");
            }
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "logout fail");
        }
        return result;
    }
}
