import { Component, OnInit } from '@angular/core';
import { EloCalcService } from './service/elocal.service';
import { KNumber } from './enums/KNumber.enum';
import { Result } from './domain/result';

@Component({
  selector: 'elo-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css'],
})
export class EloCalculatorComponent implements OnInit {
  constructor(private calcService:EloCalcService) { }

  title: String = ""
  player1Points: number = 0;
  player2Points: number = 0;
  result:Result = new Result();

  ngOnInit(): void {
    this.title = "Elo-Rechner";
    this.result.eloPlayerOne = 1000;
    this.result.eloPlayerTwo = 1000;
  }

  doCalculate(): void {
    var win: Number;
    var player1eloNumberOld:Number = this.result.eloPlayerOne;
    var player2eloNumberOld:Number = this.result.eloPlayerTwo;

    win =  this.player1Points - this.player2Points;
    this.calcService.doCalculateEloNumber(player1eloNumberOld, player2eloNumberOld, KNumber.STANDARD, win).subscribe(res => this.result = res);

    console.log("DEBUG");

    this.player1Points = 0;
    this.player2Points = 0;
  }
}
