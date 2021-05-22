import { Component, OnInit } from '@angular/core';
import {LoginService} from '../service/login.service';
import {LoginData} from '../model/login-data';
import {ApplicationProperties} from '../properties/application-properties';
import {AlertService} from '../common/alert.service';
import {Md5} from 'ts-md5/dist/md5';

@Component({
  selector: 'app-login-panel',
  templateUrl: './login-panel.component.html',
  styleUrls: ['./login-panel.component.css']
})
export class LoginPanelComponent implements OnInit {

  loginData: LoginData;

  constructor(private loginService: LoginService,
              private alertService: AlertService) { }

  ngOnInit(): void {
  }

  onRegisterClick() {
    if (this.validateLoginData(this.loginData)) {
      const hashedLoginData = this.hashLoginData(this.loginData);
      this.loginService.register(hashedLoginData).subscribe(() => {
        this.alertService.displayAlert(ApplicationProperties.SUCCESSFUL_LOGIN_WELCOME_ALERT + this.loginData.username);
      }, (error) => {
        this.alertService.displayAlert(error);
      });
    } else {
      this.alertService.displayAlert(ApplicationProperties.INVALID_LOGIN_DATA_ALERT);
    }
  }

  onLoginClick() {
    this.loginService.login(this.loginData).subscribe(() => {
      this.alertService.displayAlert(ApplicationProperties.SUCCESSFUL_LOGIN_WELCOME_ALERT + this.loginData.username);
    }, (error) => {
      this.alertService.displayAlert(error);
    });
  }

  private validateLoginData(loginData: LoginData): boolean {
    const username = loginData.username;
    const password = loginData.password;
    const usernameRegex = /^[a-zA-Z\-]+$/;
    const passwordRegex = /^.{6,}$/;
    return usernameRegex.test(username) && passwordRegex.test(password);
  }

  private hashLoginData(loginData: LoginData): LoginData {
    const hashedLoginData = new LoginData();
    hashedLoginData.username = Md5.hashStr(loginData.username).toString();
    hashedLoginData.password = Md5.hashStr(loginData.password).toString();
    return hashedLoginData;
  }
}
