import { Injectable } from '@angular/core';
import { Employee } from 'src/model/employee';


@Injectable({
  providedIn: 'root',
})
export class EmployeeDataService {
  employees: Employee[] = [
    { empId: 100, name: 'Kiran Kumar', salary: 14000, gender: 'M' },
    { empId: 200, name: 'Ashok Jain', salary: 24000, gender: 'M' },
    { empId: 300, name: 'Smitha kapoor', salary: 16000, gender: 'F' },
    { empId: 400, name: 'akhila reddy', salary: 33000, gender: 'F' },
    { empId: 500, name: 'Amir khan ', salary: 11000, gender: 'X' },
    { empId: 600, name: 'Rajesh Arya', salary: 15000, gender: 'M' },
    { empId: 700, name: 'M Joseph', salary: 36000, gender: 'M' },
    { empId: 800, name: 'Shaina kurien', salary: 35000, gender: 'F' },
  ];

  // to get all employees
  getAllEmployees() {
    return this.employees;
  }

  // to get one employee
  getEmployee(eid: number):Promise<any> {
    let pos: number = this.employees.findIndex((e) => e.empId == eid);
    return new Promise((success, fail) => {
      if (pos != -1) 
        success(this.employees[pos]);
      else 
        fail(`Employee with id ${eid} not found`);
    });

  }

  deleteEmployee(eid: number) {
    let pos: number = this.employees.findIndex((e) => e.empId == eid);
    this.employees.splice(pos, 1);
  }

  updateEmployee(emp:Employee) {
    let pos: number = this.employees.findIndex((e) => e.empId == emp.empId);
   
    if (pos != -1) {
      this.employees[pos]=emp
      return `Data with id ${emp.empId} successfully updated`;
    } else {
      return `Data with id ${emp.empId} not found`;
    }
  }
  addEmployee(emp: Employee): string {
    let pos: number = this.employees.findIndex((e) => e.empId == emp.empId);
    if (pos == -1) {
      this.employees.push(emp);
      return `Data with id ${emp.empId} successfully saved`;
    } else {
      return `Data with id ${emp.empId} already exists`;
    }
  }
}
