import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { FormControl, FormGroup } from "@angular/forms";
import { Employee } from "../model/employee";
import { EmpService } from "../services/emp.service";

@Component({
  selector: "emp-create",
  templateUrl: "./emp-create.component.html",
  styleUrls: ["./emp-create.component.css"],
})
export class EmpCreateComponent {
  @Output() close = new EventEmitter();

  constructor(private service: EmpService) {}

  message: string = null;
  validationMessages: string[];
  saveData(emp: Employee) {
    this.service.saveEmployee(emp).subscribe(
      (resp) => this.close.emit(resp.message),

      (fail) => {
        this.message = fail.error.errorMessage;
        this.validationMessages = fail.error.errors;
      }
    );
  }
  cancel() {
    this.close.emit(null);
  }
}
