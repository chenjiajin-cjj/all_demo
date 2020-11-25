package chenjiajin.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("product")
public class ProductController {


    @GetMapping("get_product_name")
    public Object getProductName(){
        String [] names = new String [10];
        for (int i = 0; i < names.length; i++) {
            names[i] = "名字："+i;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("2323",names);
        return map;
    }
}
