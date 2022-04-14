import { Component, Input, OnInit } from '@angular/core';
import { Hardware } from 'src/app/interfaces/hardware';

@Component({
  selector: 'app-hardware-details',
  templateUrl: './hardware-details.component.html',
  styleUrls: ['./hardware-details.component.css']
})
export class HardwareDetailsComponent implements OnInit {

  @Input() hardware: Hardware | undefined;

  constructor() { }

  ngOnInit(): void {
  }

}
