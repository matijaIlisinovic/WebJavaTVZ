import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Hardware } from '../interfaces/hardware';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HardwareService {
  

  private hardwareUrl = "http://localhost:8080/hardware";

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    

  constructor(private http: HttpClient) { 
  }

  public getHardware(): Observable<Hardware[]> {
		return this.http.get<Hardware[]>(this.hardwareUrl)
    .pipe(
      tap(_ => console.log('fetched hardware')),
      catchError(this.handleError<Hardware[]>('getHardware', []))
      );
      
	}
  addHardware(arg0: { id: string; name: string; price: number; type: string; numberOf: number; }) {
    return this.http.post<Hardware>(this.hardwareUrl, arg0, this.httpOptions)
    .pipe(
      tap(_ => console.log('added hardware')),
      catchError(this.handleError<Hardware[]>('addHardware', []))
      );
  }
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
    console.error(operation);
    console.error(error);
    return of(result as T);
    }
  }
  getHardwareById(id:string): Observable<Hardware>{
    return this.http.get<Hardware>(this.hardwareUrl+"/"+id)
    .pipe(
      tap(_ => console.log('fetched item')),
      catchError(this.handleError<Hardware>('getByID', undefined))
      );
  }

  deleteHardwareById(id:string): Observable<Hardware>{
    return this.http.delete<Hardware>(this.hardwareUrl+"/"+id)
    .pipe(
      tap(_ => console.log('fetched item')),
      catchError(this.handleError<Hardware>('delByID', undefined))
      );;
  }
}
