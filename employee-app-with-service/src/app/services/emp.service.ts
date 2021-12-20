import { Injectable } from "@angular/core";
import { Employee } from "../model/employee";

@Injectable({
  providedIn: "root",
})
export class EmpService {
  employees: Employee[] = [
    {empId: 100,name: "Suresh",salary: 12000,gender: "M",dob: new Date("1989-10-21") },
    {empId: 200,name: "Akhila",salary: 16000,gender: "F",dob: new Date("1998-5-8") },
    {empId: 300,name: "Ganesh",salary: 8000, gender: "M",dob: new Date("1997-10-5") },
    {empId: 400, name: "Mahesh", salary: 21000, gender: "M", dob: null },
    {empId: 500,name: "Ritesh",  salary: 10000, gender: "M", dob: new Date("1997-12-1") },
    {empId: 600,name: "Sailesh", salary: 11000, gender: "A", dob: new Date("1996-10-10") },
    { empId: 700, name: "Rajani", salary: 10000, gender: "F", dob: null },
  ];

  getAllEmployees(): Employee[] {
    return [... this.employees];
  }

  deleteEmployee(pos: number): void {
    this.employees.splice(pos, 1);
  }

  getEmployee(pos:number):Employee{
    return {...this.employees[pos]}
  }

  update(e:Employee,pos:number){
    this.employees[pos]=e;
  }
  
  save(e:Employee){

  }
}
