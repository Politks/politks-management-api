package br.com.politks.entity;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "election")
@Data
@EqualsAndHashCode(callSuper = true)
public class ElectionEntity  extends PanacheEntity {
    private UF uf;
    private Municipality municipality;
    private Position position;
    
    @OneToMany(mappedBy = "electionId")
    private List<CandidateEntity> candidates;
}
