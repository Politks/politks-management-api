package br.com.politks.service;

import br.com.politks.dto.PoliticianDTO;
import br.com.politks.mapper.PoliticianMapper;
import br.com.politks.repository.PoliticianRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PoliticianService {
  private final PoliticianRepository repository;
  private final PoliticianMapper mapper;

  public PoliticianService(PoliticianRepository repository, PoliticianMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Transactional
  public List<PoliticianDTO> findAll() {
    return repository.findAll().stream()
        .map(mapper::toDTO)
        .toList();
  }
  
  @Transactional
  public List<PoliticianDTO> findAllPaginated(int page, int size) {
    return repository.findAll().page(page, size).stream()
        .map(mapper::toDTO)
        .toList();
  }
  
  public long count() {
    return repository.count();
  }

  public PoliticianDTO findById(Long id) {
    return repository.findByIdOptional(id)
        .map(mapper::toDTO)
        .orElseThrow(() -> new RuntimeException("Politician not found"));
  }

  @Transactional
  public PoliticianDTO create(PoliticianDTO dto) {
    var entity = mapper.toEntity(dto);
    repository.persist(entity);
    return mapper.toDTO(entity);
  }

  @Transactional
  public PoliticianDTO update(Long id, PoliticianDTO dto) {
    var entity = repository.findByIdOptional(id)
        .orElseThrow(() -> new RuntimeException("Politician not found"));
    mapper.updateEntity(entity, dto);
    repository.persist(entity);
    return mapper.toDTO(entity);
  }

  @Transactional
  public void delete(Long id) {
    repository.deleteById(id);
  }
}
