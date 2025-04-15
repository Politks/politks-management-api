package br.com.politks.service;

import br.com.politks.dto.ElectionDTO;
import br.com.politks.mapper.ElectionMapper;
import br.com.politks.repository.ElectionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ElectionService {
    private final ElectionRepository repository;
    private final ElectionMapper mapper;

    public ElectionService(ElectionRepository repository, ElectionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public List<ElectionDTO> findAll() {
        return repository.findAll().stream()
            .map(mapper::toDTO)
            .toList();
    }

    public ElectionDTO findById(Long id) {
        return repository.findByIdOptional(id)
            .map(mapper::toDTO)
            .orElseThrow(() -> new RuntimeException("Election not found"));
    }

    @Transactional
    public ElectionDTO create(ElectionDTO dto) {
        var entity = mapper.toEntity(dto);
        repository.persist(entity);
        return mapper.toDTO(entity);
    }

    @Transactional
    public ElectionDTO update(Long id, ElectionDTO dto) {
        var entity = repository.findByIdOptional(id)
            .orElseThrow(() -> new RuntimeException("Election not found"));
        mapper.updateEntity(entity, dto);
        repository.persist(entity);
        return mapper.toDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
} 