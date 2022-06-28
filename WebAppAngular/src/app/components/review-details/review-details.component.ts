import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Hardware } from 'src/app/interfaces/hardware';
import { Review } from 'src/app/interfaces/review';
import { HardwareService } from 'src/app/services/hardware.service';
import { ReviewService } from 'src/app/services/review.service';

@Component({
  selector: 'app-review-details',
  templateUrl: './review-details.component.html',
  styleUrls: ['./review-details.component.css']
})
export class ReviewDetailsComponent implements OnInit {
  review:Review | undefined;
  hardware:Hardware | undefined;
  id:string|null|undefined;

  constructor(
    private hardwareService:HardwareService,
    private reviewService:ReviewService, 
    private route: ActivatedRoute
    ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    if(this.id){
      this.reviewService.getReviewById(+this.id).subscribe(
        review=>{
          this.review=review;
          this.hardwareService.getHardwareById(this.review.hardwareId)
        .subscribe(hardware=>this.hardware=hardware);
      })
    }
    
  }

}

