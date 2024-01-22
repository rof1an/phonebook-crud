package ru.rflwnq.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rflwnq.demo.entity.Contact;
import ru.rflwnq.demo.repository.ContactRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAllByOrderById();
    }
}
