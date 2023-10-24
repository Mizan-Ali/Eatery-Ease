package com.eateryease.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public Menu addNewDish(Menu menuDto) {
        Menu menu = Menu.builder()
                .dishName(menuDto.getDishName())
                .price(menuDto.getPrice())
                .description(menuDto.getDescription())
                .available(menuDto.isAvailable())
                .build();
        menu = menuRepository.saveAndFlush(menu);
        return menu;
    }

    public Menu findById(Long menuId) {
       return menuRepository.findById(menuId)
               .orElseThrow(() -> new RuntimeException("Menu not found with ID: " + menuId));
    }

    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    public Menu update(Menu menu) {
        return menuRepository.save(menu);
    }
}
