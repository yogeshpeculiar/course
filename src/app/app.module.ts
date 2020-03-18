import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ViewComponent } from './view/view.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CourseServiceService } from './course-service.service';
import { CreateComponent } from './create/create.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ReactiveFormsModule} from '@angular/forms'
import {TagInputModule} from 'ngx-chips';   //fot getting tags as input
import {NgxPaginationModule} from 'ngx-pagination';
import {CKEditorModule} from '@ckeditor/ckeditor5-angular';
import {Ng2SearchPipeModule } from 'ng2-search-filter';
@NgModule({
  declarations: [
    AppComponent,
    ViewComponent,
    CreateComponent,
    NavBarComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    TagInputModule,
    FormsModule,
    NgxPaginationModule,
    CKEditorModule,
    Ng2SearchPipeModule 
    
  ],
  providers: [
    HttpClient,
    CourseServiceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
