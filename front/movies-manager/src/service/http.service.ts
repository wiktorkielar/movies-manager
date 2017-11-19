import { Movie } from './../model/movie/movie';
import { Request, Headers, Response, RequestOptions } from '@angular/http';
import { HttpClient, HttpClientModule, HttpParams, HttpHeaders } from '@angular/common/http';
import { HttpServiceSettings } from './http.service.settings';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class HTTPService {
    constructor (private httpClient: HttpClient) {}

    getMovies(sortDirection: string) {
        const url = HttpServiceSettings.GET_MOVIES_ENDPOINT + '?sortDirection=' + sortDirection;
        return this.httpClient.get(url);
    }

    createMovie(movie: Movie) {
        const url = HttpServiceSettings.CREATE_MOVIE_ENDPOINT;
        let actorsString = '';
        for (const actor of movie.actors){
            actorsString += '&actors=' + actor;
        }

        const body =
            'title=' + movie.title +
            '&rating=' + movie.rating +
            '&director=' + movie.director +
            actorsString;

        return this.httpClient.post(
            url,
            body
        ,
        {
            headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded'),
        }
    );
    }

    deleteMovie(id: string) {
        const url = HttpServiceSettings.DELETE_MOVIE_ENDPOINT + '/' + id;
        return this.httpClient.delete(url);
    }


}
