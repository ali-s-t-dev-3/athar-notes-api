package com.ali_dev.spring_demo_app.service;

import com.ali_dev.spring_demo_app.NoteRepo;
import com.ali_dev.spring_demo_app.api.model.NoteRequest;
import com.ali_dev.spring_demo_app.api.model.NoteResponse;
import com.ali_dev.spring_demo_app.persistence.NoteEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NoteService {

    private final NoteRepo noteRepo;

    public NoteService (NoteRepo noteRepo) {

        this.noteRepo = noteRepo;

    }

    public NoteRequest create(NoteRequest noteRequest) {
        NoteEntity noteEntity = new NoteEntity();

        noteEntity.setSection1(noteRequest.getSection1());
        noteEntity.setSection2(noteRequest.getSection2());
        noteEntity.setPage(noteRequest.getPage());

        noteRepo.save(noteEntity);

        return noteRequest;
    }

    public NoteRequest getNote () {

        return null;
    }

    public List<NoteResponse> getAllNotes() {
        List<NoteResponse> noteResponseList = new ArrayList<NoteResponse>();
        List<NoteEntity> noteEntityList = noteRepo.findAll();

        for (int i = 0; i < noteEntityList.size(); i++) {
            NoteEntity noteEntity = noteEntityList.get(i);

            NoteResponse noteResponse = new NoteResponse();

            noteResponse.setSection1(noteEntity.getSection1());
            noteResponse.setSection2(noteEntity.getSection2());
            noteResponse.setPage(noteEntity.getPage());

            noteResponseList.add(noteResponse);

        }
        return noteResponseList;
    }

    public void update(Integer page, NoteRequest noteRequest) {
        NoteEntity noteEntity = noteRepo.findByPage(page)
                .orElseGet(NoteEntity::new);

        noteEntity.setPage(page);
        noteEntity.setSection1(noteRequest.getSection1());
        noteEntity.setSection2(noteRequest.getSection2());

        noteRepo.save(noteEntity);
    }
}
