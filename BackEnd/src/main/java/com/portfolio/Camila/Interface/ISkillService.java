package com.portfolio.Camila.Interface;

import com.portfolio.Camila.Entity.Skills;
import java.util.List;

public interface ISkillService {
    //traer lista de persona
    public List<Skills> getSkill();
    
    //guardar objeto tipo persona
    public void saveSkill(Skills skill);
    
    //eliminar objeto tipo persona
    public void deleteSkill(Long id);
    
    //buscar persona
    public Skills findSkill(Long id);

    public Object getOne(int id);
}