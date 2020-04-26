import { Component, OnInit, Input } from '@angular/core';
import { AuthService } from 'src/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  showChild = false;

  constructor() { }

  ngOnInit() {
  }

  toggleChild() {
    this.showChild = true;
  }

}
