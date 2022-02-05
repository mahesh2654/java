import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeDataService } from 'src/employee-data.service';
import { Employee } from 'src/model/employee';

@Component({
  selector: 'app-emp-update',
  templateUrl: './emp-update.component.html',
  styleUrls: ['./emp-update.component.css'],
})
export class EmpUpdateComponent implements OnInit {
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
          (data) => (this.emp = { ...data }),
          (msg) => {
            this.message = msg;
            setTimeout(() => {
              this.router.navigate(['/emplist']);
            }, 5000);
          }
        );
      }
    });
  }

  saveData(){
    this.message = this.service.updateEmployee(this.emp);
    setTimeout(() => {
      this.router.navigate(['/empdetails',this.emp.empId]);
      
    }, 5000);
  }
}
