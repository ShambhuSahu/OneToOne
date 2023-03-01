package com.example.onetoonemapping.mapper;

import com.example.onetoonemapping.entity.AddressEntity;
import com.example.onetoonemapping.model.AddressRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressRequest entityToModel(AddressEntity addressEntity);
    AddressEntity modelToEntity(AddressRequest addressRequest);

    List<AddressRequest> entityToModelList(List<AddressEntity> addressEntityList);

}
