package br.com.politks.mapper;

import br.com.politks.dto.CandidateDTO;
import br.com.politks.dto.CandidateRequestDTO;
import br.com.politks.entity.CandidateEntity;
import br.com.politks.entity.ElectionEntity;
import br.com.politks.entity.PoliticianEntity;
import br.com.politks.repository.ElectionRepository;
import br.com.politks.repository.PoliticianRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Objects;

@ApplicationScoped
public class CandidateMapper {
  private final ElectionRepository electionRepository;
  private final PoliticianRepository politicianRepository;

  public CandidateMapper(
      ElectionRepository electionRepository, PoliticianRepository politicianRepository) {
    this.electionRepository = electionRepository;
    this.politicianRepository = politicianRepository;
  }

  public CandidateDTO toDTO(CandidateEntity entity) {
    Objects.requireNonNull(entity);
    return new CandidateDTO(
        entity.id,
        entity.getPolitician().id,
        entity.getElection().id,
        entity.getVotes(),
        entity.getNumber(),
        entity.getResult());
  }

  public CandidateEntity toEntity(CandidateDTO dto) {
    CandidateEntity entity = new CandidateEntity();
    updateEntity(entity, dto);
    return entity;
  }

  public CandidateEntity toEntity(CandidateRequestDTO dto) {
    CandidateEntity entity = new CandidateEntity();
    updateEntity(entity, dto);
    return entity;
  }

  public void updateEntity(CandidateEntity entity, CandidateDTO dto) {
    PoliticianEntity politician =
        politicianRepository
            .findByIdOptional(dto.politicianId())
            .orElseThrow(() -> new RuntimeException("Politician not found"));
    ElectionEntity election =
        electionRepository
            .findByIdOptional(dto.electionId())
            .orElseThrow(() -> new RuntimeException("Election not found"));

    entity.setPolitician(politician);
    entity.setElection(election);
    entity.setVotes(dto.votes());
    entity.setNumber(dto.number());
    entity.setResult(dto.result());
  }

  public void updateEntity(CandidateEntity entity, CandidateRequestDTO dto) {
    PoliticianEntity politician =
        politicianRepository
            .findByIdOptional(dto.politicianId())
            .orElseThrow(() -> new RuntimeException("Politician not found"));
    ElectionEntity election =
        electionRepository
            .findByIdOptional(dto.electionId())
            .orElseThrow(() -> new RuntimeException("Election not found"));

    entity.setPolitician(politician);
    entity.setElection(election);
    entity.setVotes(dto.votes());
    entity.setNumber(dto.number());
    entity.setResult(dto.result());
  }
}
