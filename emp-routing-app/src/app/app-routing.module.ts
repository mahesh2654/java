import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { EmpListComponent } from './emp-list/emp-list.component';
import { EmpUpdateComponent } from './emp-update/emp-update.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'empList', component: EmpListComponent },
  { path: 'addNew', component: CreateEmployeeComponent },
  { path: 'update', component: EmpUpdateComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
