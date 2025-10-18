package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class DepartmentDTO {
	
	private UUID id;
	private CountryDTO country;
	private String name;
	
	public DepartmentDTO() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setCountry(new CountryDTO());
		setName(TextHelper.getDefault());
	}
	
	public DepartmentDTO(final UUID id) {
		setId(id);
		setCountry(new CountryDTO());
		setName(TextHelper.getDefault());
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
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	public CountryDTO getCountry() {
		return country;
	}
	public void setCountry(CountryDTO country) {
		this.country = ObjectHelper.getDefault(country, new CountryDTO());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
}
