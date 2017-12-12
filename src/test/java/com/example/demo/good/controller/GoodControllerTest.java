package com.example.demo.good.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WangNan
 * Email：nan.wang@htouhui.com
 * Date: 2017-12-11
 * Time: 下午4:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GoodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void save() {

    }

    /**
     * 测试添加商品
     *
     * @throws Exception
     */
    @Test
    public void addGood() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/good/save")
                .param("name", "西红柿")
                .param("unit", "斤")
                .param("price", "12.88"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andDo(print())
                .andReturn();
        result.getResponse().setCharacterEncoding("UTF-8");
        System.out.println(result.getResponse().getContentAsString());
    }
}