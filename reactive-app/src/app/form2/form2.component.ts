import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'reactive-form2',
  templateUrl: './form2.component.html',
  styleUrls: ['./form2.component.css']
})
export class Form2Component {
  nameForm: FormGroup = new FormGroup(
    {
      firstName: new FormControl('', [
        Validators.required,
        Validators.minLength(5)
      ]),
      lastName: new FormControl('', [
        Validators.required,
        Validators.minLength(5)
      ]),
      description: new FormControl('', [
        Validators.minLength(15)
      ])
    }
  )

  submitForm(data) {
    console.log(data);
  }
}
