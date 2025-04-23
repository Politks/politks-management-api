package br.com.politks.mapper;

import br.com.politks.dto.PoliticianDTO;
import br.com.politks.dto.PoliticianRequestDTO;
import br.com.politks.entity.PoliticianEntity;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Objects;

@ApplicationScoped
public class PoliticianMapper {
  public PoliticianDTO toDTO(PoliticianEntity entity) {
    Objects.requireNonNull(entity);
    return new PoliticianDTO(entity.id, entity.getName(), entity.getPhoto(), entity.getFullName());
  }

  public PoliticianEntity toEntity(PoliticianDTO dto) {
    return PoliticianEntity.builder()
        .name(dto.name())
        .photo(dto.photo())
        .fullName(dto.fullname())
        .build();
  }

  public PoliticianEntity toEntity(PoliticianRequestDTO dto) {
    return PoliticianEntity.builder()
        .name(dto.name())
        .photo(dto.photo())
        .fullName(dto.fullname())
        .build();
  }

  public void updateEntity(PoliticianEntity entity, PoliticianDTO dto) {
    entity.setName(dto.name());
    entity.setPhoto(dto.photo());
    entity.setFullName(dto.fullname());
  }

  public void updateEntity(PoliticianEntity entity, PoliticianRequestDTO dto) {
    entity.setName(dto.name());
    entity.setPhoto(dto.photo());
    entity.setFullName(dto.fullname());
  }
}
