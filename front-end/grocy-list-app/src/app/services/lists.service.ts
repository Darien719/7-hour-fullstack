import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { List } from './list';

@Injectable({
  providedIn: 'root'
})
export class ListsService {
  private allListsUrl = "http://localhost:9025/list/all";
  private createListUrl = "http://localhost:9025/list";

  constructor(private httpCli: HttpClient) { }

  retrieveAllList(): Observable<List> {
    return this.httpCli.get<List>(this.allListsUrl);
  }

  postList(list: List): Observable<String> {
    return this.httpCli.post<String>(this.createListUrl, JSON.stringify(list), {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }), responseType: 'text' as 'json'
    });
  }

  deleteList(id: number): Observable<String> {
    var deleteUrl = "http://localhost:9025/list/"
    deleteUrl = deleteUrl + id;
    return this.httpCli.delete<String>(deleteUrl, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }), responseType: 'text' as 'json'
    });
  }

}
   