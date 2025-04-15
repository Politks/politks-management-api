package br.com.politks.service;

import br.com.politks.dto.CandidateDTO;
import br.com.politks.mapper.CandidateMapper;
import br.com.politks.repository.CandidateRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CandidateService {
    private final CandidateRepository repository;
    private final CandidateMapper mapper;

    public CandidateService(CandidateRepository repository, CandidateMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CandidateDTO> findAll() {
        return repository.findAll().stream()
            .map(mapper::toDTO)
            .toList();
    }

    public CandidateDTO findById(Long id) {
        return repository.findByIdOptional(id)
            .map(mapper::toDTO)
            .orElseThrow(() -> new RuntimeException("Candidate not found"));
    }

    @Transactional
    public CandidateDTO create(CandidateDTO dto) {
        var entity = mapper.toEntity(dto);
        repository.persist(entity);
        return mapper.toDTO(entity);
    }

    @Transactional
    public CandidateDTO update(Long id, CandidateDTO dto) {
        var entity = repository.findByIdOptional(id)
            .orElseThrow(() -> new RuntimeException("Candidate not found"));
        mapper.updateEntity(entity, dto);
        repository.persist(entity);
        return mapper.toDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
} 