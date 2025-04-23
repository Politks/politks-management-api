package br.com.politks.entity;

import br.com.politks.enums.Municipality;
import br.com.politks.enums.Position;
import br.com.politks.enums.UF;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "election")
@Data
@EqualsAndHashCode(callSuper = true)
public class ElectionEntity extends PanacheEntity {
  @Enumerated(EnumType.STRING)
  private UF uf;

  @Enumerated(EnumType.STRING)
  private Municipality municipality;

  @Enumerated(EnumType.STRING)
  private Position position;

  @OneToMany(mappedBy = "election")
  private List<CandidateEntity> candidates;
}
