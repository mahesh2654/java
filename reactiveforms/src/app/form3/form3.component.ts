import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'reactive-form3',
  templateUrl: './form3.component.html',
  styleUrls: ['./form3.component.css']
})
export class Form3Component {

  userForm = new FormGroup({
    firstName: new FormControl('',Validators.required),
    lastName: new FormControl(''),
    address: new FormGroup({
      street: new FormControl(''),
      city: new FormControl(''),
      state: new FormControl(''),
      zip: new FormControl('')
    })
  });

 user:User;
  onSubmit():void{
    this.user=this.userForm.value
    console.log(this.user);
  
  }

}
interface User{
    firstname:string;
    lastname:string;
    address:{
      street:string;
      city:string;
      state:string;
      zip:number
    }
}