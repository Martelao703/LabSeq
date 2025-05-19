import { Component }       from '@angular/core';
import { LabseqComponent } from './components/labseq/labseq.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [LabseqComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
}
