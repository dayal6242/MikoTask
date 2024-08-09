package com.example.mikoTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mikoTask.entity.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
}

