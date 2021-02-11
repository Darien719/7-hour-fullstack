package com.grocerylist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocerylist.model.Type;

public interface TypeRepo extends JpaRepository<Type, Integer>{
	public Type findById(int id);
}
