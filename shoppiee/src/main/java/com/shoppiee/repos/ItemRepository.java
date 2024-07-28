package com.shoppiee.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppiee.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	Item findByName(String name);
}
