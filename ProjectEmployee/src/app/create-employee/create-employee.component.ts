import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Employee } from 'src/model/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = { empid: null, name: "", salary: null, gender: 'M' }
  message: string = null;

  @Output() completed = new EventEmitter();   // has to emit 'completed' or 'cancelled'

  constructor(private service: EmployeeService) { }

  ngOnInit() {
  }

  cancel() {
    this.completed.emit("cancelled");
  }

  createNew() {
    let result: string = this.service.addEmployee(this.employee)
    if (result)
      this.message = result;
    else
      this.completed.emit("completed");

  }
}
