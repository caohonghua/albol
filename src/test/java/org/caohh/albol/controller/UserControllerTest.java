package org.caohh.albol.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.caohh.albol.vo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserController userController;

    String name = "name-" + System.currentTimeMillis();
    String password = "e10adc3949ba59abbe56e057f20f883e";

    @Test
    void search() throws Exception {
        mockMvc.perform(get("/user/search")
                .param("pageSize", "100")
                .param("currentPage", "1")
                .param("name", name)
                .param("password", password))
                .andExpect(status().isOk())
                .andExpect(content().json("{code:20000,data:[]}"))
                .andReturn();
    }

    @Test
    @Transactional
    void save() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("password", password);
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(map);
        mockMvc.perform((post("/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)))
                .andExpect(status().isOk()).andExpect(content().json("{code:20000,data:true}"))
                .andReturn();
    }

    @Test
    @Transactional
    void delete() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("password", password);
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(map);
        mockMvc.perform((post("/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)))
                .andExpect(status().isOk()).andExpect(content().json("{code:20000,data:true}"))
                .andReturn();
        //
        String string = mockMvc.perform(get("/user/search")
                .param("pageSize", "100")
                .param("currentPage", "1")
                .param("name", name)
                .param("password", password))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Result result = mapper.readValue(string, Result.class);
        List<Map<String, Object>> list = (List<Map<String, Object>>) result.getData();
        long id = Long.parseLong(list.get(0).get("id") + "");
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/delete/" + id))
                .andExpect(status().isOk()).andExpect(content().json("{code:20000,data:true}"))
                .andReturn();
    }

    @Test
    @Transactional
    void update() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("password", password);
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(map);
        mockMvc.perform((post("/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)))
                .andExpect(status().isOk()).andExpect(content().json("{code:20000,data:true}"))
                .andReturn();
        //
        String string = mockMvc.perform(get("/user/search")
                .param("pageSize", "100")
                .param("currentPage", "1")
                .param("name", name)
                .param("password", password))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Result result = mapper.readValue(string, Result.class);
        List<Map<String, Object>> list = (List<Map<String, Object>>) result.getData();
        long id = Long.parseLong(list.get(0).get("id") + "");
        map.put("id", id + "");
        map.put("password", "11111111111111111111111111111111");
        content = mapper.writeValueAsString(map);
        mockMvc.perform((post("/user/update"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(content().json("{code:20000,data:true}"))
                .andReturn();
    }

    @Test
    @Transactional
    void reg() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("password", password);
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(map);
        mockMvc.perform(post("/user/reg")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(content().json("{code:20000,data:true}"))
                .andReturn();
    }
}