package ru.rflwnq.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rflwnq.demo.dto.ContactDto;
import ru.rflwnq.demo.entity.Contact;
import ru.rflwnq.demo.service.ContactService;
import ru.rflwnq.demo.util.ContactMapper;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    private final ContactService contactService;
    private final ContactMapper mapper;

    @Autowired
    public ContactController(ContactService contactService, ContactMapper mapper) {
        this.contactService = contactService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ContactDto> getAllContacts() {
        List<Contact> allContacts = contactService.getAllContacts();
        return mapper.toDtoList(allContacts);
    }

    @PostMapping
    public ContactDto createContact(@RequestBody ContactDto contactDto) {
        Contact newContact = mapper.toModel(contactDto);
        Contact addedContact = contactService.createContact(newContact);
        return mapper.toDto(addedContact);
    }

    @PutMapping("{id}")
    public ContactDto changeContact(@PathVariable("id") long id, @RequestBody ContactDto contactDto) {
        Contact existingContact = contactService.getContactById(id);
        Contact newContact = mapper.toModel(contactDto);

        BeanUtils.copyProperties(newContact, existingContact, "id");
        Contact returnedContact = contactService.updateContact(existingContact);

        return mapper.toDto(returnedContact);
    }
}
