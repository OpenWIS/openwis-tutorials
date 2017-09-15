import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions, URLSearchParams } 
from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class MessageService {
    headers: Headers;
    options: RequestOptions;

    constructor(private http: Http) {
        this.headers = new Headers({ 'Content-Type': 'application/json', 
                                     'Accept': 'application/json' });
        this.options = new RequestOptions({ headers: this.headers });
    }

    create(url: string, param: any): Promise<any> {
    let body = JSON.stringify(param);
    return this.http
        .post(url, body, this.options)
        .toPromise()
        .then(this.extractData)
        .catch(this.handleError);
    }  

    private extractData(res: Response) {
        let body = res.json();
        return body || {};
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}