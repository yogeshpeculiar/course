import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewComponent } from './view/view.component';
import {CreateComponent} from './create/create.component';
import {UpdateComponent} from './update/update.component'

const routes: Routes = [
  {path:'',component:ViewComponent},
  {path:'create',component:CreateComponent},
  {path:'view',component:ViewComponent},
{path:'update',component:UpdateComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes),
  
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
