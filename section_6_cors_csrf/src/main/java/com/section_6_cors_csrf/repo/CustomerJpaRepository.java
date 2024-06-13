package com.section_6_cors_csrf.repo;

import com.section_6_cors_csrf.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, Integer> {

    Customer findByEmail(String email);
}