import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Hardware } from '../interfaces/hardware';
import { HARDWARE } from './mock-hardware';

@Injectable({
  providedIn: 'root'
})
export class HardwareService {

  constructor() { }

  public getHardware(): Observable<Hardware[]> {
		return of(HARDWARE)
	}
}
