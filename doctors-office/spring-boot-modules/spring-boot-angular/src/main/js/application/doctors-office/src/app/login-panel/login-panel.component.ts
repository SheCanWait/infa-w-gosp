import { Component, OnInit } from '@angular/core';
import {LoginService} from '../service/login.service';
import {LoginData} from '../model/login-data';
import {User} from "../model/user";
import {ApplicationProperties} from "../properties/application-properties";

@Component({
  selector: 'app-login-panel',
  templateUrl: './login-panel.component.html',
  styleUrls: ['./login-panel.component.css']
})
export class LoginPanelComponent implements OnInit {

  loginData: LoginData;

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
  }


  onRegisterClick() {
    this.loginService.register(this.loginData).subscribe(() => {
      window.alert(ApplicationProperties.SUCCESSFUL_LOGIN_WELCOME_MESSAGE + this.loginData.username);
    }, (error) => {
      window.alert(error);
    });
  }

  onLoginClick() {
    this.loginService.login(this.loginData).subscribe(() => {
      window.alert(ApplicationProperties.SUCCESSFUL_LOGIN_WELCOME_MESSAGE + this.loginData.username);
    }, (error) => {
      window.alert(error);
    });
  }
}
