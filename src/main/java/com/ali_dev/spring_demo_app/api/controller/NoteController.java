package com.ali_dev.spring_demo_app.api.controller;

import com.ali_dev.spring_demo_app.NoteRepo;
import com.ali_dev.spring_demo_app.api.model.NoteRequest;
import com.ali_dev.spring_demo_app.api.model.NoteResponse;
import com.ali_dev.spring_demo_app.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController (NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public NoteRequest create (@RequestBody NoteRequest noteRequest) {
        NoteRequest newNote = noteService.create(noteRequest);
        return newNote;
    }

    @GetMapping
    public List<NoteResponse> getAllNotes () {
        List allNotes = noteService.getAllNotes();
        return allNotes;
    }

    @PutMapping("/{page}")
    public void update(
            @PathVariable Integer page,
            @RequestBody NoteRequest noteRequest
    ) {
        noteService.update(page, noteRequest);
    }
}
