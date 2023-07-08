package com.example.Book.My.Show.Dtos.RequestDtos;


import com.example.Book.My.Show.Enums.Gender;
import lombok.Data;

@Data
public class UserEntryDto {


    private String name;
    private Integer age;
    private String address;
    private String mobileNo;
    private String emailId;
    private Gender gender;

}
