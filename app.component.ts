import { Component } from '@angular/core';
import { Employee } from 'src/emp';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  emp: Employee = { empId: 100, name: "Ramana" };
  num1: number = 0
  num2: number = 0

  result: number;
  imageName:string = 'assets/horse.jpg';
  animal:string='Bird'
  color = 'blue'

  add(): void {
    this.result = this.num1 + this.num2;
  }

  subtract(): void {
    this.result = this.num1 - this.num2;
  }

  changeImage():void{
    if(this.animal=='Bird'){
      this.animal='Horse';
      this.imageName='assets/bird.jpg'
    }
    else{
      this.animal='Bird';
      this.imageName='assets/horse.jpg'
    }
  }
}



