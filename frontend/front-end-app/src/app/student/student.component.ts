import { Component, OnInit } from '@angular/core';
import { StudentService } from '../student.service';
import { Student } from '../student';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit{
  studentRef= new FormGroup({
    sid:new FormControl(),
    sname:new FormControl(),
    age:new FormControl()
  })
  result:string ="";
  students:Array<Student>=[];
  constructor(public ss:StudentService){}   // DI
  
  ngOnInit(): void {
     this.retrieveStudentInfo();
  }
retrieveStudentInfo() : void {
  this.ss.loadAllStudentInfo().subscribe({
    next:(result:any)=> {
           this.students=result;
    },
    error:(error:any)=> {
        console.log(error)
    },
    complete:()=> {
        console.log("student details loaded")
    }
  })
}
  addStudent(): void {
    let student = this.studentRef.value;

    this.ss.storeStudent(student).subscribe({
      next:(result)=> {
        this.result=result;
      },
      error:(error)=> {
        console.log(error)
        this.result=error.message
      },
      complete:()=> {
        this.retrieveStudentInfo();
      }
    })

    this.studentRef.reset();
  }
}
