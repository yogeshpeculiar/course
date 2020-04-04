import { Component, OnInit } from '@angular/core';
import{FormGroup, FormControl} from '@angular/forms';
import { Router} from '@angular/router';
import { CourseServiceService} from '../course-service.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private courseService: CourseServiceService,private router:Router) { }

  ngOnInit(): void {
    localStorage.clear();
  }

  loginForm=new FormGroup({
    userName:new FormControl(),
    password:new FormControl()
  });
  onSubmit(){
    this.courseService.login(this.loginForm.value).subscribe((res:any)=>{
      const token= res.data.jwt;
      console.log("JWT TOKEN IS--->"+token)
      localStorage.setItem('token', JSON.stringify(token));
        this.router.navigate(['/view']) 
    });
  }
}
