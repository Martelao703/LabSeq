import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { LabseqService } from '../../services/labseq/labseq.service';

@Component({
  selector: 'app-labseq',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './labseq.component.html',
  styleUrls: ['./labseq.component.css']
})
export class LabseqComponent {
  // The API is limited to 300000
  readonly MAX_N = 300_000;

  inputN = 0;                 // bound to the <input>
  lastComputedIndex?: number; // the n we displayed in the result
  result?: string;            // holds the API response
  errorMsg?: string;          // holds any error

  constructor(private svc: LabseqService) { }

  fetch() {
    // clear previous messages
    this.result = undefined;
    this.errorMsg = undefined;

    // Validation: must be a non-negative integer
    if (this.inputN == null || !Number.isInteger(this.inputN) || this.inputN < 0 || this.inputN > this.MAX_N) {
      this.errorMsg = `Please enter a non‑negative whole number bellow ${this.MAX_N}.`;
      return;
    }

    this.lastComputedIndex = this.inputN;

    this.svc.getLabseq(this.inputN).subscribe({
      next: v => this.result = v,
      error: e => this.errorMsg = e.message
    });
  }
}