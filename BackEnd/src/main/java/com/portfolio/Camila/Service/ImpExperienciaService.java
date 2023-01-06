package com.portfolio.Camila.Service;

import com.portfolio.Camila.Entity.Experiencias;
import com.portfolio.Camila.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpExperienciaService {
     @Autowired
     IExperienciaRepository iexperienciaRepository;
     
     public List<Experiencias> list(){
         return iexperienciaRepository.findAll();
     }
     
     public Optional<Experiencias> getOne(int id){
         return iexperienciaRepository.findById(id);
     }
     
     public Optional<Experiencias> getByEmpleado(String empleado){
         return iexperienciaRepository.findByEmpleado(empleado);
     }
     
     public void save(Experiencias expe){
         iexperienciaRepository.save(expe);
     }
     
     public void delete(int id){
         iexperienciaRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return iexperienciaRepository.existsById(id);
     }
     
     public boolean existsByEmpleado(String empleado){
         return iexperienciaRepository.existsByEmpleado(empleado);
     }

    public void saveExperiencia(Experiencias experiencia) {
        iexperienciaRepository.save(experiencia);
    }
    
    public Experiencias findExperiencia(int id) {
        Experiencias experiencia = iexperienciaRepository.findById(id).orElse(null);
        return experiencia;
    }
}
