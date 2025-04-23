package br.com.politks.entity;

import br.com.politks.enums.ElectionResult;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(
    name = "candidate",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"politicianId", "electionId"})})
@Data
@EqualsAndHashCode(callSuper = true)
public class CandidateEntity extends PanacheEntity {
  private int politicianId;
  private int electionId;
  private int votes;
  private int number;

  @Enumerated(EnumType.STRING)
  private ElectionResult result;
}
