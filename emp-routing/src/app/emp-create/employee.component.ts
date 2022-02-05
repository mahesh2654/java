import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { EmployeeDataService } from 'src/employee-data.service';
import { Employee } from 'src/model/employee';


@Component({
  selector: 'add-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css'],
})
export class EmpCreateComponent {
  
  constructor(private service: EmployeeDataService) {}

  message: string = '';

  saveData(data: Employee) {
    this.message = this.service.addEmployee(data);
    setTimeout( () => { this.message=''}, 5000);
  }

}
