import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CustomerListComponent } from './components/customer-list/customer-list.component';
import { CustomerAddComponent } from './components/customer-add/customer-add.component';

@NgModule({
  declarations: [AppComponent, CustomerListComponent, CustomerAddComponent],
  imports: [BrowserModule, HttpClientModule],
  providers: [],
  bootstrap: [CustomerListComponent],
})
export class AppModule {}
