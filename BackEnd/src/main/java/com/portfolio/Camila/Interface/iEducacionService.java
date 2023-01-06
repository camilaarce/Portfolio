package com.portfolio.Camila.Interface;

import com.portfolio.Camila.Entity.Educacions;
import java.util.List;

public interface iEducacionService {
    //traer lista de persona
    public List<Educacions> getEducacion();
    
    //guardar objeto tipo persona
    public void saveEducacion(Educacions experiencia);
    
    //eliminar objeto tipo persona
    public void deleteEducacion(Long id);
    
    //buscar persona
    public Educacions findEducacion(Long id);

    public Object getOne(int id);
}