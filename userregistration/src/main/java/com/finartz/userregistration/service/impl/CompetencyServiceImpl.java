package com.finartz.userregistration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.userregistration.entity.Competency;
import com.finartz.userregistration.entity.Evaluation;
import com.finartz.userregistration.exception.ResourceNotFoundException;
import com.finartz.userregistration.repository.CompetencyRepository;
import com.finartz.userregistration.repository.EvaluationRepository;
import com.finartz.userregistration.request.CreateCompetencyRequest;
import com.finartz.userregistration.service.CompetencyService;

@Service
public class CompetencyServiceImpl implements CompetencyService{

    @Autowired 
    CompetencyRepository competencyRepository;

    @Autowired
    EvaluationRepository evaluationRepository;

    @Override
    public Competency saveCompetency(CreateCompetencyRequest competencyRequest) {
        Long evaluationId = competencyRequest.getEvaluationId();
        Evaluation evaluation = evaluationRepository.findById(evaluationId).orElseThrow(() -> new ResourceNotFoundException("Evaluation not found with id: " + evaluationId));

        Competency competency = Competency.builder()
        .name(competencyRequest.getName())
        .description(competencyRequest.getDescription())
        .evaluation(evaluation)
        .build();

        return competencyRepository.save(competency);
    }

    @Override
    public void deleteCompetency(Long id) {
        Competency competency = competencyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Competency not found with id: " + id));

        competencyRepository.delete(competency);
    }


    @Override
    public List<Competency> getAllCompetencies() {
        return competencyRepository.findAll();
    }

    @Override
    public Competency updateCompetency(Long id, CreateCompetencyRequest competencyRequest) {
        Competency updatedCompetency = competencyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Competency not found with id: " + id));

        Evaluation evaluation = evaluationRepository.findById(competencyRequest.getEvaluationId()).orElseThrow(() -> new ResourceNotFoundException("Evaluation not found with id: " + id));

        updatedCompetency.setName(competencyRequest.getName());
        updatedCompetency.setDescription(competencyRequest.getDescription());
        updatedCompetency.setEvaluation(evaluation);

        return competencyRepository.save(updatedCompetency);
    }
}
