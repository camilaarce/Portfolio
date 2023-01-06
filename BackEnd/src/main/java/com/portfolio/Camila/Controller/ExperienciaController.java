package com.portfolio.Camila.Controller;

import com.google.gson.Gson;
import com.portfolio.Camila.Entity.Experiencias;
import com.portfolio.Camila.Security.Controller.Mensaje;
import com.portfolio.Camila.Service.ImpExperienciaService;
import java.io.IOException;
import java.util.List;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
public class ExperienciaController {
    @Autowired
    ImpExperienciaService iexperienciaService;
    
    @GetMapping("/experiencia/lista")
    public ResponseEntity<List<Experiencias>> list(){
        List<Experiencias> list = iexperienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/experiencia/detail/{id}")
    public ResponseEntity<Experiencias> getById(@PathVariable("id") int id){
        if(!iexperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencias experiencia = iexperienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/experiencia/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!iexperienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        iexperienciaService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/experiencia/create")
    public ResponseEntity<?> create(@RequestBody Experiencias exp) throws IOException{      
        
        Experiencias experiencia = new Experiencias(exp.getEmpleado(), exp.getEmpresa(), exp.getPeriodo(), exp.getDescripcion(), exp.getImg());
        iexperienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    
    @PutMapping("/experiencia/update/{id}")
    public void update(@PathVariable("id") int id,@RequestBody Experiencias experiencia) throws IOException{
        
        Experiencias exp = iexperienciaService.getOne(id).get();
        
        exp.setEmpleado(experiencia.getEmpleado());
        exp.setEmpresa(experiencia.getEmpresa());
        exp.setPeriodo(experiencia.getPeriodo());
        exp.setDescripcion(experiencia.getDescripcion());
        exp.setImg(experiencia.getImg());
        
        iexperienciaService.saveExperiencia(exp);
    }
    
    @GetMapping("/experiencia/traer/{id}")
    public Experiencias findExperiencia(@PathVariable("id") int id){
        return iexperienciaService.findExperiencia(id);
    }
}
