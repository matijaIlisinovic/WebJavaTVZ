import { Component, OnInit } from '@angular/core';
import { HardwareService } from 'src/app/services/hardware.service';


@Component({
  selector: 'app-hardware-form',
  templateUrl: './hardware-form.component.html',
  styleUrls: ['./hardware-form.component.css']
})
export class HardwareFormComponent implements OnInit {

  constructor(private hardwareService:HardwareService) { }

  ngOnInit(): void {
  }
  add(id: string, name: string, price: number, type:string, numberOf: number): void {
    id = id.trim();
    name = name.trim();
    type = type.trim();
    if (!id || ! name || !type || !price || !numberOf) { return; }
    this.hardwareService.addHardware({ id,name,price,type,numberOf})
    .subscribe();
    }
    
    

}
