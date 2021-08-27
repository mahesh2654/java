import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { EmpListComponent } from './emp-list/emp-list.component';
import { EmpUpdateComponent } from './emp-update/emp-update.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGuard } from './services/auth-guard.service';

const routes: Routes = [
  {path:'emplist',component:EmpListComponent,canActivate:[AuthGuard]},
  {path:'create',component:CreateEmployeeComponent,canActivate:[AuthGuard]},
  {path:'update/:empid',component:EmpUpdateComponent,canActivate:[AuthGuard]},
  {path:'home',component:HomeComponent},
  {path:'login', component:LoginComponent},
  {path:'logout',component:LogoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
