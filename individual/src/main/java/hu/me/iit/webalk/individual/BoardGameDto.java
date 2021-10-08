package hu.me.iit.webalk.individual;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BoardGameDto {
	@NotNull
	private int id;
	@NotNull
	@NotBlank
	private String name;
	@NotBlank
	private String manufacturer;
	@Min(2)
	@Max(8)
	private int playerNumber;
	
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
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	
	@Override
	public String toString() {
		return "BoardGameDto (id: " + id + ", name: " + name + ", manufacturer: " + 
							manufacturer + ", playerNumber: " + playerNumber + ")";
	}
	
	
}
