package br.com.politks.mapper;

import br.com.politks.entity.PoliticianEntity;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Objects;
import br.com.politks.dto.PoliticianDTO;

@ApplicationScoped
public class PoliticianMapper {
  public PoliticianDTO toDTO(PoliticianEntity entity) {
    Objects.requireNonNull(entity);

    return new PoliticianDTO(null, null, null, null, null);
  }

  public PoliticianEntity toEntity(PoliticianDTO politicianDTO) {
    return PoliticianEntity.builder()
        .name(politicianDTO.name())
        .build();
  }

  public void updateEntity(PoliticianEntity entity, PoliticianDTO dto) {
    entity.setName(dto.name());
  }
}
