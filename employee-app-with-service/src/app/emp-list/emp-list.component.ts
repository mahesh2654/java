import { Component, OnInit } from "@angular/core";
import { Employee } from "../model/employee";
import { EmpService } from "../services/emp.service";

@Component({
  selector: "emp-list",
  templateUrl: "./emp-list.component.html",
  styleUrls: ["./emp-list.component.css"],
})
export class EmpListComponent implements OnInit {
  constructor(private service: EmpService) {}

  ngOnInit(): void {
    this.loadData();
  }

  employees: Employee[];

  message: string = null;

  pos: number;

  updating: boolean = false;
  creating: boolean = false;

  delete(pos: number) {
    this.message = `Employee data with id ${this.employees[pos].empId} deleted`;
    this.service.deleteEmployee(pos);
    this.loadData();
  }

  update(i: number) {
    this.updating = true;
    this.pos = i;
  }

  updateCompleted(complete: boolean) {
    
    this.updating = false;
    if (complete) {
      this.message = `Eployee data with id ${this.employees[this.pos].empId} modified`;
    } else {
      this.message = "Update cancelled";
    }
    this.loadData();
  }

  createNew() {
    this.creating = true;
  }

  saveNewEmp(emp: Employee) {
    if (emp == null) {
      this.message = "create operation cancelled";
    } else {
      let found: boolean = false;
      for (let x of this.employees) {
        if (emp.empId == x.empId) found = true;
      }

      if (found) {
        this.message = `Employee with id ${emp.empId} already exists`;
      } else {
        this.employees.push(emp);
        this.message = `new employee with id ${emp.empId} created`;
      }
    }
    this.creating = false;
  }

  loadData() {
    this.employees = this.service.getAllEmployees();
  }
}
