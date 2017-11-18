import { Movie } from './../movie/movie';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  movie: Movie = {
    id: '',
    title: '',
    rating: 10.00,
    director: '',
    actors: [],
    createdAt: '',
  };

  emptyAlert = 'Field cannnot be empty.';

  lettersWithWhitespaceAlert = 'Field has to contain letters, without whitespaces, but whitespaces alone are not allowed.';
  lettersWithoutWhitespaceAlert = 'Field has to contain just letters, without any whitespaces.';

  minLengthAlert = 'Field has to contain at least 3 characters.';
  maxLengthAlert = 'Field has to contain 50 characters maximum.';

  minAlert = 'Field minimum value is 1.00';
  maxAlert = 'Field minimum value is 10.00';

  constructor() { }

  ngOnInit() {
  }

  send(movie: Movie) {
    const preparedMovie = this.prepareMovie(movie);
    console.log(preparedMovie);
  }

  private prepareMovie(movie: Movie) {
    const urlEncodedActors = encodeURIComponent((<HTMLTextAreaElement>document.getElementById('movieActorsId')).value);
    const arrayOfActors = urlEncodedActors.split('%0A');
    const preparedMovie: Movie = JSON.parse(JSON.stringify(movie));
    preparedMovie.actors = arrayOfActors;
    return preparedMovie;
  }

}
