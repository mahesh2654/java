import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  employee = {
    id: 100,
    name: "Rajiv Kapoor",
    address: "Hyderabad",
    dateOfBirth:new Date("1988-10-2"),
    salary: 25000
  }
  
  selectedColor:string;
  num:number=10;

  title:string="";

  gender:string=''

  check:boolean=true;

  toggle(){
    this.check=!this.check;
  }
}

