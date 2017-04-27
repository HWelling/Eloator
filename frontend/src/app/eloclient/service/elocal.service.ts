import { Injectable } from '@angular/core';
import { KNumber } from '../enums/KNumber.enum';
import { WinningPoints } from '../enums/WinningPoints.enum';

@Injectable()
export class EloCalcService {

    doCalculateEloNumber(aElo:Number, bElo:Number, kNum:KNumber, w:Number): Number{
        var win: WinningPoints;
        if(w > 0){win = WinningPoints.WIN};
        if(w < 0){win = WinningPoints.DEFEAT};
        if(w == 0){win = WinningPoints.DRAW};

        var winstr: String = WinningPoints[win];
        var kNumstr: String = KNumber[kNum];

        var url = `localhost:8080/elo/calc?a=${aElo}&b=${bElo}&k=${kNumstr}&w=${winstr}`;
        console.log(url);

        return 9000;
    }

}