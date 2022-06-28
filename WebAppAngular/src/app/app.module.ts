import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HardwareListComponent } from './components/hardware-list/hardware-list.component';
import { HardwareDetailsComponent } from './components/hardware-details/hardware-details.component';
import { PriceRangeComponent } from './components/price-range/price-range.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { HardwareFormComponent } from './components/hardware-form/hardware-form.component';
import { ReviewListComponent } from './components/review-list/review-list.component';
import { ReviewSearchComponent } from './components/review-search/review-search.component';
import { ReviewDetailsComponent } from './components/review-details/review-details.component';


@NgModule({
  declarations: [
    AppComponent,
    HardwareListComponent,
    HardwareDetailsComponent,
    PriceRangeComponent,
    HardwareFormComponent,
    ReviewListComponent,
    ReviewSearchComponent,
    ReviewDetailsComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
