package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class UserDTO {
	
	private UUID id;
	private IdentificationTypeDTO identificationType;
	private String identificationNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private String secondLastName;
	private CityDTO residenceCity;
	private String email;
	private String phone;
	private boolean emailConfirmed;
	private boolean phoneConfirmed;
	
	public UserDTO() {
		this.id = UUIDHelper.getUUIDHelper().getDefault();
		this.identificationType = new IdentificationTypeDTO(UUIDHelper.getUUIDHelper().getDefault(), TextHelper.getDefault());
		this.identificationNumber = "";
		this.firstName = "";
		this.middleName = "";
		this.lastName = "";
		this.secondLastName = "";
		this.residenceCity = new CityDTO();
		this.email = "";
		this.phone = "";
		this.emailConfirmed = false;
		this.phoneConfirmed = false;
	}
	
	public UserDTO(final UUID id, 
				   final IdentificationTypeDTO identificationType, 
				   final String identificationNumber, 
				   final String firstName, 
				   final String middleName, 
				   final String lastName, 
				   final String secondLastName, 
				   final CityDTO residenceCity, 
				   final String email, 
				   final String phone, 
				   final boolean emailConfirmed, 
				   final boolean phoneConfirmed) {
		this.id = id;
		this.identificationType = identificationType;
		this.identificationNumber = identificationNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.secondLastName = secondLastName;
		this.residenceCity = residenceCity;
		this.email = email;
		this.phone = phone;
		this.emailConfirmed = emailConfirmed;
		this.phoneConfirmed = phoneConfirmed;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public IdentificationTypeDTO getIdentificationType() {
		return identificationType;
	}
	
	public void setIdentificationType(IdentificationTypeDTO identificationType) {
		this.identificationType = identificationType;
	}
	
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMidedleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSecondLastName() {
		return secondLastName;
	}
	
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}
	
	public CityDTO getResidenceCity() {
		return residenceCity;
	}
	
	public void setResidenceCity(CityDTO residenceCity) {
		this.residenceCity = residenceCity;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}
	
	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}
	
	public boolean isPhoneConfirmed() {
		return phoneConfirmed;
	}
	
	public void setPhoneConfirmed(boolean phoneConfirmed) {
		this.phoneConfirmed = phoneConfirmed;
	}
	
}
