import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Area } from '../models/area';

@Injectable({
  providedIn: 'root'
})
export class AreaService {


  private API_URL: string = 'http://localhost:8080/getAreas';

  constructor(private http: HttpClient) {}

  obtenerListado(): Observable<Area[]> {
    return this.http.get<Area[]>(this.API_URL);
  }

}
