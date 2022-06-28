import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-price-range',
  templateUrl: './price-range.component.html',
  styleUrls: ['./price-range.component.css']
})
export class PriceRangeComponent implements OnInit {

  @Input() price:number | undefined;
  message:string="no hardware selected";
  
  constructor() { }

  ngOnInit(): void {
  }
  ngOnChanges(){
    if(this.price){
      if(this.price<100){
        this.message="Ovaj hardver se ne može kupiti na rate."
      }
      if(this.price>=100 && this.price<400){
        this.message="Ovaj hardver se može kupiti na 6 rata."
      }
      if(this.price>=400 && this.price<800){
        this.message="Ovaj hardver se može kupiti na 12 rata."
      }
      if(this.price>=800){
        this.message="Ovaj hardver se može kupiti na 24 rate."
      }
    }
    
  }

}
