package com.code.NotesAppAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.code.NotesAppAPI.model.NoteEntity;
import com.code.NotesAppAPI.repository.NoteRepository;

@Service
public class NoteService {
    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void createNote(NoteEntity note) {
        noteRepository.save(note);
    }

    public List<NoteEntity> getAllNotes() {
        return noteRepository.findAll();
    }

    public NoteEntity updateNote(int id, NoteEntity note) {
        note.setId(id);
        return noteRepository.save(note);
    }

    public void deleteNote(int id) {
        noteRepository.deleteById(id);
    }
}