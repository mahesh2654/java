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

  gender:string='M'
  @Output() completed = new EventEmitter();   // has to emit 'completed' or 'cancelled'

  constructor(private service: EmployeeService) { }

  ngOnInit() {
  }

  cancel() {
    this.completed.emit("cancelled");
  }

  createNew(data: Employee) {
    let result: string = this.service.addEmployee(data)
    if (result)
      this.message = result;
    else
      this.completed.emit("created");
  }
}
