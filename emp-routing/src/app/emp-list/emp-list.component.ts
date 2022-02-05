import { Component, OnInit } from '@angular/core';
import { EmployeeDataService } from 'src/employee-data.service';
import { Employee } from 'src/model/employee';


@Component({
  selector: 'emp-list',
  templateUrl: './emp-list.component.html',
  styleUrls: ['./emp-list.component.css'],
})
export class EmpListComponent implements OnInit {

  employees: Employee[] = [];

  constructor(private service: EmployeeDataService) {}

  ngOnInit(): void {
    this.employees = this.service.getAllEmployees();
  }

  
}
