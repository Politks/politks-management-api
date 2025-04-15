package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import org.acme.dto.PoliticianDTO;
import org.acme.mapper.PoliticianMapper;
import org.acme.repository.PoliticianRepository;

@ApplicationScoped
public class PoliticianService {
  private final PoliticianRepository repository;
  private final PoliticianMapper mapper;

  public PoliticianService(PoliticianRepository repository, PoliticianMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public List<PoliticianDTO> findAll() {
    return repository.findAll().stream().map(mapper::toDTO).toList();
  }

  public PoliticianDTO createNewCustomer(PoliticianDTO politicianDTO) {
    var entity = mapper.toEntity(politicianDTO);
    repository.persist(entity);
    return mapper.toDTO(entity);
  }

  public PoliticianDTO update(Long id, PoliticianDTO dto) {
    var entity = repository.findById(id);
    mapper.updateEntity(entity, dto);
    repository.persist(entity);
    return dto;
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }
}
