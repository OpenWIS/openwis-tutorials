import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class MessageService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private url = '/cxf/api/echo/';  // URL to web api

  constructor(private http: Http) { }

    create(message): Promise<any> {
    
    var data:any = new Object();
    data.message = message;

      return this.http
      .post(this.url,  JSON.stringify(data), {headers: this.headers})
      .toPromise()
      .then(response => {
        ///hardcoded 
        return  JSON.parse(response["_body"]).message;
      }
    )
      .catch(this.handleError);
  }

   private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}