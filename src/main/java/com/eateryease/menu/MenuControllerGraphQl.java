package com.eateryease.menu;

import com.eateryease.orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MenuControllerGraphQl {

    @Autowired
    private MenuService menuService;

    @QueryMapping("getAllMenus")
    public List<Menu> findAllMenu() {
        return menuService.findAll();
    }

    @QueryMapping("getMenu")
    public Menu findById(@Argument(value = "id") Integer menuId) {
        return menuService.findById(Long.valueOf(menuId));
    }

    @MutationMapping("addMenu")
    public Menu addMenu(
            @Argument String dishName,
            @Argument String description,
            @Argument Integer price,
            @Argument Boolean available
    ) {
        Menu menu = Menu.builder()
                .dishName(dishName)
                .description(description)
                .price(price)
                .available(available)
                .build();

        return menuService.addNewDish(menu);
    }

    @MutationMapping("updateMenu")
    public Menu updateMenu(
            @Argument(value = "id") Integer menuId,
            @Argument String dishName,
            @Argument String description,
            @Argument Integer price,
            @Argument Boolean available
    ) {
        Menu menu = menuService.findById(Long.valueOf(menuId));
        menu.setDishName((dishName == null) ? menu.getDishName() : dishName);
        menu.setPrice(price == null ? menu.getPrice() : price);
        menu.setAvailable(available == null ? menu.isAvailable() : available);
        menu.setDescription(description == null ? menu.getDescription() : description);
        return menuService.update(menu);
    }
}
