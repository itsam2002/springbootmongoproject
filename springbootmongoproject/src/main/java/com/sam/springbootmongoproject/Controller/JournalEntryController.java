package com.sam.springbootmongoproject.Controller;

import com.sam.springbootmongoproject.Entity.JournalEntry;
import com.sam.springbootmongoproject.Service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journals")
public class JournalEntryController {

    @Autowired
    public Optional<JournalEntry> journalEntry;

    @Autowired
    public JournalEntryService journalEntryService;

//    @GetMapping
//    public ResponseEntity<?> getJournals(){
//        List<JournalEntry> allJournals = journalEntryService.listEntry();
//        if(allJournals != null && allJournals.isEmpty()){
//            return new ResponseEntity<>(allJournals, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @GetMapping
    public ResponseEntity<List<JournalEntry>> getAllJournals(){
        List<JournalEntry> all = journalEntryService.listEntry();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<JournalEntry>> getJournalById(@PathVariable ObjectId id){
       Optional<JournalEntry> journalEntry = journalEntryService.getJournalEntry(id);
       if(!journalEntry.isPresent()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       } else {
           return new ResponseEntity<>(journalEntry, HttpStatus.OK);
       }
//       if (journalEntry.isPresent()){
//           return new ResponseEntity<>(journalEntry, HttpStatus.OK);
//       }
//       else{
//           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//       }
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createJournal(@RequestBody JournalEntry journalEntry){
        try{
            journalEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(journalEntry);
            return new ResponseEntity<>(journalEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteJournalEntry(@PathVariable ObjectId id){
        journalEntryService.deleteEntry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateJournal(@PathVariable ObjectId id, @RequestBody JournalEntry newentry){
        JournalEntry oldentry = journalEntryService.getJournalEntry(id).orElse(null);
        if(oldentry != null){
            oldentry.setTitle(newentry.getTitle() != null && !newentry.getTitle().equals("")
                    ? newentry.getTitle()
                    : oldentry.getTitle());

            oldentry.setContent(newentry.getContent() != null && !newentry.getContent().equals("")
                    ? newentry.getContent()
                    : oldentry.getContent());

            journalEntryService.saveEntry(oldentry);
            return new ResponseEntity<>(oldentry, HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
