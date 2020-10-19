import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../shared/user';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})

export class RestApiService {
  
  // Define API
  apiURL = 'http://localhost:8080/user';

  constructor(private http: HttpClient) { }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }  

  getUsers(): Observable<User> {
    return this.http.get<User>(this.apiURL + '/users')
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  } 
  createUser(user): Observable<User> {
    return this.http.post<User>(this.apiURL + '/save', JSON.stringify(user), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }  

  handleError(error) {
     let errorMessage = '';
     if(error.error instanceof ErrorEvent) {
       // Get client-side error
       errorMessage = error.error.message;
     } else {
       // Get server-side error
       errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
     }
     window.alert(errorMessage);
     return throwError(errorMessage);
  }

}