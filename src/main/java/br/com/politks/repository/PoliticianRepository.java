package br.com.politks.repository;

import br.com.politks.entity.PoliticianEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PoliticianRepository implements PanacheRepository<PoliticianEntity> {}
