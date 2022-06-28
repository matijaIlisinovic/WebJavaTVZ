import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Review } from '../interfaces/review';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  private reviewUrl = "http://localhost:8080/review";

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

  constructor(private http: HttpClient) { }

  public getReviews(): Observable<Review[]> {
		return this.http.get<Review[]>(this.reviewUrl)
    .pipe(
      tap(_ => console.log('fetched reviews')),
      catchError(this.handleError<Review[]>('getReviews', []))
      );
      
	}
  public getReviewByHardware(hardwareId:string): Observable<Review[]> {
		return this.http.get<Review[]>(this.reviewUrl+"?hardwareCode="+hardwareId)
    .pipe(
      tap(_ => console.log('fetched reviews for hardware')),
      catchError(this.handleError<Review[]>('getReviewByHardware', []))
      );
      
	}
  public getReviewById(id:number): Observable<Review> {
		return this.http.get<Review>(this.reviewUrl+"?id="+id)
    .pipe(
      tap(_ => console.log('fetched review')),
      catchError(this.handleError<Review>('getReviewById'))
      );
      
	}
  public getReviewByTitle(title:string): Observable<Review[]> {
		return this.http.get<Review[]>(this.reviewUrl+"?title="+title)
    .pipe(
      tap(_ => console.log('fetched reviews for hardware')),
      catchError(this.handleError<Review[]>('getReviewByHardware', []))
      );
      
	}

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
    console.error(operation);
    console.error(error);
    return of(result as T);
    }
  }
}
