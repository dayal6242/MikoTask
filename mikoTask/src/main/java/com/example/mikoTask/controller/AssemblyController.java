package com.example.mikoTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mikoTask.entity.Program;
import com.example.mikoTask.service.AssemblyService;

@RestController
@RequestMapping("/api/assembly")
public class AssemblyController {

    @Autowired
    private AssemblyService assemblyService;

    @PostMapping("/execute")
    public ResponseEntity<Program> executeProgram(@RequestBody String programText) {
        Program program = assemblyService.saveProgram(programText);
        return new ResponseEntity<>(program, HttpStatus.CREATED);
    }
}

