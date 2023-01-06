package com.portfolio.Camila.Service;

import com.portfolio.Camila.Entity.Skills;
import com.portfolio.Camila.Repository.ISkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpSkillService {
     @Autowired
     ISkillRepository iskillRepository;
     
     public List<Skills> list(){
         return iskillRepository.findAll();
     }
     
     public Optional<Skills> getOne(int id){
         return iskillRepository.findById(id);
     }
     
     public Optional<Skills> getByTitulo(String titulo){
         return iskillRepository.findByNombre(titulo);
     }
     
     public void save(Skills skill){
         iskillRepository.save(skill);
     }
     
     public void delete(int id){
         iskillRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return iskillRepository.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return iskillRepository.existsByNombre(nombre);
     }

    public void saveSkill(Skills skill) {
        iskillRepository.save(skill);
    }
    
    public Skills findSkill(int id) {
        Skills skill = iskillRepository.findById(id).orElse(null);
        return skill;
    }
}