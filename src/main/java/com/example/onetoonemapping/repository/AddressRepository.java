package com.example.onetoonemapping.repository;

import com.example.onetoonemapping.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Long> {


}
