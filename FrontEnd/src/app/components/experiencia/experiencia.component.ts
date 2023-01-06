import { Component, OnInit } from '@angular/core';
import { Experiencia } from 'src/app/model/experiencia';
import { ExperienciaService } from 'src/app/service/experienciaService.service';
import { TokenService } from 'src/app/service/token.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacionService.service';
import { ImgService } from 'src/app/service/imgService.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
 experiencia: Experiencia[] = [];
 educacion: Educacion[] = [];

 empleado = "";
 empresa = "";
 periodo = "";
 descripcion = "";
 formData = new FormData(); 

 titulo = "";
 institucion = "";
 periodoEdu = "";

 indice: number;

  constructor(private experienciaService: ExperienciaService, private educacionService: EducacionService, private tokenService: TokenService, public modal:NgbModal, private activatedRouter: ActivatedRoute, private httpClient: HttpClient, private imgService: ImgService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargar();
    if(this.tokenService.getToken()){
      this.isLogged = true;
      console.log(this.experiencia);
    } else {
      this.isLogged = false;
    }
      
  }

  imprimirIndice(id: number, opc: number): void {
    var i;
    if (opc == 1){
      for (i = 0; i < this.experiencia.length; i++) {
        if(this.experiencia[i].id == id){
          this.indice = i;
        }
      } 
    } else {
      for (i = 0; i < this.educacion.length; i++) {
        if(this.educacion[i].id == id){
          this.indice = i;
        }
      } 
    }
  }

  id: number = 0;
  cargar(): void{
    this.educacionService.lista().subscribe(
      data => {this.educacion = data;}
    )
    this.experienciaService.lista().subscribe(
      data => {this.experiencia = data;}
    )
  }

  delete(opc: number): void{
    if (opc == 1) {
      if(this.indice > -1){
        this.experienciaService.delete(this.experiencia[this.indice].id).subscribe(
          data => {
            this.cargar();
          }
        )
      }
    } if(this.indice > -1){
      this.educacionService.delete(this.educacion[this.indice].id).subscribe(
        data => {
          this.cargar();
        }
      )
    }
  }
    
  expEditar: Experiencia = null;
  eduEditar: Educacion = null;

  onUpdate(opc: number): void{
    if (opc == 1){
      this.expEditar = this.experiencia[this.indice];
      this.expEditar.img = this.imgService.url;
      console.log(this.expEditar)
      this.experienciaService.update( this.experiencia[this.indice].id, this.expEditar).subscribe(data => {
          this.cargar();
      });
    } else {
      this.eduEditar = this.educacion[this.indice];
      this.eduEditar.img = this.imgService.url;
      console.log(this.eduEditar)
      this.educacionService.update( this.educacion[this.indice].id, this.eduEditar).subscribe(data => {
          this.cargar();
      });
    }
  }

  
  create(opc: number): void {
    if(opc == 1){
      const expNueva = new Experiencia(this.empleado, this.empresa, this.periodo, this.descripcion, this.imgService.url)
      console.log(this.imgService.url)
      this.experienciaService.save(expNueva).subscribe(data => {
          this.cargar();
      });
    } else {
      console.log(this.imgService.url)
      const eduNueva = new Educacion(this.titulo, this.institucion, this.periodoEdu, this.imgService.url)
      this.educacionService.save(eduNueva).subscribe(data => {
          this.cargar();
      });
    }
    
  

  }
 
  
  onFileSelected($event:any, opc: number){
    //const file:File = event.target.files[0];
 
    //this.formData.append("fichero", file);
    //const id = this.activatedRouter.snapshot.params['id'];
    var name: string = null;
    if (opc == 1){
      name = "experiencia_" + this.empresa;
    } else {
      name = "educacion_" + this.institucion;
    }
    
    this.imgService.uploadImage($event, name)
  }

}
