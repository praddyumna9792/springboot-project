package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}
