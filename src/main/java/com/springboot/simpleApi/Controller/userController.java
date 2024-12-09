package com.springboot.simpleApi.Controller;



import com.springboot.simpleApi.Entity.UserEntity;
import com.springboot.simpleApi.Services.userServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("userApi")
public class userController {
    @Autowired
    private userServices servicesOfUser;

    @GetMapping
    public List<UserEntity> getALlUserEntires(){
        return servicesOfUser.getAllUserEntries();
    }
    @PostMapping
    public void addUserEntry(@RequestBody UserEntity user){
         servicesOfUser.SaveUserEntry(user);
    }
    @PutMapping
    public ResponseEntity<?> UpdateUserEntity(@RequestBody UserEntity user){
        UserEntity user1=servicesOfUser.findByUserName(user.getUserName());

        if (user1!=null){
            user1.setUserName(user.getUserName());
            user1.setPassword((user.getPassword()));
            servicesOfUser.SaveUserEntry(user1);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }





}
