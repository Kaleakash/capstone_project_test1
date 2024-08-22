import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
baseUrl:string="http://localhost:9090/student";

  constructor(public http:HttpClient) { }


  loadAllStudentInfo():Observable<Student[]> {
    return this.http.get<Student[]>(`${this.baseUrl}/find`);
  }

  storeStudent(student:any):Observable<string> {
    return this.http.post(`${this.baseUrl}/store`,student,{responseType:'text'});
  }

}
