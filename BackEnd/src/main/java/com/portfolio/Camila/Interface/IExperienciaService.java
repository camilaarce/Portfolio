package com.portfolio.Camila.Interface;

import com.portfolio.Camila.Entity.Experiencias;
import java.util.List;

public interface IExperienciaService {
    //traer lista de persona
    public List<Experiencias> getExperiencia();
    
    //guardar objeto tipo persona
    public void saveExperiencia(Experiencias experiencia);
    
    //eliminar objeto tipo persona
    public void deleteExperiencia(Long id);
    
    //buscar persona
    public Experiencias findExperiencia(Long id);

    public Object getOne(int id);
}