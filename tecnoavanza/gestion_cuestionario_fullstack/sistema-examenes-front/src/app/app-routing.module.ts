import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
//import { AdminGuard } from './services/admin.guard';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
//import { DashboardComponent } from './pages/dashboard/dashboard.component';
//import { userDashboardComponent } from './pages/user-dashboard/pages/user-dashboard.component';


const routes: Routes = [
  {
    path : '',
    component : HomeComponent,
    pathMatch : 'full'
  },
  {
    path : 'signup',
    component : SignupComponent,
    pathMatch : 'full'
  },
  {
    path : 'login',
    component : LoginComponent,
    pathMatch : 'full'
  },
  /*{
    path : 'admin',
    component : DashboardComponent,
    pathMatch : 'full',
    canActivate : [AdminGuard]
  }
  {
    path : 'user-dashboard',
    component : userDashboardComponent,
    pathMatch : 'full',
    canActivate : [NormalGuard]
  }*/
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
