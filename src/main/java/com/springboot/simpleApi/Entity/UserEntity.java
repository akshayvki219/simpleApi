package com.springboot.simpleApi.Entity;


import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document (collection = "userTable")
public class UserEntity {
    @Id
    private ObjectId id;
   @NonNull
   @Indexed(unique = true)
   private String userName;
    @NonNull
    private  String password;

    @DBRef
    private List<simpleEntry> simpleEntries=new ArrayList<>();

    public List<simpleEntry> getSimpleEntries() {
        return simpleEntries;
    }

    public void setSimpleEntries(List<simpleEntry> simpleEntries) {
        this.simpleEntries = simpleEntries;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
