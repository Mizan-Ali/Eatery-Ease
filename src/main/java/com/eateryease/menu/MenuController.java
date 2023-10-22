package com.eateryease.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping
    @RequestMapping("/add")
    public Boolean addDist(@RequestBody Menu menu) {
        try {
            menuService.addNewDish(menu);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

}
