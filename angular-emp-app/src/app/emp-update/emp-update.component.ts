import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/model/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'emp-update',
  templateUrl: './emp-update.component.html',
  styleUrls: ['./emp-update.component.css']
})
export class EmpUpdateComponent implements OnInit {


  constructor(private service: EmployeeService,
    private route: ActivatedRoute,  // required to extract route parameters
    private router: Router)   // required for navigation to list component after successful update
  { }

  employee: Employee={empid:null,name:"",salary:null}
  msgClass: string;
  message: string = null;
  failMessage: string = null;
  validationMessages=null;

  ngOnInit() {

    this.route.paramMap.subscribe(
      (params) => {
        let empId:number = parseInt(params.get('empid'))
      
        this.service.getEmployee(empId).subscribe(
          (data) => this.employee = data,
          (fail)=>  this.failMessage=fail.error.errorMessage
        )
        
      }

    )

  }

// this method is called when data update to be done and update button is clicked
update() {

   this.service.updateEmployee(this.employee).subscribe(
     (resp)=>{
      this.message = resp.message
      this.msgClass = 'alert alert-success'
      this.validationMessages=null;
     },
     (fail)=>{
      this.message = fail.error.errorMessage;
      this.validationMessages=fail.error.errors;
      this.msgClass = 'alert alert-danger'

     }

   )
  
}

gotoList() {
  this.router.navigate(["empList"])
}
  
}
