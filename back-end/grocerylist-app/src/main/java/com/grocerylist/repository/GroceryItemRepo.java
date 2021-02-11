package com.grocerylist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocerylist.model.GroceryItem;
import com.grocerylist.model.GroceryList;

@Repository
public interface GroceryItemRepo extends JpaRepository<GroceryItem, Integer>{
	public List<GroceryItem> findAll();
	public GroceryItem findByid(int groceryItemId);
	public List<GroceryItem> findBygroceryListId(GroceryList groceryList);
}
