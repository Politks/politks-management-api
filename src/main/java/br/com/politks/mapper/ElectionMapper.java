package br.com.politks.mapper;

import br.com.politks.dto.ElectionDTO;
import br.com.politks.dto.ElectionRequestDTO;
import br.com.politks.entity.ElectionEntity;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class ElectionMapper {
    private final CandidateMapper candidateMapper;

    public ElectionMapper(CandidateMapper candidateMapper) {
        this.candidateMapper = candidateMapper;
    }

    public ElectionDTO toDTO(ElectionEntity entity) {
        Objects.requireNonNull(entity);
        return new ElectionDTO(
            entity.id,
            entity.getUf(),
            entity.getMunicipality(),
            entity.getPosition(),
            entity.getCandidates() != null ? entity.getCandidates().stream()
                .map(candidateMapper::toDTO)
                .collect(Collectors.toList()) : null
        );
    }

    public ElectionEntity toEntity(ElectionDTO dto) {
        ElectionEntity entity = new ElectionEntity();
        updateEntity(entity, dto);
        return entity;
    }
    
    public ElectionEntity toEntity(ElectionRequestDTO dto) {
        ElectionEntity entity = new ElectionEntity();
        updateEntity(entity, dto);
        return entity;
    }

    public void updateEntity(ElectionEntity entity, ElectionDTO dto) {
        entity.setUf(dto.uf());
        entity.setMunicipality(dto.municipality());
        entity.setPosition(dto.position());
    }
    
    public void updateEntity(ElectionEntity entity, ElectionRequestDTO dto) {
        entity.setUf(dto.uf());
        entity.setMunicipality(dto.municipality());
        entity.setPosition(dto.position());
    }
} 