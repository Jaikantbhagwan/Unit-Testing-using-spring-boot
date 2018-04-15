package com.jaikant.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.jaikant.unittesting.unittesting.data.ItemRepository;
import com.jaikant.unittesting.unittesting.model.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

	@InjectMocks
	private ItemBusinessService businessService;

	@Mock
	ItemRepository repository;

	@Test
	public void retrieveAllItems_basic() {
		when(repository.findAll())
				.thenReturn(Arrays.asList(new Item(2, "Item2", 10, 10), new Item(3, "Item3", 20, 20)));
		List<Item> items = businessService.retrieveAllItems();
        assertEquals(items.get(0).getValue(), 100);
        assertEquals(items.get(1).getValue(), 400);
		
	}

}
