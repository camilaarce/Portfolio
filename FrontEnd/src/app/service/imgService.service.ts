import { Injectable } from '@angular/core';
import { Storage, ref, uploadBytes, list, getDownloadURL, listAll } from '@angular/fire/storage';

@Injectable({
  providedIn: 'root'
})
export class ImgService {
  url: string = "";

  constructor(private storage: Storage) { }

  public uploadImage($event: any, name: string){
    console.log(name);
    const file = $event.target.files[0]
    const imgRef = ref(this.storage, `imagen/`+ name)
    uploadBytes(imgRef, file)
    .then(response => {this.getImages(name)})
    .catch(error => console.log(error))
    console.log(this.url)
  }

  getImages(name: string){
    const imagesRef = ref(this.storage, 'imagen')
    listAll(imagesRef)
    .then(async response => {
      console.log(response)
      for(let item of response.items){
        console.log(item.name)
        if(name == item.name){
          this.url =  await getDownloadURL(item);
        }
      }
    }).catch(error => console.log(error))
  }
}
