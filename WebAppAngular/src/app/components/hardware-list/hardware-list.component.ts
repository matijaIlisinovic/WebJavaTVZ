import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Hardware } from 'src/app/interfaces/hardware';
import { HardwareService } from 'src/app/services/hardware.service';

@Component({
  selector: 'app-hardware-list',
  templateUrl: './hardware-list.component.html',
  styleUrls: ['./hardware-list.component.css']
})
export class HardwareListComponent implements OnInit {

  selectedHardware:Hardware | undefined;
  hardware:Hardware[] | undefined;

  constructor(private hardwareService:HardwareService) { }

  ngOnInit(): void {
    this.getHardware();
  }

  getHardware(): void {
    this.hardwareService.getHardware()
    .subscribe(hardware => this.hardware = hardware);
    }

  onSelect(hardware: Hardware): void {
    this.selectedHardware = hardware;
    }

  onDelete(id:string):void{
    this.hardwareService.deleteHardwareById(id).subscribe()
    this.getHardware()
  }
}
