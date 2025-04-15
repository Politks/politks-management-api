package org.acme.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.Objects;
import org.acme.dto.PoliticianDTO;
import org.acme.entity.PoliticianEntity;

@ApplicationScoped
public class PoliticianMapper {
  public PoliticianDTO toDTO(PoliticianEntity entity) {
    Objects.requireNonNull(entity);

    return new PoliticianDTO(
        entity.getName(),
        entity.getPhone(),
        entity.getEmail(),
        entity.getAddress(),
        entity.getAge());
  }

  public PoliticianEntity toEntity(PoliticianDTO politicianDTO) {
    return PoliticianEntity.builder()
        .name(politicianDTO.name())
        .phone(politicianDTO.phone())
        .email(politicianDTO.email())
        .address(politicianDTO.address())
        .age(politicianDTO.age())
        .build();
  }

  public void updateEntity(PoliticianEntity entity, PoliticianDTO dto) {
    entity.setName(dto.name());
    entity.setPhone(dto.phone());
    entity.setEmail(dto.email());
    entity.setAddress(dto.address());
    entity.setAge(dto.age());
  }
}
