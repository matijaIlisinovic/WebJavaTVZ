import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HardwareListComponent } from './components/hardware-list/hardware-list.component';
import { HardwareDetailsComponent } from './components/hardware-details/hardware-details.component';
import { ReviewSearchComponent } from './components/review-search/review-search.component';
import { ReviewDetailsComponent } from './components/review-details/review-details.component';

const routes: Routes = [
  { path: 'hardware', component: HardwareListComponent },
  { path: 'hardware/:id', component: HardwareDetailsComponent },
  { path: 'reviewSearch', component: ReviewSearchComponent },
  { path: 'reviewSearch/:id', component: ReviewDetailsComponent }
  ];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
    ],
    exports: [
    RouterModule
    ]
})
export class AppRoutingModule { }
