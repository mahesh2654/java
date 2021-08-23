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

  create: boolean = false;
  message: string = null;

  updatePosition:number= null;

  delete(pos): void {
    this.message = `employee data with id ${this.employees[pos].empid} deleted`
    this.service.deleteEmployee(pos);
    this.loadData();
  }


  loadData(): void {
    this.employees = this.service.getEmployees();
  }

  createNew() {
    this.create = true;
  }

  afterCreate(message:string) {
    if (message == "created") {
      this.message = `New employee added`
      this.loadData();
    }
    this.create = false;
  }

  modify(pos:number){
    this.updatePosition=pos;
  }

  updateComplete(message:string){
    this.message=message;
    this.updatePosition=null;
  }
}
