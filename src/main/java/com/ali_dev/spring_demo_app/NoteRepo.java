package com.ali_dev.spring_demo_app;

import com.ali_dev.spring_demo_app.persistence.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepo extends JpaRepository<NoteEntity, Long> {
    Optional<NoteEntity> findByPage(Integer page);
}
