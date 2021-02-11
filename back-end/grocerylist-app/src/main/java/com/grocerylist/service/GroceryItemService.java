package com.grocerylist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocerylist.model.GroceryItem;
import com.grocerylist.model.GroceryList;
import com.grocerylist.repository.GroceryItemRepo;

@Service
public class GroceryItemService {


	private GroceryItemRepo giRepo;
		
	public GroceryItemService() {
		super();
	}

	@Autowired
	public GroceryItemService(GroceryItemRepo giRepo) {
		super();
		this.giRepo = giRepo;
	}
	
	public List<GroceryItem> getAll(){
		return giRepo.findAll();
	}
	
	public GroceryItem getById(int id) {
		return giRepo.findByid(id);
	}
	
	public  List<GroceryItem> getByGroceryList(GroceryList gl){
		return giRepo.findBygroceryListId(gl);
	}
	
	public void insertItem(GroceryItem gi) {
		giRepo.save(gi);
	}
	
	public void updateItem(GroceryItem gi) {
		giRepo.save(gi);
	}
	
	public void deleteItem(GroceryItem gi){
		giRepo.delete(gi);
	}
	
}
