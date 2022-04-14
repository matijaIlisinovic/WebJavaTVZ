import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HardwareListComponent } from './components/hardware-list/hardware-list.component';
import { HardwareDetailsComponent } from './components/hardware-details/hardware-details.component';

@NgModule({
  declarations: [
    AppComponent,
    HardwareListComponent,
    HardwareDetailsComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
