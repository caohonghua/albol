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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class RoleControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    RoleController roleController;

    String name = "name-" + System.currentTimeMillis();
    String desc = "123456";

    @Test
    void search() throws Exception {
        mockMvc.perform(get("/role/search")
                .param("name", name)
                .param("desc", desc))
                .andExpect(status().isOk())
                .andExpect(content().json("{code:20000,data:[]}"))
                .andReturn();
    }

    @Test
    @Transactional
    void save() throws Exception{
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("desc", desc);
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(map);
        mockMvc.perform((post("/role/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)))
                .andExpect(status().isOk()).andExpect(content().json("{code:20000,data:true}"))
                .andReturn();
    }

    @Test
    @Transactional
    void delete() throws Exception{
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("desc", desc);
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(map);
        mockMvc.perform((post("/role/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)))
                .andExpect(status().isOk()).andExpect(content().json("{code:20000,data:true}"))
                .andReturn();
        //
        String string = mockMvc.perform(get("/role/search")
                .param("name", name)
                .param("desc", desc))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Result result = mapper.readValue(string, Result.class);
        List<Map<String, Object>> list = (List<Map<String, Object>>) result.getData();
        long id = Long.parseLong(list.get(0).get("id") + "");
        mockMvc.perform(MockMvcRequestBuilders.delete("/role/delete/" + id))
                .andExpect(status().isOk()).andExpect(content().json("{code:20000,data:true}"))
                .andReturn();
    }

    @Test
    @Transactional
    void update() throws Exception{
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("desc", desc);
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(map);
        mockMvc.perform((post("/role/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)))
                .andExpect(status().isOk()).andExpect(content().json("{code:20000,data:true}"))
                .andReturn();
        //
        String string = mockMvc.perform(get("/role/search")
                .param("name", name)
                .param("desc", desc))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Result result = mapper.readValue(string, Result.class);
        List<Map<String, Object>> list = (List<Map<String, Object>>) result.getData();
        long id = Long.parseLong(list.get(0).get("id") + "");
        map.put("id", id + "");
        map.put("role", "qqqq");
        content = mapper.writeValueAsString(map);
        mockMvc.perform((post("/role/update"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(content().json("{code:20000,data:true}"))
                .andReturn();

    }
}