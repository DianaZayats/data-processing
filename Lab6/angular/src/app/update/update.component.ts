import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Albums } from '../interface/albums';
import { Api } from '../interface/api';
import { AlbumService } from '../services/album-service.service';


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrl: './update.component.scss'
})
export class UpdateComponent implements OnInit {
@Input() album?:Albums
@Output() updated:EventEmitter<null>=new EventEmitter();

constructor(private service:AlbumService){}

ngOnInit(): void{
  }
  updateAlbums(){
    if(this.album)
    this.service.putApi(this.album).subscribe(
      ()=>{
        this.updated.emit();
        }
    );
  }

}
