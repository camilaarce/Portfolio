package com.portfolio.Camila.Service;

import com.portfolio.Camila.Entity.Proyectos;
import com.portfolio.Camila.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectoService {
     @Autowired
     IProyectoRepository iproyectoRepository;
     
     public List<Proyectos> list(){
         return iproyectoRepository.findAll();
     }
     
     public Optional<Proyectos> getOne(int id){
         return iproyectoRepository.findById(id);
     }
     
     public Optional<Proyectos> getByTitulo(String titulo){
         return iproyectoRepository.findByNombre(titulo);
     }
     
     public void save(Proyectos proyecto){
         iproyectoRepository.save(proyecto);
     }
     
     public void delete(int id){
         iproyectoRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return iproyectoRepository.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return iproyectoRepository.existsByNombre(nombre);
     }

    public void saveProyecto(Proyectos proyecto) {
        iproyectoRepository.save(proyecto);
    }
    
    public Proyectos findProyecto(int id) {
        Proyectos proyecto = iproyectoRepository.findById(id).orElse(null);
        return proyecto;
    }
}