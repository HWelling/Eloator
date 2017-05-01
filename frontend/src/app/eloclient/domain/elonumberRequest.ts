import {Player} from './player';

export class ElonumberRequest {
    personA: Player;
    personB: Player;
    pointsA: Number;
    pointsB: Number;

    setPersonA(person:Player): void {
        this.personA = person;
    }

    setPersonB(person:Player): void {
        this.personB = person;
    }

    setPointsA(points:Number): void {
        this.pointsA = points;
    }

    setPointsB(points:Number): void {
        this.pointsB = points;
    }
}