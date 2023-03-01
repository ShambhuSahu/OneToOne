package com.example.onetoonemapping.mapper;

import com.example.onetoonemapping.entity.PersonEntity;
import com.example.onetoonemapping.model.PersonRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonRequest entityToModel(PersonEntity personEntity);
    PersonEntity  modelToEntity(PersonRequest personRequest);

    List<PersonRequest> entityToModelList(List<PersonEntity> personEntityList);





}
