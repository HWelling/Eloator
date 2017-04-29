import { Injectable } from '@angular/core';
import { KNumber } from '../enums/KNumber.enum';
import { WinningPoints } from '../enums/WinningPoints.enum';
import { Http, Headers, Response } from '@angular/http';
import { Result } from '../domain/result';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class EloCalcService {
    constructor(private http: Http){

    }

    doCalculateEloNumber(aElo:Number, bElo:Number, kNum:KNumber, w:Number): Observable<Result>{
        var win: WinningPoints;
        if(w > 0){win = WinningPoints.WIN};
        if(w < 0){win = WinningPoints.DEFEAT};
        if(w == 0){win = WinningPoints.DRAW};

        var winstr: String = WinningPoints[win];
        var kNumstr: String = KNumber[kNum];
        var header:Headers;

        header = new Headers();

        var result:Result;

        var url = `http://localhost:8080/elo/calc/result.json?a=${aElo}&b=${bElo}&k=${kNumstr}&w=${winstr}`;
        return this.http.get(url.toString(), {headers: header}).map(this.extractData);
        //console.log("POne: " + result.eloPlayerOne);
        //return Promise.resolve(result);
        //return result;
    }

    private extractData(res: Response): Result {
        let body:Result = res.json();
        console.log("Res: " + res);
        console.log("Res json: " + res.json().eloPlayerOne);
        return body;
    }

    private handleError (error: Response | any) {
    // In a real world app, you might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

}