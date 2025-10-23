package co.edu.uco.nose.dto;

import java.util.UUID;

public final class DepartmentDTO {
	
	private UUID id;
	private CountryDTO country;
	private String name;
	
	public DepartmentDTO() {
		this.id = null;
		this.country = new CountryDTO();
		this.name = "";
	}
	
	public DepartmentDTO(final UUID id, final CountryDTO country, final String name) {
		setId(id);
		setCountry(country);
		setName(name);
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public CountryDTO getCountry() {
		return country;
	}
	public void setCountry(CountryDTO country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
