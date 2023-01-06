package com.portfolio.Camila.Service;

import com.portfolio.Camila.Entity.Personas;
import com.portfolio.Camila.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService{
    @Autowired IPersonaRepository ipersonaRepository;
    
    public List<Personas> getPersona() {
        List<Personas> persona = ipersonaRepository.findAll();
        return persona;
    }

    public void savePersona(Personas persona) {
        ipersonaRepository.save(persona);
    }

    public void deletePersona(int id) {
        ipersonaRepository.deleteById(id);
    }

    public Personas findPersona(int id) {
        Personas persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }

    public Optional<Personas> getOne(int id){
         return ipersonaRepository.findById(id);
     }
    
}
