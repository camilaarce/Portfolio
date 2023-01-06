package com.portfolio.Camila.Repository;

import com.portfolio.Camila.Entity.Personas;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Personas,Integer>{
    public Optional<Personas> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
