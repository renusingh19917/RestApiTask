package com.dev.task.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="devices")
public class Device {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="device_id")
	private int id;
	private String name;
	private String version;
	private String brand;
	private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Device() {
		super();
	}
	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", version=" + version + ", brand=" + brand + ", price=" + price
				+ "]";
	}
	public Device(int id, String name, String version, String brand, int price) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.brand = brand;
		this.price = price;
	}
	
	
}
