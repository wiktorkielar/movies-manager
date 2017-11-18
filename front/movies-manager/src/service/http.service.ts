import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class HTTPService {
    constructor (private http: Http) {}

    getMovies() {
        return this.http.get('url')
        .map(response => response.json());
    }

    createMovie() {}

    deleteMovie() {}


}
