import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { Employee } from "../model/employee";

@Component({
  selector: "emp-create",
  templateUrl: "./emp-create.component.html",
  styleUrls: ["./emp-create.component.css"],
})
export class EmpCreateComponent implements OnInit {
  
  @Output() close = new EventEmitter();

  constructor() {}

  ngOnInit() {}

  saveData(emp: Employee) {
    this.close.emit(emp);
  }

  cancel() {
    this.close.emit(null);
  }
}
