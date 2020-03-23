import { Component, OnInit } from '@angular/core';
import{FormGroup, FormControl} from '@angular/forms';
import { Router,ActivatedRoute } from '@angular/router';
import * as classicEditor from '@ckeditor/ckeditor5-build-classic';
import {ViewChild} from '@angular/core';
import {CourseServiceService} from '../course-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  public editor=classicEditor;
  // @ViewChild('editorReference') editorContent:any;
  
  levels:Array<any>=[];
  course_name="";
  slug:any;
  categories:Array<any>=[];
  textEditor:any;
  metaKey:string;
  tags:string;
  id:number;
  existingData:any;
  saveEditorContent:boolean;
  listOfDocs:any;
  currentDoc:any;
  docId:number;
  
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
    newEditorName:new FormControl(),
    newEditorContentText:new FormControl(),
    editorName:new FormControl(),
    editorContentText:new FormControl(),
    
   
  });
  constructor(private router:Router,private courseService:CourseServiceService,private activeroute: ActivatedRoute,private modalService:NgbModal) { }

  ngOnInit(): void {
   
    this.activeroute.queryParams.subscribe(params => {
      this.id = params['id'];
      //console.log("-----------"+params['id'])
    });
    this.viewExistingDataOfChoosenId();
    this.viewLevels();
    this.viewCategories();
    this.viewExistingDocs();
    
  }
  viewExistingDataOfChoosenId(){
console.log("fetched id : ==>"+this.id);
    this.courseService.viewCourseById(this.id).subscribe((res:any)=>{
    this.existingData=res;
    console.log("existing data  =>"+this.existingData.levelObj.name);
    this.loadValueInUpdateForm();//mapping is done
  });
     
  }
  public loadValueInUpdateForm(){
    console.log("loadvalue function is called"+this.existingData);
    console.log("level_id=====>"+this.existingData.levelObj.id);
    //console.log("document id is===>"+this.existingData.docObj[0].id)
    this.createForm.patchValue({
   
    courseName:this.existingData.name,
    level:this.existingData.levelObj.id,
    category:this.existingData.categoryObj.id,
    slug:this.existingData.slug,
    tags:this.existingData.tag.split(','),
    levelOverride:this.existingData.isLevelOverride,
    availableFor:this.existingData.availableFor,
    completionActivityPoints:this.existingData.completionActivityPoints,
    enrollmentActivityPoints:this.existingData.enrollmentActivityPoints,
    description:this.existingData.description,
    metaKey:this.existingData.metaKey.split(','),
    metaDescription:this.existingData.metaDesc,
    chooseIcon:this.existingData.course_icon,
    // editorText:this.existingData.docObj.content,
    // editorID:this.existingData.docObj[0].id
    });
   
    // console.log(this.existingData.name);
  }
  public onReadyForNewEntry( editor ) {
    editor.ui.getEditableElement().parentElement.insertBefore(
        editor.ui.view.toolbar.element,
        editor.ui.getEditableElement()
    );
}
public onReadyForExitstingEntry( editor ,doc:any) {
  editor.ui.getEditableElement().parentElement.insertBefore(
      editor.ui.view.toolbar.element,
      editor.ui.getEditableElement()
  );
  editor.setData(doc.content);
 
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

onSaveAsNewVersion(){
  console.log("form_value====>"+this.createForm.value.level);
  // console.log("text editor==>"+this.editorContent.editorInstance.getData())
  if(this.currentDoc)
  this.docId=this.currentDoc.id;
  else 
  this.docId=null;
  this.courseService.update(this.createForm.value,this.id,this.docId).subscribe(
    (res)=>{
      console.log(res);
    }
  );

}
open(content) {
  this.modalService.open(content,{
    size: 'xl'
});
// document.getElementById('docName').setAttribute('value',this.currentDoc.name);
}
openExistingDoc(exisingContent,doc:any){
  this.currentDoc=doc;
  
  console.log("document name==>"+this.currentDoc.name);
  console.log("modal is being opened")
  this.modalService.open(exisingContent);
  this.createForm.controls['editorName'].setValue(this.currentDoc.name);
  // this.ref=document.getElementById('docName');
  //document.getElementById('docName').setAttribute('value',this.currentDoc.name);
  // this.ref.select();
  // this.ref.value=this.currentDoc.name;
  // console.log("value of the reference"+ document.getElementById('docName'))
 
console.log("the id of the clicked document is==>"+doc.id);
//this.editorContenttwo.editorInstance.setData(doc.content);
}
 saveContent(){
  this.saveEditorContent=true;
  console.log("save method is called")
 // console.log(this.createForm.value)
  // console.log(this.editorContent)
  // console.log(this.editorContent.editorInstance.getData())
  this.modalService.dismissAll();
      }
      viewExistingDocs(){
        this.courseService.viewDocByCourseId(this.id).subscribe((res)=>{
          this.listOfDocs=res;
        });
      }
}
