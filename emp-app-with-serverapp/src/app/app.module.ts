import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { EmpListComponent } from './emp-list/emp-list.component';
import { EmpUpdateComponent } from './emp-update/emp-update.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EmpCreateComponent } from './emp-create/emp-create.component';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    EmpListComponent,
    EmpUpdateComponent,
    EmpCreateComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
