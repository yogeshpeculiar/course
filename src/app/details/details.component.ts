import { Component, OnInit } from '@angular/core';
import {Router,ActivatedRoute} from '@angular/router';
import {CourseServiceService} from '../course-service.service';
@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  id:number;
  courseObject:any;
  availableFor:Array<any>=[];
  courseVideoMapping:Array<any>;
  listOfVideos:Array<any>=[];
  constructor(private router: Router,private route:ActivatedRoute,private courseService:CourseServiceService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params=>{
      this.id=params['id'];
    });
    this.viewDetails();
    this.viewExistingVideos();

  }

  viewDetails(){
    this.courseService.viewCourseById(this.id).subscribe((res)=>{
      this.courseObject=res;
      console.log("course name is"+this.courseObject.name)
      if(this.courseObject.isPreSignUp)
      this.availableFor.push("Pre-Signup");
    if(this.courseObject.isSlugLogin)
      this.availableFor.push("Slug-Login");
    if(this.courseObject.isDashboard)
      this.availableFor.push("Dashboard");
    });
  
  }
  back(){
  this.router.navigateByUrl("/view");
      }
  navigatToUpdateComponent=(id:number)=>{
    this.router.navigate(['/update'],{ queryParams: { id: id} });
  }
  navigatToCloneComponent=(id:number)=>{
    this.router.navigate(['/clone'],{ queryParams: { id: id} });
  }


  viewExistingVideos(){
    console.log("viewExistingVideos function is called..");
    this.courseService.viewVideoByCourseId(this.id).subscribe((res:Array<any>)=>{
     this.courseVideoMapping=res;
      console.log("response is:---------->"+this.courseVideoMapping)
      console.log("video id=======>"+this.courseVideoMapping[0].videoId)
      this.getVideoById();
    
    });

    
    }
    getVideoById(){
      let i=0;
      for(i=0;i<this.courseVideoMapping.length;i++){
        this.courseService.viewVideoById(this.courseVideoMapping[i].videoId).subscribe(
          (res)=>{
            this.listOfVideos.push(res);
            console.log("here res is===>"+res)
            console.log("current state of listOfVideos is==>"+this.listOfVideos)
          }
        );
      }
      console.log("result==========>"+this.listOfVideos.length);
     
    }
}
