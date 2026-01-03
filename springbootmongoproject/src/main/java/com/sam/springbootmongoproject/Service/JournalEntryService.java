package com.sam.springbootmongoproject.Service;

import com.sam.springbootmongoproject.Entity.JournalEntry;
import com.sam.springbootmongoproject.Repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    public JournalEntryRepository journalEntryRepository;

    @Autowired
    JournalEntry journalEntry;

    public List<JournalEntry> listEntry(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getJournalEntry(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public void deleteEntry(ObjectId id){
        journalEntryRepository.deleteById(id);
    }
}
