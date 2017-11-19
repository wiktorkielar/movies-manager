import { HTTPService } from './../../service/http.service';
import { Movie } from './../../model/movie/movie';
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-best',
  templateUrl: './best.component.html',
  styleUrls: ['./best.component.css'],
  providers: [HTTPService]
})
export class BestComponent implements OnInit {
  id: string;
  moviesList: Movie[];
  errorMessage: string;
  showSuccessMessage: boolean;

  constructor(private httpService: HTTPService) { }

  ngOnInit() {
    this.errorMessage = '';
    this.getMovies();
    this.showSuccessMessage = false;
  }

  public getMovies() {
    this.httpService.getMovies('DESC').subscribe(
      (response: any) => (this.moviesList = response),
      (error: HttpErrorResponse) => (this.errorMessage = error.message)
    );
  }

  public deleteMovie() {
    this.httpService.deleteMovie(this.id).subscribe(
      (response: any) => (this.hideModal(), this.showSuccessMessage = true, this.getMovies()),
      (error: HttpErrorResponse) => (this.hideModal(), this.errorMessage = error.message)
    );
  }

  private parseDate(date: string) {
    return date.replace('T', '<br>');
  }

  private hideModal() {
    document.getElementById('modal-close-button').click();
  }

  private copyIdAndHideSuccessAlert(id: string) {
    this.id = id;
    this.showSuccessMessage = false;
  }

}
