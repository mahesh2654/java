import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'reactive-form1',
  templateUrl:'./form1.component.html',
  styleUrls: ['./form1.component.css']
})
export class Form1Component {

  constructor() { }

  name:FormControl= new FormControl('Ramana');

  convertToUpper(){
    this.name.setValue(this.name.value.toUpperCase());
  }
}
