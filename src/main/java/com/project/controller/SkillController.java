package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.NotFoundException;
import com.project.model.Skill;
import com.project.repository.SkillRepository;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
	
	@Autowired
	SkillRepository skillRepository;

	@GetMapping
	public List<Skill> getSkills() {
		return skillRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Skill getSkill(@PathVariable("id") Long id) throws NotFoundException {
		return skillRepository.findById(id).orElseThrow(() -> new NotFoundException("Skill", "id", id));
	}
	
	@PostMapping
	public Skill createSkill(@RequestBody Skill skill) {
		return skillRepository.save(skill);
	}

	@PutMapping("/{id}")
	public Skill updateSkill(@PathVariable("id") Long id, @RequestBody Skill details) throws NotFoundException {
		Skill skill = skillRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Skill", "id", id));

		skill.setSkillName(details.getSkillName());
		skill.setDescription(details.getDescription());
		
		return skillRepository.save(skill);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSkill(@PathVariable("id") Long id) {
		skillRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
