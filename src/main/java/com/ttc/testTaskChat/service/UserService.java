package com.ttc.testTaskChat.service;

import com.ttc.testTaskChat.entity.User;
import com.ttc.testTaskChat.exception.NotFoundException;
import com.ttc.testTaskChat.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService{
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public int createNewUser(String name){
        User user = new User();
        user.setUsername(name);
        return repository.save(user).getId();
    }
    public void deleteUser(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new NotFoundException("User not found");
        }
    }
    public User findUserById(int id){
        return repository.findById(id).
                orElseThrow(()-> new NotFoundException("Not found user with id = "+id));
    }
}
