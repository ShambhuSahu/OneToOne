package com.example.onetoonemapping.service;

import com.example.onetoonemapping.entity.AddressEntity;
import com.example.onetoonemapping.entity.PersonEntity;
import com.example.onetoonemapping.mapper.AddressMapper;
import com.example.onetoonemapping.mapper.PersonMapper;
import com.example.onetoonemapping.model.AddressRequest;
import com.example.onetoonemapping.model.PersonRequest;
import com.example.onetoonemapping.model.PersonResponse;
import com.example.onetoonemapping.repository.AddressRepository;
import com.example.onetoonemapping.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class PersonService {

    private final PersonMapper personMapper;
    private final AddressMapper addressMapper;
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    public PersonService(PersonMapper personMapper, AddressMapper addressMapper, PersonRepository personRepository, AddressRepository addressRepository) {
        this.personMapper = personMapper;
        this.addressMapper = addressMapper;
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public PersonRequest createPerson(PersonRequest personRequest) {

        AddressEntity addressEntity=new AddressEntity();
        addressEntity.setAddress1(personRequest.getAddresst().getAddress1());
        addressEntity.setCity(personRequest.getAddresst().getCity());
        addressEntity.setState(personRequest.getAddresst().getState());
        addressEntity.setZip(personRequest.getAddresst().getZip());
        addressRepository.save(addressEntity);

        PersonEntity personEntity= personMapper.modelToEntity(personRequest);
        personEntity.setAddressEntity(addressEntity);
        personRepository.save(personEntity);


        PersonRequest personRequest1=personMapper.entityToModel(personEntity);
        return personRequest1;

    }

    public PersonRequest getPersonById(Long personId) {

        PersonRequest personRequest=new PersonRequest();
        AddressRequest addressRequest=new AddressRequest();

        Optional<PersonEntity> personEntity=personRepository.findById(personId);
        Optional<AddressEntity> addressEntity=addressRepository.findById(personEntity.get().getAddressEntity().getAddressId());

        if (personEntity.isPresent()&&addressEntity.isPresent())
        {
                addressRequest.setAddress1(addressEntity.get().getAddress1());
                addressRequest.setState(addressEntity.get().getState());
                addressRequest.setState(addressEntity.get().getState());
                addressRequest.setCity(addressEntity.get().getCity());
                addressRequest.setZip(addressEntity.get().getZip());
                personRequest.setFirstname(personEntity.get().getFirstname());
                personRequest.setLastName(personEntity.get().getLastName());
                personRequest.setAddresst(addressRequest);
        }
             return personRequest;

    }

    public PersonResponse updatePerson(Long personId, PersonRequest personRequest) {


        Optional<PersonEntity> personEntity=personRepository.findById(personId);
        personEntity.get().setFirstname(personRequest.getFirstname());
        personEntity.get().setLastName(personRequest.getLastName());
        personEntity.get().setPersonId(personId);

        Optional<AddressEntity> addressEntity=addressRepository.findById(personEntity.get().getAddressEntity().getAddressId());


        addressEntity.get().setAddress1(personRequest.getAddresst().getAddress1());
        addressEntity.get().setState(personRequest.getAddresst().getState());
        addressEntity.get().setCity(personRequest.getAddresst().getCity());
        addressEntity.get().setZip(personRequest.getAddresst().getZip());

        personEntity.get().setAddressEntity(addressEntity.get());

        addressRepository.save(addressEntity.get());
        personRepository.save(personEntity.get());



        PersonResponse personResponse=new PersonResponse();
        personResponse.setPersonId(personEntity.get().getPersonId());


        return personResponse;
    }

    public List<PersonRequest> getAllPerson() {

        List<PersonEntity> personEntityList=personRepository.findAll();
        List<AddressEntity> addressEntityList=addressRepository.findAll();
        log.info(addressEntityList);


        List<PersonRequest> personRequestList=personMapper.entityToModelList(personEntityList);
        List<AddressRequest> addressRequestList=addressMapper.entityToModelList(addressEntityList);
       return personRequestList;



    }
}
