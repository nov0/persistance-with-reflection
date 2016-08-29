package org.nov0.persistance.model;

import org.nov0.persistance.constraints.Default;
import org.nov0.persistance.constraints.Id;
import org.nov0.persistance.constraints.NotNull;
import org.nov0.persistance.constraints.Size;

public class Car {

	@Id
	private int id;
	@NotNull
	@Default(value="Skoda")
	@Size(30)
	private String name;
	@NotNull
	@Default(value="Fabia")
	@Size(20)
	private String model;
	@NotNull
	@Size(3)
	private int year;

	public Car() {
	}

	public Car(int id, String name, String model, short year) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.year = year;
	}

	public Car(String name, String model, short year) {
		super();
		this.name = name;
		this.model = model;
		this.year = year;
	}

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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int  getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
