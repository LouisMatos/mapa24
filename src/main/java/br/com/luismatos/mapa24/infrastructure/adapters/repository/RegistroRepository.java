package br.com.luismatos.mapa24.infrastructure.adapters.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luismatos.mapa24.infrastructure.adapters.repository.entity.RegistroEntity;

@Repository
public interface RegistroRepository extends JpaRepository<RegistroEntity, Long> {

}
