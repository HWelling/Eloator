import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { AppComponent }        from './app.component';
import { HeroDetailComponent } from './hero-detail.component';
import { HeroesComponent }     from './heroes.component';
import { HeroService }         from './hero.service';
import { RouterModule }   from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { EloDashboardComponent} from './eloclient/dashboard.component';

@NgModule({
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    RouterModule.forRoot([
    {
      path: '',
      redirectTo: '/dashboard',
      pathMatch: 'full'
    },
    {
      path: 'heroes',
      component: HeroesComponent
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
    HeroesComponent,
    EloDashboardComponent
  ],
  providers: [
    HeroService
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule {
}
