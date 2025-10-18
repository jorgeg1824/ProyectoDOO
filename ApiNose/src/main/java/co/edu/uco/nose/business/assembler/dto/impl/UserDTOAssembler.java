package co.edu.uco.nose.business.assembler.dto.impl;

import static co.edu.uco.nose.business.assembler.dto.impl.CityDTOAssembler.getCityDTOAssembler;
import static co.edu.uco.nose.business.assembler.dto.impl.IdentificationTypeDTOAssembler.getIdentificationTypeDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.UserDTO;

public final class UserDTOAssembler implements DTOAssembler<UserDTO, UserDomain>{

	@Override
	public UserDTO toDTO(UserDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var cityDtoTmp = getCityDTOAssembler().toDTO(domainTmp.getResidenceCity());
		var identificationTypeTmp = getIdentificationTypeDTOAssembler().toDTO(domain.getIdentificationType());
		return new UserDTO(domainTmp.getId(), identificationTypeTmp, domainTmp.getIdentificationNumber(), domainTmp.getFirstName(), domainTmp.getMiddleName(),
				domainTmp.getLastName(), domainTmp.getSecondLastName(), cityDtoTmp, domainTmp.getEmail(), domainTmp.getPhone(), domainTmp.isEmailConfirmed(),
				domainTmp.isPhoneConfirmed());
	}

	@Override
	public UserDomain toDomain(UserDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new UserDTO());
		var cityDomainTmp = getCityDTOAssembler().toDomain(dtoTmp.getResidenceCity());
		var identificationTypeTmp = getIdentificationTypeDTOAssembler().toDomain(dtoTmp.getIdentificationType());
		return new UserDomain(dtoTmp.getId(), identificationTypeTmp, dtoTmp.getIdentificationNumber(), dtoTmp.getFirstName(), dtoTmp.getMiddleName(),
				dtoTmp.getLastName(), dtoTmp.getSecondLastName(), cityDomainTmp, dtoTmp.getEmail(), dtoTmp.getPhone(), dtoTmp.isEmailConfirmed(),
				dtoTmp.isPhoneConfirmed());
	}

	@Override
	public List<UserDTO> toDTO(List<UserDomain> domainList) {
		var userDtoList = new ArrayList<UserDTO>();
		
		for (var userDomain : domainList) {
			userDtoList.add(toDTO(userDomain));
		}
		
		return userDtoList;
	}

}
