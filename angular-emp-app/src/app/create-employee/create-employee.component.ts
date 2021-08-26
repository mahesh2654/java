import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/model/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  message: string = null;
  validationMessages:string[]=null
  
  constructor(private service: EmployeeService, private router:Router) { }

  ngOnInit() {
  }

msgClass:string;

  createNew(data: Employee) {
    this.service.saveEmployee(data).subscribe(
     (resp)=>{
      this.message = resp.message
      this.msgClass = 'alert alert-success'
      this.validationMessages=null;
     },
     (fail)=>{
      this.message = fail.error.errorMessage;
      this.validationMessages=fail.error.errors;
      this.msgClass = 'alert alert-danger'

     }

   )
}

gotoList() {
  this.router.navigate(["empList"])
}
}