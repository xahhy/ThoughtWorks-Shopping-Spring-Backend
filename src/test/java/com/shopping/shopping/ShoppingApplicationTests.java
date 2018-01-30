package com.shopping.shopping;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
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

import static junit.framework.TestCase.assertEquals;
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

    @Autowired
    private ShoppingItemRepository repository;

    @Before
    public void setUp(){
        this.repository.deleteAll();
        this.repository.save(new ShoppingItem("ITEM000000", "可口可乐", 3.00f, "瓶"));
        this.repository.save(new ShoppingItem("ITEM000001", "雪碧", 3.00f, "瓶"));
        this.repository.save(new ShoppingItem("ITEM000002", "苹果", 5.50f, "斤"));
        this.repository.save(new ShoppingItem("ITEM000003", "荔枝", 15.00f, "斤"));
        this.repository.save(new ShoppingItem("ITEM000004", "电池", 12.00f, "个"));
        this.repository.save(new ShoppingItem("ITEM000005", "方便面", 4.50f, "袋"));

    }

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
        JSONArray items = new JSONArray();
        items.put("ITEM00000");
        items.put("ITEM00001");
        items.put("ITEM00002");
        String url = "/";
        String shouldSame = items.toString();
        MvcResult result = this.mvc.perform(
                post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(items.toString()))
                .andExpect(status().isOk())
                .andExpect(content().string(shouldSame))
                .andReturn();
    }

    @Test
    public void calculateReturn3WhenItemIsItem000000(){
        CalculateItem item = new CalculateItem(repository);
        float result = item.calculate("ITEM000000");
        assertEquals(result, 3f);
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
