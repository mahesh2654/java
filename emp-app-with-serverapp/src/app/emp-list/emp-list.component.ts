import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Observable } from "rxjs";
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

  errorMessage: string = null;
  employees: Employee[];

  message: string = null;

  empid: number;

  updating: boolean = false;
  creating: boolean = false;

  delete(empid: number) {
    this.service.deleteEmployee(empid).subscribe(
      (resp) => {
        this.loadData();
        this.message = resp.message;
      },
      (response) => {
        console.log(response.error.errorMessage);
      }
    );
  }

  update(empid: number) {
    this.updating = true;
    this.empid = empid;
  }

  updateCompleted(message: string) {
    this.updating = false;
    this.message = message;
    this.loadData();
  }

  createNew() {
    this.creating = true;
  }

  saveNewEmp(message: string) {
    this.loadData();
    this.message = message;
    this.creating = false;
  }
  loadData() {
    this.service.getAllEmployees().subscribe(
      (data) => (this.employees = data),
      (response) => (this.errorMessage = response.error.errorMessage)
    );
  }
}
