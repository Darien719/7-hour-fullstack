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

import com.grocerylist.model.GroceryItem;
import com.grocerylist.model.GroceryList;
import com.grocerylist.model.Type;
import com.grocerylist.service.GroceryItemService;
import com.grocerylist.service.GroceryListService;
import com.grocerylist.service.TypeService;

@RestController
@RequestMapping(value = "/item")
@CrossOrigin(origins = "*")
public class GroceryItemController {
	
	
	private GroceryItemService giServ;
	private GroceryListService glServ;
	private TypeService typeServ;

	public GroceryItemController() {
		super();
	}

	@Autowired
	public GroceryItemController(GroceryItemService giServ, GroceryListService glServ, TypeService typeServ) {
		super();
		this.giServ = giServ;
		this.glServ = glServ;
		this.typeServ = typeServ;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GroceryItem> getGroceryItemById(@PathVariable("id") int id) {
		GroceryItem gi = giServ.getById(id);
		if (gi == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(gi, HttpStatus.OK);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<List<GroceryItem>> getAllGroceryItem(){
		List<GroceryItem> giList = giServ.getAll();
		if(giList.size()==0) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(giList, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteGroceryItemById(@PathVariable("id") int id) {
		GroceryItem gi = giServ.getById(id);
		giServ.deleteItem(gi);
		if (gi == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Deleted", HttpStatus.OK);
		}
	}
	
	@PostMapping()
	public ResponseEntity<String> insertGroceryItem(@RequestBody LinkedHashMap giMap){
		System.out.println(giMap);
		GroceryList gl = glServ.getById((Integer)giMap.get("grocery_list_id"));
		Type type = typeServ.getById(Integer.parseInt(giMap.get("type_id").toString()));
		GroceryItem gi = new GroceryItem(gl, type, (String)giMap.get("name"), Double.parseDouble(giMap.get("cost").toString()));
		giServ.insertItem(gi);
		return new ResponseEntity<> ("Created", HttpStatus.CREATED);
	}
	
	@GetMapping("/grocerylist/{id}")
	public ResponseEntity<List<GroceryItem>> getByGroceryList(@PathVariable("id") int id){
		GroceryList gl = glServ.getById(id);
		List<GroceryItem> giList = giServ.getByGroceryList(gl);
		if(giList.size()==0) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(giList, HttpStatus.OK);
		}
	}
	
	
	
}
