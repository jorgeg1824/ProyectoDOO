package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.BooleanHelper;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class UserDTO {
	
	private UUID id;
	private IdentificationTypeDTO identificationType;
	private String identificationNumber;
	private String firstName;
	private String midedleName;
	private String lastName;
	private String secondLastName;
	private CityDTO residenceCity;
	private String email;
	private String phone;
	private boolean emailConfirmed;
	private boolean phoneConfirmed;
	
	public UserDTO() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setIdentificationType(new IdentificationTypeDTO());
		setIdentificationNumber(TextHelper.getDefault());
		setFirstName(TextHelper.getDefault());
		setMidedleName(TextHelper.getDefault());
		setLastName(TextHelper.getDefault());
		setSecondLastName(TextHelper.getDefault());
		setResidenceCity(new CityDTO());
		setEmail(TextHelper.getDefault());
		setPhone(TextHelper.getDefault());
		setEmailConfirmed(BooleanHelper.getDefault());
		setPhoneConfirmed(BooleanHelper.getDefault());
	}
	
	public UserDTO(final UUID id, 
				   final IdentificationTypeDTO identificationType, 
				   final String identificationNumber, 
				   final String firstName, 
				   final String midedleName, 
				   final String lastName, 
				   final String secondLastName, 
				   final CityDTO residenceCity, 
				   final String email, 
				   final String phone, 
				   final boolean emailConfirmed, 
				   final boolean phoneConfirmed) {
		setId(id);
		setIdentificationType(identificationType);
		setIdentificationNumber(identificationNumber);
		setFirstName(firstName);
		setMidedleName(midedleName);
		setLastName(lastName);
		setSecondLastName(secondLastName);
		setResidenceCity(residenceCity);
		setEmail(email);
		setPhone(phone);
		setEmailConfirmed(emailConfirmed);
		setPhoneConfirmed(phoneConfirmed);
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	
	public IdentificationTypeDTO getIdentificationType() {
		return identificationType;
	}
	
	public void setIdentificationType(IdentificationTypeDTO identificationType) {
		this.identificationType = ObjectHelper.getDefault(identificationType, new IdentificationTypeDTO());
	}
	
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = TextHelper.getDefault(identificationNumber);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = TextHelper.getDefault(firstName);
	}
	
	public String getMidedleName() {
		return midedleName;
	}
	
	public void setMidedleName(String midedleName) {
		this.midedleName = TextHelper.getDefault(midedleName);
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = TextHelper.getDefault(lastName);
	}
	
	public String getSecondLastName() {
		return secondLastName;
	}
	
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = TextHelper.getDefault(secondLastName);
	}
	
	public CityDTO getResidenceCity() {
		return residenceCity;
	}
	
	public void setResidenceCity(CityDTO residenceCity) {
		this.residenceCity = ObjectHelper.getDefault(residenceCity, new CityDTO());
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = TextHelper.getDefault(email);
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = TextHelper.getDefault(phone);
	}
	
	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}
	
	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = BooleanHelper.getDefault(emailConfirmed);
	}
	
	public boolean isPhoneConfirmed() {
		return phoneConfirmed;
	}
	
	public void setPhoneConfirmed(boolean phoneConfirmed) {
		this.phoneConfirmed = BooleanHelper.getDefault(phoneConfirmed);
	}
	
}
