import { Component, OnInit, Input } from '@angular/core';
import { Albums } from '../interface/albums';
import { Api } from '../interface/api';
import { AlbumService } from '../services/album-service.service';

@Component({
  selector: 'app-list',
  templateUrl:
  './list.component.html',
  styleUrl: './list.component.scss'
})
export class ListComponent implements OnInit {

title:string="Favourite albums";
albumsList:Albums[]=[];
showAddForm:boolean=false;
selectedAlbum?:Albums;

constructor(private service:AlbumService) {}

ngOnInit(): void{
  this.updateAlbums();
  this.service.list.subscribe(
    (list:Albums[])=>{this.albumsList=list}
  );
}

updateAlbums(){
  this.service.getApi().subscribe(
    (album)=>{
    this.albumsList=album._embedded.albums;
  }
  );
}

addAlbum(album:Albums){
  this.service.postApi(album).subscribe(
    (album)=>{
    this.updateAlbums();
  }
  );
}

onSelect(album:Albums){
  if(this.selectedAlbum && album._links.self.href==this.selectedAlbum._links.self.href){
    this.selectedAlbum=undefined;
  }else{
    this.selectedAlbum=album;
  }
}

deleteAlbum(album:Albums){
  this.service.deleteApi(album).subscribe(
    ()=>{
    this.updateAlbums();
  }
  );
}
}
