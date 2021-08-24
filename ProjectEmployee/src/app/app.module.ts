import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmpListComponent } from './emp-list/emp-list.component';

import { FormsModule } from '@angular/forms';
import { EmpUpdateComponent } from './emp-update/emp-update.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';


@NgModule({
  declarations: [
    AppComponent,
    EmpListComponent,
    EmpUpdateComponent,
    CreateEmployeeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
