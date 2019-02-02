package com.felipebelgine.cmcourse.resources;

import com.felipebelgine.cmcourse.domain.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> list() {

        Category cat1 = new Category(1, "IT");
        Category cat2 = new Category(1, "Office");

        List<Category> list = new ArrayList<Category>();
        list.add(cat1);
        list.add(cat2);

        return list;
    }

}
