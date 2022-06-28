import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Hardware } from 'src/app/interfaces/hardware';
import { HardwareService } from 'src/app/services/hardware.service';

@Component({
  selector: 'app-hardware-details',
  templateUrl: './hardware-details.component.html',
  styleUrls: ['./hardware-details.component.css']
})
export class HardwareDetailsComponent implements OnInit {

  hardware:Hardware|undefined;
  id: string | null | undefined;

  constructor(private hardwareService:HardwareService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    if(this.id){
      this.hardwareService.getHardwareById(this.id).subscribe(hardware => this.hardware = hardware); 
    }
  }

  ngOnChange(){
    
  }
}
