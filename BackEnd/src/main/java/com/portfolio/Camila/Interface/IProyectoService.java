package com.portfolio.Camila.Interface;

import com.portfolio.Camila.Entity.Proyectos;
import java.util.List;

public interface IProyectoService {
    //traer lista de persona
    public List<Proyectos> getProyecto();
    
    //guardar objeto tipo persona
    public void saveProyecto(Proyectos proyecto);
    
    //eliminar objeto tipo persona
    public void deleteProyecto(Long id);
    
    //buscar persona
    public Proyectos findProyecto(Long id);

    public Object getOne(int id);
}