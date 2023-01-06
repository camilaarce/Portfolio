package com.portfolio.Camila.Interface;

import com.portfolio.Camila.Entity.Personas;
import java.util.List;

public interface IPersonaService {
    //traer lista de persona
    public List<Personas> getPersona();
    
    //guardar objeto tipo persona
    public void savePersona(Personas persona);
    
    //eliminar objeto tipo persona
    public void deletePersona(Long id);
    
    //buscar persona
    public Personas findPersona(Long id);

    public Object getOne(int id);
}
