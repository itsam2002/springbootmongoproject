package com.sam.springbootmongoproject.Controller;

import com.sam.springbootmongoproject.Entity.JournalEntry;
import com.sam.springbootmongoproject.Service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    public JournalEntry journalEntry;

    @Autowired
    public JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getJournals(){
        return journalEntryService.listEntry();
    }

    @GetMapping("{id}")
    public JournalEntry getJournalById(@PathVariable ObjectId id){
        return journalEntryService.getJournalEntry(id).orElse(null);
    }

    @PostMapping
    public JournalEntry createJournal(@RequestBody JournalEntry journalEntry){
        journalEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(journalEntry);
        return journalEntry;
    }

    @DeleteMapping("{id}")
    public void deleteJournalEntry(@PathVariable ObjectId id){
        journalEntryService.deleteEntry(id);
    }

    @PutMapping("{id}")
    public JournalEntry updateJournal(@PathVariable ObjectId id, @RequestBody JournalEntry newentry){
        JournalEntry oldentry = journalEntryService.getJournalEntry(id).orElse(null);
        if(oldentry != null){
            oldentry.setTitle(newentry.getTitle() != null && !newentry.getTitle().equals("")
                    ? newentry.getTitle()
                    : oldentry.getTitle());

            oldentry.setContent(newentry.getContent() != null && !newentry.getContent().equals("")
                    ? newentry.getContent()
                    : oldentry.getContent());
        }
        journalEntryService.saveEntry(oldentry);
        return oldentry;
    }

}
