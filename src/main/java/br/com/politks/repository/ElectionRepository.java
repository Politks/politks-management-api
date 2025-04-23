package br.com.politks.repository;

import br.com.politks.entity.ElectionEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ElectionRepository implements PanacheRepository<ElectionEntity> {}
