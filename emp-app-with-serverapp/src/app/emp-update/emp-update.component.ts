import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { Employee } from "../model/employee";
import { EmpService } from "../services/emp.service";

@Component({
  selector: "emp-update",
  templateUrl: "./emp-update.component.html",
  styleUrls: ["./emp-update.component.css"],
})
export class EmpUpdateComponent implements OnInit {

  @Input() empid: number;

  @Output() close = new EventEmitter();

  validationMessages:string[];

  constructor(private service: EmpService) {}

  emp: Employee;
  ngOnInit(): void {

    this.service.getEmployee(this.empid).subscribe(
      (data)=>this.emp=data,
      (errorResponse)=>this.close.emit(errorResponse.error.errorMessage)
    )
  }
  saveData() {
    this.service.updateEmployee(this.emp).subscribe(
      (message)=> this.close.emit(message),
      (fail)=>{
        if(fail.error.errorMessage){
            this.close.emit(JSON.parse(fail.error).errorMessage)
        }
         this.validationMessages=JSON.parse(fail.error).errors
      }
    )
  }
  cancel() {
    this.close.emit("Update operation cancelled");
  }
}
