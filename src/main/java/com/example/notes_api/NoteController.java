package com.example.notes_api;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "http://localhost:4200")
public class NoteController {

    private final NoteRepository repository;

    public NoteController(NoteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return repository.save(note);
    }
}