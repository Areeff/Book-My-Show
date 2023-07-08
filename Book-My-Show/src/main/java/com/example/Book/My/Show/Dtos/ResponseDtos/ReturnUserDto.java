package com.example.Book.My.Show.Dtos.ResponseDtos;

import com.example.Book.My.Show.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnUserDto {

    private String name;
    private Integer age;
    private Gender gender;
    private String address;
}
