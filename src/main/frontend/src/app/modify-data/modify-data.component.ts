import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-modify-data',
  templateUrl: './modify-data.component.html',
  styleUrls: ['./modify-data.component.css']
})
export class ModifyDataComponent implements OnInit {
  @Input() showComponent: boolean;

  constructor(private fb: FormBuilder) { }

  form = this.fb.group({
    fullName: ['', [Validators.required]],
    weight: ['', [Validators.required]],
    goalWeight: ['', [Validators.required]]
  });

  ngOnInit() {
  }

}
