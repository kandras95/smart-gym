import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  showChild: boolean = false;

  constructor() { }

  ngOnInit() {
  }

  toggleChild() {
    this.showChild = true;
  }

}
