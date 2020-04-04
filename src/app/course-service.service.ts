import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { map, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CourseServiceService {
  metakeywords:string;
  textContent:string;
  editorName:string;
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
  update(data:any,id:number,docId:number,videoToBeAddedArray:Array<any>,createdOn:any){
    let body={};
    if(docId!=null){
      console.log("updateing existing document")
     body={
     id:id,
        name: data.courseName,
        tag:data.tags.toString(),
        slug:data.slug,
        isLevelOverride:data.levelOverride,
        completionActivityPoints:data.completionActivityPoints,
        enrollmentActivityPoints:data.enrollmentActivityPoints,
        description:data.description,
        metaKey:data.metaKey.toString(),
        metaDesc:data.metaDescription,
        course_icon:data.chooseIcon,
        isPreSignUp:data.isPreSignUp,
        isDashboard:data.isDashboard,
        isSlugLogin:data.isSlugLogin,
        createdOn:createdOn,
        docObj: [{
          id:docId,
          name:data.editorName,
         content:data.editorContentText
        }],
        courseSubscribedVideo:videoToBeAddedArray,
     levelId:data.level,
      categoryId:data.category,
      isActive:"true"
      };
    }
    else{
      console.log("updateing new document")
       body={
        id:id,
           name: data.courseName,
           tag:data.tags.toString(),
           slug:data.slug,
           isLevelOverride:data.levelOverride,
           isPreSignUp:data.isPreSignUp,
           isDashboard:data.isDashboard,
           isSlugLogin:data.isSlugLogin,
           completionActivityPoints:data.completionActivityPoints,
           enrollmentActivityPoints:data.enrollmentActivityPoints,
           description:data.description,
           metaKey:data.metaKey.toString(),
           metaDesc:data.metaDescription,
           course_icon:data.chooseIcon,
           createdOn:createdOn,
           docObj: [{
            name:data.newEditorName,
            content:data.newEditorContentText
           }],
           "courseSubscribedVideo":videoToBeAddedArray,
        levelId:data.level,
         categoryId:data.category,
         isActive:"true"
         };

    }
     
      
      // console.log(body.levelId);
      const headers=new Headers();
      headers.append('Content-Type', 'application/json');
      return this.http.put("http://localhost:5656/courses/", body).pipe(map(res => res, { 'headers': headers }));
  
    }
  
  insert(data:any,videoToBeAddedArray:Array<any>){
   
      const body={
        name: data.courseName,
        tag:data.tags.toString(),
        slug:data.slug,
        isLevelOverride:data.levelOverride,
        isPreSignUp:data.isPreSignUp,
        isDashboard:data.isDashboard,
        isSlugLogin:data.isSlugLogin,
        completionActivityPoints:data.completionActivityPoints,
        enrollmentActivityPoints:data.enrollmentActivityPoints,
        description:data.description,
        metaKey:data.metaKey.toString(),
        metaDesc:data.metaDescription,
        course_icon:data.chooseIcon,
        "docObj": [{
          "name":data.editorName,
         "content": data.editorContentText
      }
  ],

      levelObj:{
        "id":data.level
      },
      categoryObj:{
        "id":data.category
      },
      isActive:"true",
      courseSubscribedVideo:videoToBeAddedArray,
  
        
      };
      console.log(body);
      const headers=new Headers();
      headers.append('Content-Type', 'application/json');
      return this.http.post("http://localhost:5656/courses/", body).pipe(map(res => res, { 'headers': headers }));
  }
  
  clone(data:any,docId:number){
   if(docId!=null){
   this.textContent=data.editorContentText;
  this.editorName=data.editorName; 
  }
   else{
   this.textContent=data.newEditorContentText;
   this.editorName=data.newEditorName;
  }
    const body={
      name: data.courseName,
      tag:data.tags.toString(),
      slug:data.slug,
      isLevelOverride:data.levelOverride,
      isPreSignUp:data.isPreSignUp,
      isDashboard:data.isDashboard,
      isSlugLogin:data.isSlugLogin,
      completionActivityPoints:data.completionActivityPoints,
      enrollmentActivityPoints:data.enrollmentActivityPoints,
      description:data.description,
      metaKey:data.metaKey.toString(),
      metaDesc:data.metaDescription,
      course_icon:data.chooseIcon,
      "docObj": [{
        "name":this.editorName,
       "content":this.textContent
    }
],

    levelObj:{
      "id":data.level
    },
    categoryObj:{
      "id":data.category
    },
    isActive:"true",
    "courseSubscribedVideo":[
      {
        "video": {
          "id": 1
        }
      }

    ]

      
    };
    console.log(body);
    const headers=new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post("http://localhost:5656/courses/", body).pipe(map(res => res, { 'headers': headers }));
}

  switchStatus(id:number){
    return this.http.get("http://localhost:5656/courses/switchStatus/"+id);
  }
  viewDocByCourseId(id:number){
    return this.http.get("http://localhost:5656/courses/viewDocByCourseId/"+id);
  }
  viewVideoByCourseId(id:number){
    return this.http.get("http://localhost:5656/courses/viewVideoByCourseId/"+id);
  }
  viewAllVideos(){
    return this.http.get("http://localhost:5656/videos/listAll");
  }
  viewVideoById(id:number){
    return this.http.get("http://localhost:5656/videos/listVideoById/"+id);
  }
  deleteCourseVideoMapping(id:number){
    return this.http.delete("http://localhost:5656/courses/deleteCourseVideoMappingById/"+id);
  }
  delete(id:number)
  {
    return this.http.delete("http://localhost:5656/courses/"+id);
  }
  login(loginData:any){
    const body={
      username:loginData.userName,
      password:loginData.password
    }
    const headers=new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post("http://localhost:5656/courses/authenticate", body).pipe(map(res => res, { 'headers': headers }));
  }
}
