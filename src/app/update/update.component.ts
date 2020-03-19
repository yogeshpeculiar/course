import { Component, OnInit } from '@angular/core';
import{FormGroup, FormControl} from '@angular/forms';
import { Router,ActivatedRoute } from '@angular/router';
import * as classicEditor from '@ckeditor/ckeditor5-build-classic';
import {ViewChild} from '@angular/core';
import {CourseServiceService} from '../course-service.service';
@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  public editor=classicEditor;
  @ViewChild('editorReference') editorContent:any;
  levels:Array<any>=[];
  course_name="";
  slug:any;
  categories:Array<any>=[];
  textEditor:any;
  metaKey:string;
  tags:string;
  id:number;
  existingData:any;
  
  createForm=new FormGroup({
    courseName:new FormControl(),
    level:new FormControl(),
    category:new FormControl(),
    tags:new FormControl(),
    slug:new FormControl(),
    levelOverride:new FormControl(),
    availableFor:new FormControl(),
    completionActivityPoints:new FormControl(),
    enrollmentActivityPoints:new FormControl(),
    description:new FormControl(),
    metaKey:new FormControl(),
    metaDescription:new FormControl(),
    chooseIcon:new FormControl(),
  });
  constructor(private router:Router,private courseService:CourseServiceService,private activeroute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activeroute.queryParams.subscribe(params => {
      this.id = params['id'];
      //console.log("-----------"+params['id'])
    });
    this.viewExistingDataOfChoosenId();
    this.viewLevels();
    this.viewCategories();
  }
  viewExistingDataOfChoosenId(){
//console.log("fetched id : ==>"+this.id);
    this.courseService.viewCourseById(this.id).subscribe((res:any)=>{
     
      this.existingData=res;
      console.log("existing data  =>"+this.existingData.levelObj.name);
    });
  }
  public onReady( editor ) {
    editor.ui.getEditableElement().parentElement.insertBefore(
        editor.ui.view.toolbar.element,
        editor.ui.getEditableElement()
    );
}
navigateToSeekEditor(){
  this.router.navigate(['seek-editor']);
}
viewLevels(){
  this.courseService.viewLevel().subscribe(
    (res:any)=>{
        this.levels=res;
        // console.log(this.levels);
        
    }
  );
}
viewCategories(){
  this.courseService.viewCategory().subscribe(
    (res:any) =>{
      this.categories=res;
    }
  );

}
showTextEditor(){
document.getElementById("textEditor").style.visibility="visible";
}
}
