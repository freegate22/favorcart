package test.java.com.cart.common;

import main.java.com.cart.common.CartController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by hshs on 2016. 1. 2..
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
public class CommonControllerTest {

    MockMvc mockMvc;

//    @Autowired
//    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(new CartController()).build();
    }

    @Test
    public void testUpdate() throws Exception {

        String cmdList = "[{\"type\":\"tt\",\"action\":\"aa\",\"folderId\":\"Ff\",\"destFolderId\":\"dd\",\"name\":\"nn\",\"url\":\"uu\",\"bookmarkId\":\"bb\",\"regDate\":1451712414982},{\"type\":\"tt2\",\"action\":\"aa2\",\"folderId\":\"Ff2\",\"destFolderId\":\"dd2\",\"name\":\"nn2\",\"url\":\"uu2\",\"bookmarkId\":\"bb2\",\"regDate\":1451712414982}]";

        mockMvc.perform(post("/1/sync")
//                        .param("cmdList", cmdList)
        ).andDo(print());
//                .andExpect(status().isOk());
//                .andExpect(content().contentType("application/json"))
//                .andExpect(jsonPath("$", hasSize(2))
//                .andExpect(jsonPath("$[0].id").exists())
//                .andExpect(jsonPath("$[0].fn").value("Marge"));
    }

    @Test
    public void testCart() throws Exception {

        String cmdList = "[{\"type\":\"tt\",\"action\":\"aa\",\"folderId\":\"Ff\",\"destFolderId\":\"dd\",\"name\":\"nn\",\"url\":\"uu\",\"bookmarkId\":\"bb\",\"regDate\":1451712414982},{\"type\":\"tt2\",\"action\":\"aa2\",\"folderId\":\"Ff2\",\"destFolderId\":\"dd2\",\"name\":\"nn2\",\"url\":\"uu2\",\"bookmarkId\":\"bb2\",\"regDate\":1451712414982}]";

        mockMvc.perform(post("/1/new")
        ).andDo(print())
                .andExpect(status().isOk());


    }
}
