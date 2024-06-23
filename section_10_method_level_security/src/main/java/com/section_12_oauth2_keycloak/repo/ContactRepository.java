package com.section_12_oauth2_keycloak.repo;

import com.section_12_oauth2_keycloak.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
}
