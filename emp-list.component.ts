import { Component, OnInit } from "@angular/core";
import { Employee } from "src/model/employee";

@Component({
  selector: "emp-list",
  templateUrl: "./emp-list.component.html",
  styleUrls: ["./emp-list.component.css"],
})
export class EmpListComponent {
  employees: Employee[] = [
    { empId: 100, name: "Suresh", salary: 12000, gender: "M", dob: null },
    { empId: 200, name: "Akhila", salary: 16000, gender: "F", dob: null },
    { empId: 300, name: "Ganesh", salary: 8000, gender: "M", dob: null },
    { empId: 400, name: "Mahesh", salary: 21000, gender: "M", dob: null },
    { empId: 500, name: "Ritesh", salary: 10000, gender: "M", dob: null },
    { empId: 600, name: "Sailesh", salary: 11000, gender: "A", dob: null },
    { empId: 700, name: "Rajani", salary: 10000, gender: "F", dob: null }
  ];

  message: string = null;

  delete(pos: number) {
    this.message = `Employee data with id ${this.employees[pos].empId} deleted`;
    this.employees.splice(pos, 1); // one element at position pos
  }

}
