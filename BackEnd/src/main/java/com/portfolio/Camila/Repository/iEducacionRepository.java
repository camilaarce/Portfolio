package com.portfolio.Camila.Repository;

import com.portfolio.Camila.Entity.Educacions;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iEducacionRepository extends JpaRepository<Educacions, Integer>{
    public Optional<Educacions> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
}