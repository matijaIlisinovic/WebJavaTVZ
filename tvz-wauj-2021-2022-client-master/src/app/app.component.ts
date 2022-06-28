import {Component} from '@angular/core';
import {AuthenticationService} from "./security/authentication.service";
import {Router} from "@angular/router";
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Hardware App';
  currentLanguage:string | undefined;

  constructor(
    private translate: TranslateService,
    public authenticationService: AuthenticationService,
    private router: Router
  ) {
    translate.setDefaultLang('hr');
    translate.use('hr');
    this.currentLanguage='hr';
  }

  logout() {
    this.authenticationService.logout();
    this.router.navigate(['/login']).then();
  }

  onLanguageChange(chosenLang:string){
    this.translate.use(chosenLang);
    this.currentLanguage=chosenLang;
  }
}
