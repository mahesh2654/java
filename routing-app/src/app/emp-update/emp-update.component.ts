import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Employee } from "../model/employee";
import { EmpService } from "../services/emp.service";

@Component({
  selector: "emp-update",
  templateUrl: "./emp-update.component.html",
  styleUrls: ["./emp-update.component.css"],
})
export class EmpUpdateComponent implements OnInit {


  validationMessages:string[];

  constructor(private service: EmpService,private route: ActivatedRoute, private router: Router) {}

  emp: Employee;
  message:string;
  ngOnInit(): void {

    this.route.paramMap.subscribe(
      (params) => {
        let id: number = +params.get('empId');
        
    this.service.getEmployee(id).subscribe(
      (data)=>this.emp=data,
      (errorResponse)=> this.message=errorResponse.error.errorMessage
    )

      }
    )
  }
  saveData() {
    this.service.updateEmployee(this.emp).subscribe(
      (resp)=> this.router.navigate(["emplist"]),
      (fail)=>{
        if(fail.error.errorMessage){
            this.message=fail.error.errorMessage
        }
         this.validationMessages=fail.error.errors
      }
    )
  }
  cancel() {
    this.router.navigate(["emplist"]);
  }
}
