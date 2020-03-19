import { Component, OnInit } from '@angular/core';
import{FormGroup, FormControl} from '@angular/forms';
import { Router } from '@angular/router';
import * as classicEditor from '@ckeditor/ckeditor5-build-classic';
import {ViewChild} from '@angular/core';
import {CourseServiceService} from '../course-service.service';
@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  public editor=classicEditor;
  @ViewChild('editorReference') editorContent:any;
  levels:Array<any>=[];
  course_name="";
  slug:any;
  categories:Array<any>=[];
  textEditor:any;
  metaKey:string;

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
  constructor(private router:Router,private courseService:CourseServiceService) { }
   

  ngOnInit(): void {
    this.viewLevels();
    this.viewCategories();
  }
  onSubmit(){
    console.log(this.editorContent.editorInstance.getData());
   this.courseService.insert(this.createForm.value,this.metaKey,this.editorContent.editorInstance.getData()).subscribe((res:any)=>{
    this.router.navigate(['view']);
  });
                                    
  }
  public onReady( editor ) {
    editor.ui.getEditableElement().parentElement.insertBefore(
        editor.ui.view.toolbar.element,
        editor.ui.getEditableElement()
    );
}
// fetchEditorContent(){

//   console.log(this.editorContent.editorInstance.getData());

// }

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
