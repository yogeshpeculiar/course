import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { map, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CourseServiceService {
  metakeywords:string;
  constructor(private http: HttpClient) { }
  view(){
    return this.http.get("http://localhost:5656/courses/")
  }
  uploadImage(file:string){
    
      return this.http.get("http://localhost:5656/courses/addImage"+file);
  }
  viewLevel(){
    return this.http.get("http://localhost:5656/courses/viewLevels")
  }
  viewCategory(){
    return this.http.get("http://localhost:5656/courses/viewCategories")
  }
  viewLevelById( id:number){
return this.http.get("http://localhost:5656/courses/viewLevelById"+id)
  }
  viewCategoryById( id:number){
    return this.http.get("http://localhost:5656/courses/viewCategoryById"+id)
      }
  viewCourseById(id:number){
    return this.http.get("http://localhost:5656/courses/viewCourseById/"+id);
  }
  update(data:any){
    const body={
        name: data.courseName,
        tag:data.tags.toString(),
        slug:data.slug,
        isLevelOverride:data.levelOverride,
        availableFor:data.availableFor,
        completionActivityPoints:data.completionActivityPoints,
        enrollmentActivityPoints:data.enrollmentActivityPoints,
        description:data.description,
        metaKey:data.metaKey.toString(),
        metaDesc:data.metaDescription,
        course_icon:data.chooseIcon,
        "docObj": [{
         "content": "this a test content"
        }],
        "courseSubscribedVideo": [
          {
              "id": 1,
              "video": {
                  "id": 1
                
              }
          }
      ],
      // levelObj:this.viewLevelById(data.level),
      "levelObj":{
        "id": 1
        
    },
      // categoryObj:this.viewCategoryById(data.category),
      "categoryObj":{
"id":1
      },
      isActive:"true"
      };
      const headers=new Headers();
      headers.append('Content-Type', 'application/json');
      return this.http.put("http://localhost:5656/courses/", body).pipe(map(res => res, { 'headers': headers }));
  
    }
  
  insert(data:any,metakeyarg:string,editorContent:string){
   
      const body={
        name: data.courseName,
        tag:data.tags,
        slug:data.slug,
        isLevelOverride:data.levelOverride,
        availableFor:data.availableFor,
        completionActivityPoints:data.completionActivityPoints,
        enrollmentActivityPoints:data.enrollmentActivityPoints,
        description:data.description,
        metaKey:metakeyarg.toString(),
        metaDesc:data.metaDescription,
        course_icon:data.chooseIcon,
        "docObj": [{
         "content": editorContent
      }
  ],

      levelObj:{
        "id":data.level
      },
      categoryObj:{
        "id":data.category
      },
      isActive:"true"
    
        
      };
      console.log(body);
      const headers=new Headers();
      headers.append('Content-Type', 'application/json');
      return this.http.post("http://localhost:5656/courses/", body).pipe(map(res => res, { 'headers': headers }));
  }

  switchStatus(id:number){
    return this.http.get("http://localhost:5656/courses/switchStatus/"+id);
  }
}
