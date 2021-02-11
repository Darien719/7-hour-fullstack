package com.grocerylist.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "grocery_item")
public class GroceryItem {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@JoinColumn(name="grocery_list_id")
	@ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private GroceryList groceryListId;
	@JoinColumn(name="type_id")
	@ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private Type typeId;
	@Column(name = "name")
	private String name;
	@Column(name = "cost")
	private double cost;
	
	public GroceryItem(int id, GroceryList groceryListId, Type type, String name, double cost) {
		super();
		this.id = id;
		this.groceryListId = groceryListId;
		this.typeId = type;
		this.name = name;
		this.cost = cost;
	}

	public GroceryItem(GroceryList groceryListId, Type type, String name, double cost) {
		super();
		this.groceryListId = groceryListId;
		this.typeId = type;
		this.name = name;
		this.cost = cost;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GroceryList getGroceryListId() {
		return groceryListId;
	}

	public void setGroceryListId(GroceryList groceryListId) {
		this.groceryListId = groceryListId;
	}

	public Type getTypeId() {
		return typeId;
	}

	public void setTypeId(Type typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public GroceryItem() {
		super();
	}

	@Override
	public String toString() {
		return "GroceryItem [id=" + id + ", groceryListId=" + groceryListId + ", type=" + typeId + ", name=" + name
				+ ", cost=" + cost + "]";
	}
	
}
