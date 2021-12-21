import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Employee } from "../model/employee";

@Injectable({
  providedIn: "root",
})
export class EmpService {
  constructor(private http: HttpClient) {}

  baseUrl: string = "http://localhost:9090/employees";

  getEmployee(empid: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${empid}`);
  }

  getAllEmployees(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  saveEmployee(emp: Employee): Observable<any> {
    return this.http.post(this.baseUrl, emp, {responseType:'text'});
  }

  updateEmployee(emp: Employee): Observable<any> {
   
    return this.http.put(this.baseUrl, emp, {responseType:'text'});
  }

  deleteEmployee(empid: number): Observable<any> {
   
    return this.http.delete(`${this.baseUrl}/${empid}`, {responseType:'text'});
  }

}
