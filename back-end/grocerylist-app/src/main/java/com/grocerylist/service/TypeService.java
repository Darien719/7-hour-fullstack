package com.grocerylist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocerylist.model.Type;
import com.grocerylist.repository.TypeRepo;

@Service
public class TypeService {
	
	private TypeRepo typeRepo;

	@Autowired
	public TypeService(TypeRepo typeRepo) {
		super();
		this.typeRepo = typeRepo;
	}
	
	public Type getById(int id) {
		Type type = typeRepo.findById(id);
		return type;
	}
	
}
