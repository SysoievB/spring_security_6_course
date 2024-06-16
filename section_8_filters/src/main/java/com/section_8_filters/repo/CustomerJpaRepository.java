package com.section_8_filters.repo;

import com.section_8_filters.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, Integer> {

    Customer findByEmail(String email);
}