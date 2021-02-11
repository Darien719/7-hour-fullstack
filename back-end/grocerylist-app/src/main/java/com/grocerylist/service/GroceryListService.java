package com.grocerylist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocerylist.model.GroceryItem;
import com.grocerylist.model.GroceryList;
import com.grocerylist.repository.GroceryListRepo;

@Service
public class GroceryListService {


	private GroceryListRepo glRepo;

	public GroceryListService() {
		super();
	}

	@Autowired
	public GroceryListService(GroceryListRepo glRepo) {
		super();
		this.glRepo = glRepo;
	}
	
	public GroceryList getById(int groceryListId) {
		GroceryList gl = glRepo.findByid(groceryListId);
		return gl;
	}
	
	public List<GroceryList> getAll(){
		return glRepo.findAll();
	}
	
	public void insertList(GroceryList gl) {
		glRepo.save(gl);
	}
	
	public void updateList(GroceryList gl) {
		glRepo.save(gl);
	}
	
	public void deleteList(GroceryList gl){
		glRepo.delete(gl);
	}
	
}
