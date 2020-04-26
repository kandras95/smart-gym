import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PlansComponent } from './plans/plans.component';
import { ClientsComponent } from './clients/clients.component';
import { LoggedInGuardService } from 'src/logged-in-guard.service';


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, pathMatch: 'full', canActivate: [LoggedInGuardService] },
  { path: 'login', component: LoginComponent, pathMatch: 'full' },
  { path: 'plans', component: PlansComponent, pathMatch: 'full', canActivate: [LoggedInGuardService] },
  { path: 'clients', component: ClientsComponent, pathMatch: 'full', canActivate: [LoggedInGuardService] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
