package ru.rflwnq.demo.dto;

import lombok.Data;

@Data
public class ContactDto {
    private long id;
    private String firstName;
    private String lastName;
    private String photoUrl = "https://pic.rutubelist.ru/video/46/b2/46b25de0bf3d3fa60a22037e55071354.jpg";
    private String phoneNumber;
}
