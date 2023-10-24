package com.eateryease.menu;

import com.eateryease.orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @RequestMapping("/{menuid}")
    public List<Orders> getOrders(@PathVariable(value = "menuid") Long menuId) {
        Menu menu = menuService.findById(menuId);
        return menu.getOrders();
    }

}
