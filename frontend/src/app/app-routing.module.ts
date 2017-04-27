import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeroesComponent }      from './heroes.component';
import { HeroDetailComponent }  from './hero-detail.component';
import { EloDashboardComponent} from './eloclient/dashboard.component';
import { EloCalculatorComponent } from './eloclient/calculator.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard',  component: EloDashboardComponent },
  { path: 'detail/:id', component: HeroDetailComponent },
  { path: 'calculator',     component: EloCalculatorComponent }
];
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
