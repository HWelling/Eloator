import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { AppComponent }        from './app.component';
import { HeroDetailComponent } from './hero-detail.component';
import { HeroesComponent }     from './heroes.component';
import { HeroService }         from './hero.service';
import { RouterModule }   from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { EloDashboardComponent } from './eloclient/dashboard.component';
import { EloCalculatorComponent } from './eloclient/calculator.component';
import { EloCalcService } from './eloclient/service/elocal.service';
import {HttpModule} from '@angular/http';
 
 
@NgModule({
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
    {
      path: '',
      redirectTo: '/dashboard',
      pathMatch: 'full'
    },
    {
      path: 'calculator',
      component: EloCalculatorComponent
    },
    {
      path: 'dashboard',
      component: EloDashboardComponent
    },
    {
      path: 'detail/:id',
      component: HeroDetailComponent
    }
])
  ],
  declarations: [
    AppComponent,
    HeroDetailComponent,
    EloCalculatorComponent,
    EloDashboardComponent
  ],
  providers: [
    EloCalcService
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule {
}
