package com.section_12_oauth2_keycloak.controller;

import com.section_12_oauth2_keycloak.entity.Contact;
import com.section_12_oauth2_keycloak.repo.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
@AllArgsConstructor
public class ContactController {
    private final ContactRepository contactRepository;

    @PostMapping("/contact")
    //@PreFilter("filterObject.contactName !='Test'")
    @PostFilter("filterObject.contactName !='Test'")
    public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
        contact.setContactId("SR" + new Random().nextInt(999999999 - 9999) + 9999);
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return contactRepository.save(contact);
    }
}
