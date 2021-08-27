import { AuthenticationService } from '../services/authentication.service';
import { Component } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  message: string=null;
  constructor(
    private router: Router,
    private authenticationService: AuthenticationService) { }

  signIn(credentials) {
    this.authenticationService.login(credentials)
      .subscribe(result => {
        this.router.navigate(['/home']);
        this.message=null;
      },
         fail => {
          this.message = fail.error.errorMessage;
        }
      );

  }
}
