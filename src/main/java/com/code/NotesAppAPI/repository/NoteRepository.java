package com.code.NotesAppAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.NotesAppAPI.model.NoteEntity;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Integer> {
    
}