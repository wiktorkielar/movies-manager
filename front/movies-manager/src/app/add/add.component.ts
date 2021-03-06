import { element } from 'protractor';
import { HttpErrorResponse } from '@angular/common/http';
import { HTTPService } from './../../service/http.service';
import { Movie } from './../../model/movie/movie';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css'],
  providers: [HTTPService]
})
export class AddComponent implements OnInit {

  createdMovie: Movie;
  errorMessage: string;
  showSuccessMessage: boolean;

  movie: Movie = {
    id: '',
    title: '',
    rating: 10.00,
    director: '',
    actors: [],
    createdAt: '',
  };

  emptyAlert = 'Field cannot be empty.';

  lettersWithWhitespaceAlert = 'Field has to contain letters, without whitespaces, but whitespaces alone are not allowed.';
  lettersWithoutWhitespaceAlert = 'Field has to contain just letters, without any whitespaces.';

  minLengthAlert = 'Field has to contain at least 3 characters.';
  maxLengthAlert = 'Field has to contain 50 characters maximum.';

  minAlert = 'Field minimum value is 1.00';
  maxAlert = 'Field minimum value is 10.00';

  constructor(private httpService: HTTPService) {}

  ngOnInit() {
    this.errorMessage = '';
    this.showSuccessMessage = false;
  }

  createMovie() {
    this.showSuccessMessage = false;
    this.errorMessage = '';
    const preparedMovie = this.prepareMovie(this.movie);
    this.httpService.createMovie(preparedMovie).subscribe(
      (response: any) => (this.createdMovie = response, this.showSuccessMessage = true),
      (error: HttpErrorResponse) => (this.errorMessage = error.message)

    );

  }

  private prepareMovie(movie: Movie) {
    const urlEncodedActors = encodeURIComponent((<HTMLTextAreaElement>document.getElementById('movieActorsId')).value);
    const arrayOfActors = this.clean(urlEncodedActors.split('%0A'));
    const preparedMovie: Movie = JSON.parse(JSON.stringify(movie));
    preparedMovie.actors = arrayOfActors;
    return preparedMovie;
  }

  private clean(array: string[]) {
    const output: string[] = [];
    for (let element of array){
      if (!(element.trim() === '')) {
        output.push(element);
      }
    }
    return output;
  }

  private hideSuccessAlert() {
    this.showSuccessMessage = false;
  }

}
