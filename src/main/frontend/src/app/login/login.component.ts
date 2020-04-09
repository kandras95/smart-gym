import { Component, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  hidePassword = true;
  @Output() isLoggedIn: boolean = false;

  constructor(private router: Router, private fb: FormBuilder) { }

  form = this.fb.group({
    username: ['', [Validators.required]],
    password: ['', [Validators.required]],
  });

  get username() { return this.form.get('username'); }
  get password() { return this.form.get('password'); }

  ngOnInit() {
  }

  onSubmit() {
    this.router.navigate(['/home']);
  }

}
