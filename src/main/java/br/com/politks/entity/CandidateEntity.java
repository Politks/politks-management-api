package br.com.politks.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "candidate", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"politicianId", "electionId"})
})
@Data
@EqualsAndHashCode(callSuper = true)
public class CandidateEntity extends PanacheEntity {
    private int politicianId;
    private int electionId;
    private int votes;
    private int number;
    private ElectionResult result;
}
