import { Injectable } from '@angular/core';
import { KNumber } from '../enums/KNumber.enum';
import { WinningPoints } from '../enums/WinningPoints.enum';
import { Http, Headers, Response } from '@angular/http';
import { Result } from '../domain/result';
import { ElonumberRequest } from '../domain/elonumberRequest';
import { Player } from '../domain/player';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class EloCalcService {
    constructor(private http: Http){

    }

    doCalculateEloNumber(aElo:Number, bElo:Number, pointsA:Number, pointsB:Number): Observable<Result>{
        var header:Headers;
        header = new Headers();

        var result:Result;

        var personA: Player = new Player();
        personA.eloNumber = aElo;
        var personB: Player = new Player();
        personB.eloNumber = bElo;
        var request: ElonumberRequest = new ElonumberRequest();

        request.setPersonA(personA);
        request.setPersonB(personB);
        request.setPointsA(pointsA);
        request.setPointsB(pointsB);

        console.log("Req: " + JSON.stringify(request));

        //var url = `http://localhost:8080/elo/calc/result.json?a=${aElo}&b=${bElo}&k=${kNumstr}&w=${winstr}`;
        //return this.http.get(url.toString(), {headers: header}).map(this.extractData);

        var url = `http://localhost:8080/elo/calc/result.json`;
        return this.http.post(url, request, {headers: header}).map(this.extractData);
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