package com.shoppiee.controller;

import com.shoppiee.model.Item;
import com.shoppiee.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/addItem")
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @PostMapping("/updateItem")
    public void updateItem(@RequestBody Item item) {
        itemService.updateItem(item);
    }

    @PostMapping("/deleteItem")
    public void deleteItem(@RequestBody Item item) {
        itemService.deleteItem(item.getName());
    }
}
