package ru.rflwnq.demo.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rflwnq.demo.entity.Contact;
import ru.rflwnq.demo.repository.ContactRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAllByOrderById();
    }

    public Contact getContactById(long id) {
        Optional<Contact> contactById = contactRepository.findById(id);
        return contactById.orElseThrow(() ->
                new EntityNotFoundException(String.format("Entity with id = %d not found", id)));
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(long id, Contact newContact) {
        Contact existingContact = getContactById(id);

        existingContact = Contact.builder()
                .id(existingContact.getId())
                .firstName(newContact.getFirstName())
                .lastName(newContact.getLastName())
                .phoneNumber(newContact.getPhoneNumber())
                .photoUrl(newContact.getPhotoUrl())
                .build();
        return contactRepository.save(existingContact);
    }
}
