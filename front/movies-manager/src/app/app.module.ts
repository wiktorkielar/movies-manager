import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { HTTPService } from './../service/http.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { routing } from './app.routes';

import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { BestComponent } from './best/best.component';
import { WorstComponent } from './worst/worst.component';
import { AddComponent } from './add/add.component';
import { DashboardComponent } from './dashboard/dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    BestComponent,
    WorstComponent,
    AddComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    routing,
    HttpClientModule,
    HttpModule,
  ],
  providers: [HTTPService],
  bootstrap: [AppComponent]
})
export class AppModule { }
