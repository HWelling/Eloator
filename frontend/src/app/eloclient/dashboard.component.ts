import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'elo-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class EloDashboardComponent implements OnInit {
  constructor() { }

  title: String = ""

  ngOnInit(): void {
    this.title = "Elo-Client";
  }
}
