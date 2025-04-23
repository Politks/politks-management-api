package br.com.politks.repository;

import br.com.politks.entity.CandidateEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CandidateRepository implements PanacheRepository<CandidateEntity> {}
