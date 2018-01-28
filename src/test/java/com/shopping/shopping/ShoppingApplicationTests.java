package com.shopping.shopping;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShoppingApplicationTests {
    @Autowired
    private MockMvc mvc;

	@Test
	public void getHelloWorld() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"content\":\"Hello, world\"}"));
	}

	@Test
	public void getHelloHhy() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON).param("name", "hhy"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"content\":\"Hello, hhy\"}"));
	}

	@Test
	public void getOneShoppingItem() throws Exception {
        JSONArray items=  new JSONArray();
        JSONObject item = new JSONObject();
        item.put("barcode", "ITEM0");
        item.put("name", "可乐");
        item.put("price", 1.0);
        item.put("unit", "瓶");
        items.put(item);
        mvc.perform(MockMvcRequestBuilders.get("/items").accept(MediaType.APPLICATION_JSON).param("name", "hhy"))
                .andExpect(status().isOk())
                .andExpect(content().json(items.toString()));
	}

}
