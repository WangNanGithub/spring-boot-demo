package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringBootDemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void resolver() throws Exception {
        String url = "/submit";
        mockMvc.perform(post(url)
                .accept(MediaType.MULTIPART_FORM_DATA)
                .param("teacher.name", "teacher")
                .param("student.name", "student")
                .param("student.age", "21"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void test() throws Exception {
        String url = "/test";
        mockMvc.perform(post(url)
                .accept(MediaType.MULTIPART_FORM_DATA)
                .param("name", "student")
                .param("age", "21"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
