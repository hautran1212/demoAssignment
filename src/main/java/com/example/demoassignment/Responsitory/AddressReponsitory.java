package com.example.demoassignment.Responsitory;

import com.example.demoassignment.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressReponsitory extends JpaRepository<Address, Long> {
}
