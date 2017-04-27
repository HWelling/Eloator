import { Component, OnInit } from '@angular/core';
import { EloCalcService } from './service/elocal.service';
import { KNumber } from './enums/KNumber.enum';

@Component({
  selector: 'elo-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css'],
})
export class EloCalculatorComponent implements OnInit {
  constructor(private calcService:EloCalcService) { }

  title: String = ""
  player1eloNumber: Number = 1000;
  player2eloNumber: Number = 1000;
  player1Points: number = 0;
  player2Points: number = 0;

  ngOnInit(): void {
    this.title = "Elo-Rechner";
  }

  doCalculate(): void {
    var win: Number;
    var player1eloNumberOld:Number = this.player1eloNumber;
    var player2eloNumberOld:Number = this.player2eloNumber;
    win =  this.player1Points - this.player2Points;
    this.player1eloNumber = this.calcService.doCalculateEloNumber(player1eloNumberOld, player2eloNumberOld, KNumber.STANDARD, win);
    win =  this.player2Points - this.player1Points;
    this.player2eloNumber = this.calcService.doCalculateEloNumber(player2eloNumberOld, player1eloNumberOld, KNumber.STANDARD, win);

    this.player1Points = 0;
    this.player2Points = 0;
  }
}
