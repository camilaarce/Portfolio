package com.portfolio.Camila.Service;

import com.portfolio.Camila.Entity.Educacions;
import com.portfolio.Camila.Repository.iEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpEducacionService {
     @Autowired
     iEducacionRepository ieducacionRepository;
     
     public List<Educacions> list(){
         return ieducacionRepository.findAll();
     }
     
     public Optional<Educacions> getOne(int id){
         return ieducacionRepository.findById(id);
     }
     
     public Optional<Educacions> getByTitulo(String titulo){
         return ieducacionRepository.findByTitulo(titulo);
     }
     
     public void save(Educacions edu){
         ieducacionRepository.save(edu);
     }
     
     public void delete(int id){
         ieducacionRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return ieducacionRepository.existsById(id);
     }
     
     public boolean existsByTitulo(String titulo){
         return ieducacionRepository.existsByTitulo(titulo);
     }

    public void saveEducacion(Educacions educacion) {
        ieducacionRepository.save(educacion);
    }
    
    public Educacions findEducacion(int id) {
        Educacions educacion = ieducacionRepository.findById(id).orElse(null);
        return educacion;
    }
}
