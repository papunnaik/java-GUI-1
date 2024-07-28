package com.shoppiee.service;

import com.shoppiee.model.Item;
import com.shoppiee.repos.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public void updateItem(Item item) {
        Item existingItem = itemRepository.findByName(item.getName());
        if (existingItem != null) {
            existingItem.setQuantity(item.getQuantity());
            existingItem.setPrice(item.getPrice());
            itemRepository.save(existingItem);
        }
    }

    public void deleteItem(String itemName) {
        Item item = itemRepository.findByName(itemName);
        if (item != null) {
            itemRepository.delete(item);
        }
    }
}
