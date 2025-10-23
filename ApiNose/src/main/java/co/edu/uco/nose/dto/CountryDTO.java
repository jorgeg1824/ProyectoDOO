package co.edu.uco.nose.dto;

import java.util.UUID;

public final class CountryDTO {
	
	private UUID id;
	private String name;
	
	public CountryDTO() {
		this.id = null;		this.name = "";
	}

	public CountryDTO(UUID id, String name) {
		setId(id);
		setName(name);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
