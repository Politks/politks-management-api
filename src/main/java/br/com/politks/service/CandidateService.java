package br.com.politks.service;

import br.com.politks.dto.CandidateDTO;
import br.com.politks.dto.CandidateRequestDTO;
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

  @Transactional
  public List<CandidateDTO> findAll() {
    return repository.findAll().stream().map(mapper::toDTO).toList();
  }

  @Transactional
  public List<CandidateDTO> findAllPaginated(int page, int size) {
    return repository.findAll().page(page, size).stream().map(mapper::toDTO).toList();
  }

  public long count() {
    return repository.count();
  }

  public CandidateDTO findById(Long id) {
    return repository
        .findByIdOptional(id)
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
  public CandidateDTO createFromRequest(CandidateRequestDTO requestDTO) {
    var entity = mapper.toEntity(requestDTO);
    repository.persist(entity);
    return mapper.toDTO(entity);
  }

  @Transactional
  public CandidateDTO update(Long id, CandidateDTO dto) {
    var entity =
        repository
            .findByIdOptional(id)
            .orElseThrow(() -> new RuntimeException("Candidate not found"));
    mapper.updateEntity(entity, dto);
    repository.persist(entity);
    return mapper.toDTO(entity);
  }

  @Transactional
  public CandidateDTO updateFromRequest(Long id, CandidateRequestDTO requestDTO) {
    var entity =
        repository
            .findByIdOptional(id)
            .orElseThrow(() -> new RuntimeException("Candidate not found"));
    mapper.updateEntity(entity, requestDTO);
    repository.persist(entity);
    return mapper.toDTO(entity);
  }

  @Transactional
  public void delete(Long id) {
    repository.deleteById(id);
  }
}
