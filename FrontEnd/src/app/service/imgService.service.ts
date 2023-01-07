import { Injectable } from '@angular/core';
import { Storage, ref, uploadBytes, list, getDownloadURL, listAll } from '@angular/fire/storage';

@Injectable({
  providedIn: 'root'
})
export class ImgService {
  url: string = "";

  constructor(private storage: Storage) { }

  public uploadImage($event: any, name: string){
    const file = $event.target.files[0]
    const imgRef = ref(this.storage, `imagen/`+ name)
    uploadBytes(imgRef, file)
    .then(response => {this.getImages(name)})
    .catch(error => console.log(error))
  }

  getImages(name: string){
    const imagesRef = ref(this.storage, 'imagen')
    listAll(imagesRef)
    .then(async response => {
      for(let item of response.items){
        if(name == item.name){
          this.url =  await getDownloadURL(item);
        }
      }
    }).catch(error => console.log(error))
  }
}
