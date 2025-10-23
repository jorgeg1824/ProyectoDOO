package co.edu.uco.nose.business.assembler.entity.impl;

import static co.edu.uco.nose.business.assembler.entity.impl.CityEntityAssembler.getCityEntityAssembler;
import static co.edu.uco.nose.business.assembler.entity.impl.IdentificationTypeEntityAssembler.getIdentificationTypeEntityAssembler;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.UserEntity;

public final class UserEntityAssembler implements EntityAssembler<UserEntity, UserDomain>{
	
	private static final EntityAssembler<UserEntity, UserDomain> instance =
			new UserEntityAssembler();
	
	private UserEntityAssembler() {
	}
	
	public static EntityAssembler<UserEntity, UserDomain> getUserEntityAssembler(){
		return instance;
	}

	@Override
	public UserEntity toEntity(UserDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var cityEntityTmp = getCityEntityAssembler().toEntity(domainTmp.getResidenceCity());
		var identificationTypeEntityTmp = getIdentificationTypeEntityAssembler().toEntity(domain.getIdentificationType());
		return new UserEntity(domainTmp.getId(), identificationTypeEntityTmp, domainTmp.getIdentificationNumber(), domainTmp.getFirstName(), domainTmp.getMiddleName(),
				domainTmp.getLastName(), domainTmp.getSecondLastName(), cityEntityTmp, domainTmp.getEmail(), domainTmp.getPhone(), domainTmp.isEmailConfirmed(),
				domainTmp.isPhoneConfirmed());
	}

	@Override
	public UserDomain toDomain(UserEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new UserEntity());
		var cityDomainTmp = getCityEntityAssembler().toDomain(entityTmp.getResidenceCity());
		var identificationTypeDomainTmp = getIdentificationTypeEntityAssembler().toDomain(entityTmp.getIdentificationType());
		return new UserDomain(entityTmp.getId(), identificationTypeDomainTmp, entityTmp.getIdentificationNumber(), entityTmp.getFirstName(), entityTmp.getMiddleName(),
				entityTmp.getLastName(), entityTmp.getSecondLastName(), cityDomainTmp, entityTmp.getEmail(), entityTmp.getPhone(), entityTmp.isEmailConfirmed(),
				entityTmp.isPhoneConfirmed());
	}

}
