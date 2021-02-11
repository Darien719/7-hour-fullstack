import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ViewListsComponent } from './view-lists/view-lists.component';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ListsService } from './services/lists.service';
import { CreateListComponent } from './create-list/create-list.component';
import { ViewItemComponent } from './view-item/view-item.component';
import { CreateItemComponent } from './create-item/create-item.component';

@NgModule({
  declarations: [
    AppComponent,
    ViewListsComponent,
    NavBarComponent,
    CreateListComponent,
    ViewItemComponent,
    CreateItemComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path:"create-list", component:CreateListComponent},
      {path:"view-items/:id", component:ViewItemComponent},
      {path:"create-item/:id", component:CreateItemComponent},
      {path:"**", component:ViewListsComponent},
    ]),HttpClientModule, FormsModule, ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [ListsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
