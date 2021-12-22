import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }


  names:string[] =
  ['Ramana reddy',"Alok Nath", "Sudhir Kumar","Anitha Rao"]
}
