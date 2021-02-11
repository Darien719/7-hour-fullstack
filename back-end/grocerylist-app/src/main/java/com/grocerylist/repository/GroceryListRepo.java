package com.grocerylist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocerylist.model.GroceryList;

@Repository
public interface GroceryListRepo extends JpaRepository<GroceryList, Integer> {
	public List<GroceryList> findAll();
	public GroceryList findByid(int groceryListId);
}
