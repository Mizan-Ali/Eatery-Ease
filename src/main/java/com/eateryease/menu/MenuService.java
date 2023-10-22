package com.eateryease.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public void addNewDish(Menu menuDto) {
        Menu menu = Menu.builder()
                .dishName(menuDto.getDishName())
                .price(menuDto.getPrice())
                .description(menuDto.getDescription())
                .available(menuDto.isAvailable())
                .build();
        menuRepository.saveAndFlush(menu);
    }
}
