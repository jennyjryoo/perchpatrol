import { Component, OnInit } from '@angular/core';
import { FormGroup,  FormControl,  Validators } from '@angular/forms';
import { Form } from './model/form';
import { FormService } from './service/form.service';
import { Bird } from './model/bird';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Perch Patrol';

  newForm: Form;
  form: FormGroup;
  birdList: Bird[];
  message: string = "";
  zipPattern = "^[0-9]{5}(?:-[0-9]{4})?$";

  constructor(private formService: FormService) {
    this.birdList = [];
    this.newForm = new Form;
    this.form = new FormGroup({
      zip: new FormControl('',
      [Validators.required,
      Validators.pattern(this.zipPattern)]),
      distance: new FormControl('',
      [Validators.required])
    })
  }

  ngOnInit(): void {

  }

  onSubmit() {
    if (this.form.valid) {
      this.newForm = new Form(this.form.value);
      console.log(this.newForm);
      this.formService.submitForm(this.newForm).subscribe((response: any) => {
        this.birdList = response;
        if(this.birdList.length === 0) {
            this.message = "Sorry, there are no birds!";
        } else {
          this.message ="";
        }
        console.log(this.birdList);
      })
    }
  }

}
