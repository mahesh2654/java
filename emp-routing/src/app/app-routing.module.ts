import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactComponent } from './contact/contact.component';
import { EmpCreateComponent } from './emp-create/employee.component';
import { EmpDetailsComponent } from './emp-details/emp-details.component';
import { EmpListComponent } from './emp-list/emp-list.component';
import { EmpUpdateComponent } from './emp-update/emp-update.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:"emplist",component:EmpListComponent},
  {path:"newemp",component:EmpCreateComponent}, 
  {path:'empdetails/:empid',component:EmpDetailsComponent},  // empId is route parameter
  {path:'empupdate/:empid',component:EmpUpdateComponent},  // empId is route parameter
  {path:'contactus',component:ContactComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
