package com.example.mikoTask.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mikoTask.entity.Program;
import com.example.mikoTask.repository.ProgramRepository;

@Service
public class AssemblyService {

    @Autowired
    private ProgramRepository programRepository;

    private Map<String, Integer> registers = new HashMap<>();

    public String executeProgram(String programText) {
        registers.clear(); // Clear the registers for a fresh execution

        String[] instructions = programText.split("\n");
        for (String instruction : instructions) {
            parseInstruction(instruction.trim());
        }
        return registers.toString();
    }

    private void parseInstruction(String instruction) {
        if (instruction.startsWith("MV")) {
            String[] parts = instruction.split(",");
            String register = parts[0].split(" ")[1];
            int value = Integer.parseInt(parts[1].replace("#", ""));
            registers.put(register, value);
        } else if (instruction.startsWith("ADD")) {
            String[] parts = instruction.split(",");
            String register1 = parts[0].split(" ")[1];

            registers.putIfAbsent(register1, 0);

            if (parts[1].matches("\\d+")) { // Check if it's a constant
                int value = Integer.parseInt(parts[1]);
                registers.put(register1, registers.get(register1) + value);
            } else {
                String register2 = parts[1];
                registers.putIfAbsent(register2, 0);
                registers.put(register1, registers.get(register1) + registers.get(register2));
            }
        } else if (instruction.startsWith("SHOW")) {
            String register = instruction.split(" ")[1];
            System.out.println(register + " = " + registers.getOrDefault(register, 0));
        }
    }

    public Program saveProgram(String programText) {
        String result = executeProgram(programText);
        Program program = new Program();
        program.setProgramText(programText);
        program.setResult(result);
        return programRepository.save(program);
    }
}


