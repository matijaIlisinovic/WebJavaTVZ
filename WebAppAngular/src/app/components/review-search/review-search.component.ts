import { Component, OnInit } from '@angular/core';
import { Review } from 'src/app/interfaces/review';
import { ReviewService } from 'src/app/services/review.service';

@Component({
  selector: 'app-review-search',
  templateUrl: './review-search.component.html',
  styleUrls: ['./review-search.component.css']
})
export class ReviewSearchComponent implements OnInit {
  reviews:Review[] | undefined;
  selectedReview:Review  | undefined;

  constructor(private reviewService:ReviewService) { }

  ngOnInit(): void {
  }

  add(title:string){
    this.reviewService.getReviewByTitle(title).subscribe(reviews=>this.reviews=reviews);
  }
  onSelect(review:Review){
    this.selectedReview=review;
  }

}
