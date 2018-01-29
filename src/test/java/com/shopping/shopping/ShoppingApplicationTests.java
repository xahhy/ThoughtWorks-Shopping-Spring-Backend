package com.shopping.shopping;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;
import java.util.logging.Logger;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShoppingApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getOneShoppingItem() throws Exception {
        JSONObject item = new JSONObject();
        item.put("barcode", "ITEM000000");
        item.put("name", "可口可乐");
        item.put("price", 3.0);
        item.put("unit", "瓶");
        mvc.perform(MockMvcRequestBuilders.get("/api/shoppingItems/1").accept(MediaType.APPLICATION_JSON).param("name", "hhy"))
                .andExpect(status().isOk())
                .andExpect(content().json(item.toString()));
    }

    @Test
    public void returnSameValueWithPostRequestBody() throws Exception {
        JSONObject json = new JSONObject();
        json.put("barcode", "ITEM000000");
        String url = "/";
        String shouldSame = json.toString();
        MvcResult result = this.mvc.perform(
                post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json.toString()))
                .andExpect(status().isOk())
                .andExpect(content().string(shouldSame))
                .andReturn();
    }
//    @Test
//    public void generateOneShoppingItemFromClient() throws Exception {
//        JSONObject json = new JSONObject();
//        String url = "/";
//        MvcResult result = this.mvc.perform(
//                post(url)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json.toString()))
//                .andExpect(status().isOk())
//                .andReturn();
//    }


}
