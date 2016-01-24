package test.java.com.cart.common;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import main.java.com.cart.common.Cart;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by hshs on 2016. 1. 2..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestContext.class})
public class CartControllerTest {

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testUpdate() throws Exception {

        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();

        Cart cart = new Cart();
        cart.setId(uuid1.toString());
        cart.setFolderId(uuid2.toString());
        cart.setType(Cart.Type.FOLDER.getValue());
        cart.setAction(Cart.Action.ADD.getValue());
        cart.setRegDate(String.valueOf(new Date().getTime()));
        cart.setName("폴더1");
        //        cart.setUrl();
        List<Cart> lstCart = new ArrayList<Cart>();
        lstCart.add(cart);

        Gson gson = new Gson();
        String cmdList = gson.toJson(lstCart);
//        JsonElement jsonCmdList = new JsonParser().parse(cmdList);
//        String cmdList = "[{\"type\":\"tt\",\"action\":\"aa\",\"folderId\":\"Ff\",\"destFolderId\":\"dd\",\"name\":\"nn\",\"url\":\"uu\",\"bookmarkId\":\"bb\",\"regDate\":1451712414982},{\"type\":\"tt2\",\"action\":\"aa2\",\"folderId\":\"Ff2\",\"destFolderId\":\"dd2\",\"name\":\"nn2\",\"url\":\"uu2\",\"bookmarkId\":\"bb2\",\"regDate\":1451712414982}]";
//        String cmdList = "[{\"type\":\"folder\",\"action\":\"aa\",\"folderId\":\"Ff\",\"destFolderId\":\"dd\",\"name\":\"nn\",\"url\":\"uu\",\"bookmarkId\":\"bb\",\"regDate\":1451712414982},{\"type\":\"bookmark\",\"action\":\"aa2\",\"folderId\":\"Ff2\",\"destFolderId\":\"dd2\",\"name\":\"nn2\",\"url\":\"uu2\",\"bookmarkId\":\"bb2\",\"regDate\":1451712414982}]";

        mockMvc.perform(post("/1/sync")
                .param("cmdList", cmdList))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].type", is("folder")))
                .andExpect(jsonPath("$[0].action", is("add")))
                .andExpect(jsonPath("$[0].name", is("폴더1")))
                ;
    }

//    @Test
//    public void testCart() throws Exception {
//
//        String cmdList = "[{\"type\":\"tt\",\"action\":\"aa\",\"folderId\":\"Ff\",\"destFolderId\":\"dd\",\"name\":\"nn\",\"url\":\"uu\",\"bookmarkId\":\"bb\",\"regDate\":1451712414982},{\"type\":\"tt2\",\"action\":\"aa2\",\"folderId\":\"Ff2\",\"destFolderId\":\"dd2\",\"name\":\"nn2\",\"url\":\"uu2\",\"bookmarkId\":\"bb2\",\"regDate\":1451712414982}]";
//
//        mockMvc.perform(post("/1/new")
//        ).andDo(print());
////                .andExpect(status().isOk());
//
//
//    }
}
