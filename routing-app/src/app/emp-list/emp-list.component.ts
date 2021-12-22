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

  employees: Employee[];

  message: string = null;

  delete(empid: number) {
    this.service.deleteEmployee(empid).subscribe(
      (resp) => {
        this.loadData();
        this.message = resp.message;
      },
      (response) => {
        this.message=response.error.errorMessage;
      }
    );
  }


  loadData() {
    this.service.getAllEmployees().subscribe(
      (data) => (this.employees = data),
      (response) => (this.message = response.error.errorMessage)
    );
  }
}
