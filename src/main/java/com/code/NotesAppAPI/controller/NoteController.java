package com.code.NotesAppAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.NotesAppAPI.model.NoteEntity;
import com.code.NotesAppAPI.service.NoteService;

@RestController
@RequestMapping("api/notes")
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNote(@RequestBody NoteEntity note) {
        noteService.createNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body("Note created successfully!");
    }

    @GetMapping
    public ResponseEntity<List<NoteEntity>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<NoteEntity> updateNote(@PathVariable int id, @RequestBody NoteEntity note) {
        NoteEntity updatedNote = noteService.updateNote(id, note);
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable int id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok("Note deleted successfully!");
    }

}