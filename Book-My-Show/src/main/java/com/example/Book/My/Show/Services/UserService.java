package com.example.Book.My.Show.Services;

import com.example.Book.My.Show.Dtos.RequestDtos.UserEntryDto;
import com.example.Book.My.Show.Exceptions.UserAlreadyExistsWithEmail;
import com.example.Book.My.Show.Models.User;
import com.example.Book.My.Show.Repositories.UserRepository;
import com.example.Book.My.Show.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto) throws UserAlreadyExistsWithEmail {
        if(userRepository.findByEmailId(userEntryDto.getEmailId()) != null) {
            throw new UserAlreadyExistsWithEmail();
        }
        User user = UserTransformer.userDtoToUser(userEntryDto);

        userRepository.save(user);
        return "User Saved Successfully";
    }
}
