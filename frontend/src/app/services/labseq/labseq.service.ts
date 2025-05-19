import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError }        from 'rxjs';
import { map, catchError }               from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class LabseqService {
  private readonly baseUrl = '/api/labseq';

  constructor(private http: HttpClient) {}

  /**
   * Calls GET /api/labseq/{n}
   * Expects the backend to return a single value
   */
  getLabseq(n: number): Observable<string> {
    return this.http
      .get(`${this.baseUrl}/${n}`, { responseType: 'text' })
      .pipe(
        map(v => v.toString()),
        catchError(this.handleError)
      );
  }

  private handleError(err: HttpErrorResponse) {
    // Build a user-friendly error message
    let msg: string;
    if (err.error instanceof ErrorEvent) {
      msg = `Client error: ${err.error.message}`;
    } else {
      msg = `Server error ${err.status}: ${err.error}`;
    }
    return throwError(() => new Error(msg));
  }
}