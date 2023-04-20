import { Component, OnInit } from '@angular/core';
import { FormGroup,  FormControl,  Validators } from '@angular/forms';
import { Form } from './model/form';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'ui';

  newForm: Form;
  form: FormGroup;

  constructor() {
    this.newForm = new Form;
    this.form = new FormGroup({
      zipCode: new FormControl('',
      [Validators.required])
    })
  }

  ngOnInit(): void {

  }

  onSubmit() {
    if (this.form.valid) {
      this.newForm = new Form(this.form.value);
    }
  }

}
