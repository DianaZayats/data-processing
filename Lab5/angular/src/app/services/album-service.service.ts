import { Injectable } from '@angular/core';
import { Albums } from '../interface/albums';
import { Api } from '../interface/api';
import { BehaviorSubject, Observable } from 'rxjs';

import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AlbumService {
  list = new BehaviorSubject<Albums[]>([])


  url:string="http://localhost:8082/albums"
  //USERS:IUser[]=[{id:1, name:"Roman",age:49}, {id:2, name:"Olena",age:29}]

  constructor(private http:HttpClient) { }

getApi():Observable<Api>{
 return this.http.get<Api>(this.url);
}

postApi(album:Albums):Observable<Api>{
  return this.http.post<Api>(this.url,album);
 }

 putApi(albums:Albums):Observable<Albums>{
  return this.http.put<Albums>(albums._links.self.href, albums);
 }

 deleteApi(albums:Albums):Observable<Albums>{
  return this.http.delete<Albums>(albums._links.self.href);
 }

}
