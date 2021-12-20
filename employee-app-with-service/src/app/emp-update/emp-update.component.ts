import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { Employee } from "../model/employee";
import { EmpService } from "../services/emp.service";

@Component({
  selector: "emp-update",
  templateUrl: "./emp-update.component.html",
  styleUrls: ["./emp-update.component.css"],
})
export class EmpUpdateComponent implements OnInit {
  @Input() pos: number;
  @Output() close = new EventEmitter();

  constructor(private service: EmpService) {}

  emp: Employee;
  ngOnInit(): void {
    this.emp = this.service.getEmployee(this.pos);
  }
  saveData() {
    this.service.update(this.emp,this.pos)
    this.close.emit(true);
  }
  cancel() {
    this.close.emit(false);
  }
}
