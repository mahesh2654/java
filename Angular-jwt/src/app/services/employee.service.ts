import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from 'src/model/employee';

@Injectable({
  providedIn: 'root'
})

export class EmployeeService {

  baseURL = 'http://localhost:9090/employees';

  constructor(private http: HttpClient) { }

  getEmployees(): Observable<any> {
    return this.http.get(this.baseURL);
  }

  getEmployee(empid: number): Observable<any> {
    return this.http.get(`${this.baseURL}/${empid}`);
  }

  updateEmployee(employee: Employee):Observable<any> {
    return this.http.put(this.baseURL, employee);
  }

  deleteEmployee(empid: number): Observable<any> {
    return this.http.delete(`${this.baseURL}/${empid}`);
  }

  saveEmployee(employee: Employee) :Observable<any>{
    return this.http.post(this.baseURL, employee);
  }

}
