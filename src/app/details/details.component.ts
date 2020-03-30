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
  constructor(private router: Router,private route:ActivatedRoute,private courseService:CourseServiceService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params=>{
      this.id=params['id'];
    });
    this.viewDetails();

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
}
