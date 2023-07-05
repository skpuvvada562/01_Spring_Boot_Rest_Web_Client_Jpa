package com.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.entity.AddressTbl;

@Repository
public interface AddressRepository extends JpaRepository<AddressTbl,Integer>{

}
