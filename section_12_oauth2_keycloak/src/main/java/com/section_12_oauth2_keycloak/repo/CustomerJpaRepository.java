package com.section_12_oauth2_keycloak.repo;

import com.section_12_oauth2_keycloak.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, Integer> {

    Customer findByEmail(String email);
}