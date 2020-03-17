import { Component, OnInit } from '@angular/core';
import { CourseServiceService } from '../course-service.service';
import { Router } from '@angular/router';
import { Variable } from '@angular/compiler/src/render3/r3_ast';
@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {
   courses: Array<any> = []
   pages:Array<any>;
   file :string;
   result:string;
   config:any;
   x:number=0;
  constructor(private courseService:CourseServiceService,private router:Router) {
    this.config = {
      itemsPerPage: 10,
      currentPage: 1,
      totalItems: this.courses.length
    };
   }

  ngOnInit(): void {
    this.view()
    console.log(this.courses);
  } 
  view(){
    this.courseService.view().subscribe((res: any) => {
      this.courses=res;
      console.log(this.courses);
    });
  }
    
  onFileChanged = (event)=>{
   this.file=event.target.files[0]
    this.courseService.uploadImage(this.file).subscribe((res :any)=>{
      this.result=res;
      console.log(this.result);
    });
  
  }
  navigateToCreateComponent=()=>{
    this.router.navigate(['/create']);
  }
  onPageChange=(event)=>{
    this.config.currentPage=event;
    console.log('current page'+this.config.currentPage);
  }

  switchStatus(id:number){
    this.courseService.switchStatus(id).subscribe((res :any)=>{
      
      console.log("switching status function has been called");
    });
  }
 

}
