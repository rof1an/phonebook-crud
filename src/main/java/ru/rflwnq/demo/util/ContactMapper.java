package ru.rflwnq.demo.util;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.rflwnq.demo.dto.ContactDto;
import ru.rflwnq.demo.entity.Contact;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    @InheritInverseConfiguration
    ContactDto toDto(Contact contact);

    Contact toModel(ContactDto contactDto);

    List<ContactDto> toDtoList(List<Contact> allContacts);
    List<Contact> toModelList(List<ContactDto> contactDtos);
}
