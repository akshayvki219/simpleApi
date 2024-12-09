package com.springboot.simpleApi.Services;


import com.springboot.simpleApi.Entity.simpleEntry;
import com.springboot.simpleApi.Repository.simpleRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class simpleServices {

    @Autowired
    private simpleRepository repo;
    public List<simpleEntry> getAllEntries() {
        return  repo.findAll();
    }

    public void save(simpleEntry newEntry, String userName) {
        repo.save(newEntry);
    }

    public void deleteEntry(ObjectId myId) {
        repo.deleteById(myId);
    }

    public Optional<simpleEntry> findEntryById(ObjectId myId) {
        return repo.findById(myId);
    }


}
