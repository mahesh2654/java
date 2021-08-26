import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/model/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'emp-list',
  templateUrl: './emp-list.component.html',
  styleUrls: ['./emp-list.component.css']
})
export class EmpListComponent implements OnInit {

  constructor(private service: EmployeeService) { }

  ngOnInit(): void {
    this.loadData();
  }

  header: string = "List of Employees";

  employees: Employee[];

  message: string = null;
  failMessage: string = null;

  delete(empid: number): void {

    this.service.deleteEmployee(empid).subscribe(
      (response) => {
        this.message = response.message;
        this.loadData();
      },
      (errorResponse) => {

        this.message = errorResponse.error.errorMessage
        this.loadData();
      }
    )

  }

  loadData(): void {
    this.service.getEmployees().subscribe(
      (data) => {
        this.employees = data;
      },
      (errorResponse) => {
        this.failMessage = errorResponse.error.errorMessage
      }
    )
  }

  updateComplete(message: string) {
    this.message = message;
  }
}
