import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Employee } from 'src/model/employee';
import { EmployeeDataService } from 'src/employee-data.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'emp-details',
  templateUrl: './emp-details.component.html',
  styleUrls: ['./emp-details.component.css'],
})
export class EmpDetailsComponent implements OnInit {
  emp: Employee = { empId: 0, name: '', salary: 0, gender: '' };
  message = '';
  constructor(
    private service: EmployeeDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      let eidstr: string | null = params.get('empid');
      if (eidstr == null) {

      } else {
        let eid = parseInt(eidstr);
        this.service.getEmployee(eid).then(
            (data)=> this.emp={...data},
            (msg)=> { this.message=msg
                     setTimeout(() => {
                        this.router.navigate(["/emplist"])
                      }, 5000);
                 }
        )
      }
    });
  }

  deleteEmp() {
    this.service.deleteEmployee(this.emp.empId);
    this.message = 'Data successfully deleted';
    setTimeout(() => {
      this.router.navigate(["/emplist"])
    }, 5000);
  }
}
