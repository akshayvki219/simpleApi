package com.springboot.simpleApi.Repository;


import com.springboot.simpleApi.Entity.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface userRepository extends MongoRepository<UserEntity, ObjectId> {
    UserEntity  findByUserName(String username);
}
