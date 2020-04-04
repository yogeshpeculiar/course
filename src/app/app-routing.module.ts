import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewComponent } from './view/view.component';
import {CreateComponent} from './create/create.component';
import {UpdateComponent} from './update/update.component'
import { CloneComponent } from './clone/clone.component';
import {DetailsComponent} from './details/details.component';
import{LoginComponent} from './login/login.component';
const routes: Routes = [
   {path:'',component:LoginComponent},
  {path:'create',component:CreateComponent},
  {path:'view',component:ViewComponent},
{path:'update',component:UpdateComponent},
{path:'clone',component:CloneComponent},
{path:'view/details',component:DetailsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes),
  
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
