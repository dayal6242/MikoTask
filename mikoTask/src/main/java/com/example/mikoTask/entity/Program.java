package com.example.mikoTask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String programText;
    private String result;
	public Program() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Program(Long id, String programText, String result) {
		super();
		this.id = id;
		this.programText = programText;
		this.result = result;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProgramText() {
		return programText;
	}
	public void setProgramText(String programText) {
		this.programText = programText;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

    
}

