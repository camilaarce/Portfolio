package com.portfolio.Camila.Repository;

import com.portfolio.Camila.Entity.Experiencias;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencias, Integer>{
    public Optional<Experiencias> findByEmpleado(String empleado);
    public boolean existsByEmpleado(String empleado);
}
