package com.jaikant.unittesting.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jaikant.unittesting.unittesting.data.ItemRepository;
import com.jaikant.unittesting.unittesting.model.Item;

@Component
public class ItemBusinessService {

	@Autowired
	ItemRepository repository;

	public Item retrieveHardcodedItem() {
		return new Item(1, "Ball", 10, 100);
	}

	public List<Item> retrieveAllItems() {
		List<Item> items =  repository.findAll();
		for(Item item : items) {
			item.setValue(item.getPrice()  * item.getQuantity());
		}
		return items;

	}
}
