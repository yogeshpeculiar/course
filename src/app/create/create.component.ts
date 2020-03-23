import { Component, OnInit } from '@angular/core';
import{FormGroup, FormControl} from '@angular/forms';
import { Router } from '@angular/router';
import * as classicEditor from '@ckeditor/ckeditor5-build-classic';
import {ViewChild} from '@angular/core';
import {CourseServiceService} from '../course-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  @ViewChild('editorReference') editorContent:any;
  public editor=classicEditor;
  saveEditorContent:boolean;
  contentInEditor:any;

  
  levels:Array<any>=[];
  course_name="";
  slug:any;
  categories:Array<any>=[];
  textEditor:any;
  metaKey:string;
  tagValue:string;

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
      editorName:new FormControl(),
      editorContentText:new FormControl()
});
  constructor(private router:Router,private courseService:CourseServiceService, private modalService:NgbModal) { }
   

  ngOnInit(): void {
    this.viewLevels();
    this.viewCategories();
  }
  onSubmit(){
    // this.contentInEditor=this.editorContent.editorInstance.getData();
   // console.log(this.contentInEditor);
   // console.log(this.editorContent.editorInstance.getData())
   console.log("form"+this.createForm.value)
   this.courseService.insert(this.createForm.value).subscribe((res:any)=>{
    this.router.navigate(['view']);
  });
                                    
  }
  public onReady( editor ) {
   // console.log("form value===>"+this.createForm.value)
   // console.log("onready method is called")
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
// showTextEditor(){
//   document.getElementById("textEditor").style.visibility="visible";
// }
open(content) {
  this.modalService.open(content,{
    size: 'xl'
});
}
 saveContent(){
  this.saveEditorContent=true;
  console.log("save method is called")
 // console.log(this.createForm.value)
  // console.log(this.editorContent)
  // console.log(this.editorContent.editorInstance.getData())
  this.modalService.dismissAll();
      }

}
