package com.sam.springbootmongoproject.Controller;

import com.sam.springbootmongoproject.Entity.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/journals")
public class JournalEntryController {

    @Autowired
    JournalEntry journalEntry;

    public HashMap<Long, JournalEntry> journals = new HashMap<>();

    @GetMapping("entries")
    public List<JournalEntry> getJournals(){
        return new ArrayList<>(journals.values());
    }

    @PostMapping("entries")
    public String createJournals(@RequestBody JournalEntry journalEntry){
        journals.put(journalEntry.getId(), journalEntry);
        return "Record inserted to DB";
    }

    @PutMapping("{myid}")
    public JournalEntry updateJournal(@PathVariable Long myid, @RequestBody JournalEntry journalEntry){
        return journals.put(myid, journalEntry);
    }

    @DeleteMapping("{myid}")
    public String deleteJournal(@PathVariable Long myid){
        journals.remove(myid, journalEntry);
        return "Record deleted from DB";
    }
}
