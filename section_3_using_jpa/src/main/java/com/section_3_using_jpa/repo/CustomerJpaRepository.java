package com.section_3_using_jpa.repo;

import com.section_3_using_jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, Integer> {

    Customer findByEmail(String email);
}