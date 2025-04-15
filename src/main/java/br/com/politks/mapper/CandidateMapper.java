package br.com.politks.mapper;

import br.com.politks.dto.CandidateDTO;
import br.com.politks.entity.CandidateEntity;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Objects;

@ApplicationScoped
public class CandidateMapper {
    public CandidateDTO toDTO(CandidateEntity entity) {
        Objects.requireNonNull(entity);
        return new CandidateDTO(
            entity.id,
            (long) entity.getPoliticianId(),
            (long) entity.getElectionId(),
            entity.getVotes(),
            entity.getNumber(),
            entity.getResult()
        );
    }

    public CandidateEntity toEntity(CandidateDTO dto) {
        CandidateEntity entity = new CandidateEntity();
        updateEntity(entity, dto);
        return entity;
    }

    public void updateEntity(CandidateEntity entity, CandidateDTO dto) {
        entity.setPoliticianId(dto.politicianId().intValue());
        entity.setElectionId(dto.electionId().intValue());
        entity.setVotes(dto.votes());
        entity.setNumber(dto.number());
        entity.setResult(dto.result());
    }
} 