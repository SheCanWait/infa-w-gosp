import { Injectable } from '@angular/core';
import {LoginData} from '../model/login-data';
import {HttpClient} from '@angular/common/http';
import {ApplicationProperties} from '../properties/application-properties';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private readonly loginUrl = ApplicationProperties.APPLICATION_ADDRESS + '/login';
  private readonly registerUrl = ApplicationProperties.APPLICATION_ADDRESS + '/register';

  constructor(private http: HttpClient) { }

  login(loginData: LoginData): Observable<boolean> {
    return this.http.post<boolean>(this.loginUrl, loginData);
  }

  register(loginData: LoginData): Observable<boolean> {
    return this.http.post<boolean>(this.registerUrl, loginData);
  }
}
