package com.grocerylist.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocerylist.model.GroceryList;
import com.grocerylist.service.GroceryListService;

@RestController
@RequestMapping(value = "/list")
@CrossOrigin(origins = "*")
public class GroceryListController {

	private GroceryListService glServ;

	
	
	public GroceryListController() {
		super();
	}

	@Autowired
	public GroceryListController(GroceryListService glServ) {
		super();
		this.glServ = glServ;
	}
	
	@PostMapping()
	public ResponseEntity<String> insertGroceryList(@RequestBody LinkedHashMap glMap){
	
		GroceryList gl = new GroceryList((String)glMap.get("name"));
		glServ.insertList(gl);
		return new ResponseEntity<> ("Created", HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GroceryList> getGroceryListById(@PathVariable("id") int id) {
		GroceryList gl = glServ.getById(id);
		if (gl == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(gl, HttpStatus.OK);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<GroceryList>> getAllGroceryList(){
		List<GroceryList> glList = glServ.getAll();
		System.out.println(glList);
		if(glList.size()==0) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}else {
			 ResponseEntity test = new ResponseEntity<>(glList, HttpStatus.OK);
			 System.out.println(test);
			 return test;
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteGroceryListById(@PathVariable("id") int id) {
		GroceryList gl = glServ.getById(id);
		glServ.deleteList(gl);
		if (gl == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Deleted", HttpStatus.OK);
		}
	}
	
}
