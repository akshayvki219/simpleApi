package com.springboot.simpleApi.Controller;


import ch.qos.logback.core.encoder.EchoEncoder;
import com.springboot.simpleApi.Entity.simpleEntry;
import com.springboot.simpleApi.Services.simpleServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("simpleApi")
public class simpleController {
     @Autowired
    private simpleServices services;


     @GetMapping
    public ResponseEntity<?> getAllEntries(){
         List<simpleEntry> All=services.getAllEntries();
       if(All!=null && !All.isEmpty()) {
           return new ResponseEntity<>(All, HttpStatus.FOUND);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }


     @PostMapping("/")
    public ResponseEntity<?> addEntries(@RequestBody simpleEntry Entry){
         try{
             services.save(Entry);
             return new ResponseEntity<>(Entry,HttpStatus.CREATED);

         }catch ( Exception e){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }



     }
     @GetMapping("id/{myId}")
     public ResponseEntity<simpleEntry> findById(@PathVariable ObjectId myId){
         Optional<simpleEntry> Entry= services.findEntryById(myId);
         if (Entry.isPresent()){
             return new  ResponseEntity<>(Entry.get(), HttpStatus.OK);
         }
         return new ResponseEntity<>(Entry.get(),HttpStatus.NOT_FOUND);
     }

     @DeleteMapping("/id/{myId}")
    public  ResponseEntity<?>  deleteEntryById(@PathVariable ObjectId myId){
         services.deleteEntry(myId);
         return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

     @PostMapping("id/{myId}")
    public ResponseEntity<?> updateEntry(@PathVariable ObjectId myId,@RequestBody simpleEntry newEntry){
         simpleEntry old=services.findEntryById(myId).orElse(null);
         if ( old!=null){
             old.setName(newEntry.getName()!=null && !newEntry.getName().equals(" ")? newEntry.getName() : old.getName());
             old.setCollege((newEntry.getCollege()!=null && !newEntry.getCollege().equals(" "))? newEntry.getCollege() : old.getCollege());
             return new ResponseEntity<>(old,HttpStatus.OK);
         }
         services.save(old);

         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }

}
