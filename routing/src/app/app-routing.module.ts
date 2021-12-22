import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { DetailsComponent } from './details/details.component';
import { HomeComponent } from './home/home.component';
import { ListComponent } from './list/list.component';


const routes: Routes = [

  {path:'',component:HomeComponent},
  {path:'details',component:DetailsComponent},
  {path:'about',component:AboutComponent},
  {path:'userList',component:ListComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
