package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CityDTO {
	
	private UUID id;
	private String name;
	
	public CityDTO() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
	}
	
	public CityDTO(final UUID id, final String name) {
		setId(id);
		setName(name);
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = TextHelper.getDefault(name);
	}

}
