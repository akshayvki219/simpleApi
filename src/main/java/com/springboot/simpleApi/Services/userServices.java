package com.springboot.simpleApi.Services;

import com.springboot.simpleApi.Entity.UserEntity;
import com.springboot.simpleApi.Repository.userRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServices {

    @Autowired
    private userRepository userRepo;

    public List<UserEntity> getAllUserEntries(){
        return  userRepo.findAll();
    }
    public void  SaveUserEntry(UserEntity userEntry){
        userRepo.save(userEntry);
    }
    public void DeleteUserEntry(ObjectId id){
        userRepo.deleteById(id);
    }
    public Optional<UserEntity> findById(ObjectId id){
        return userRepo.findById(id);
    }
    public UserEntity findByUserName(String username){
        return  userRepo.findByUserName(username);
    }



}
