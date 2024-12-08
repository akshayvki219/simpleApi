package com.springboot.simpleApi.Repository;

import com.springboot.simpleApi.Entity.simpleEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface simpleRepository extends MongoRepository<simpleEntry,ObjectId> {
    Optional<simpleEntry> findById(ObjectId id);

}
