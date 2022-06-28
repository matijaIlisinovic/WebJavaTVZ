import { Component, Input, OnInit } from '@angular/core';
import { Review } from 'src/app/interfaces/review';
import { ReviewService } from 'src/app/services/review.service';

@Component({
  selector: 'app-review-list',
  templateUrl: './review-list.component.html',
  styleUrls: ['./review-list.component.css']
})
export class ReviewListComponent implements OnInit {
  @Input() hardwareId: string | undefined;

  selectedReview: Review | undefined;
  reviews: Review[] | undefined;

  constructor(private reviewService:ReviewService) { }

  ngOnInit(): void {
    this.getReviews();
  }
  getReviews() {
    if(this.hardwareId)
    this.reviewService.getReviewByHardware(this.hardwareId)
    .subscribe(reviews => this.reviews = reviews)
  }

  onSelect(review:Review){
    this.selectedReview=review;
  }

}
