package org.nov0.persistance.model;

import org.nov0.persistance.constraints.Default;
import org.nov0.persistance.constraints.Id;
import org.nov0.persistance.constraints.NotNull;
import org.nov0.persistance.constraints.Size;
import org.nov0.persistance.constraints.Unique;

/**
 * This is simple POJO class that will be converted to MySql table with
 * reflection.
 * 
 * @author Novislav Sekulic
 *
 */

public class User {

	@Id
	private long id;

	@NotNull
	@Default(value = "18")
	private byte age;

	@Unique
	@NotNull
	@Size(2)
	private int idNumber;

	@NotNull
	private short pin;

	@NotNull
	@Default("F")
	@Size(55)
	private char gender;

	@NotNull
	@Default("182.4")
	@Size(12)
	private double height;

	@Default("John")
	private String firstName;

	@Default("Doe")
	@Size(100)
	private String lastName;

	@NotNull
	@Unique
	@Size(16)
	private String username;

	@NotNull
	@Size(80)
	private String password;

	public User() {
	}

	public User(byte age, int idNumber, short pin, char gender, String firstName, String lastName, String username,
			String password) {
		super();
		this.age = age;
		this.idNumber = idNumber;
		this.pin = pin;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public User(long id, byte age, int idNumber, short pin, char gender, String firstName, String lastName,
			String username, String password) {
		super();
		this.id = id;
		this.age = age;
		this.idNumber = idNumber;
		this.pin = pin;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public short getPin() {
		return pin;
	}

	public void setPin(short pin) {
		this.pin = pin;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", idNumber=" + idNumber + ", pin=" + pin + ", gender=" + gender
				+ ", height=" + height + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + "]";
	}

}
