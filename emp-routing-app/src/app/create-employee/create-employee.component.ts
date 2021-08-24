import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Employee } from 'src/model/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  message: string = null;

  gender: string = 'M'

  constructor(private service: EmployeeService) { }

  ngOnInit() {
  }

msgClass:string;

  createNew(data: Employee) {
    let result: string = this.service.addEmployee(data)
    if (result) {
      this.message = result;
      this.msgClass='alert alert-danger'
    }
    else {
      this.message = 'Data successfully saved'
      this.msgClass='alert alert-success'
    }

  }
}
