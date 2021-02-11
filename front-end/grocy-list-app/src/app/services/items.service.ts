import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from './item';

@Injectable({
  providedIn: 'root'
})
export class ItemsService {

  
  constructor(private httpCli: HttpClient) { }

  retrieveItemsByListId(id: number): Observable<Item> {
    let url = "http://localhost:9025/item/grocerylist/"
    url = url + id;
    return this.httpCli.get<Item>(url);
  }

  postItem(item: Item): Observable<String> {
    let url = "http://localhost:9025/item"
    return this.httpCli.post<String>(url, JSON.stringify(item), {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }), responseType: 'text' as 'json'
    });
  }

  deleteItem(id: number): Observable<String> {
    var deleteUrl = "http://localhost:9025/item/"
    deleteUrl = deleteUrl + id;
    return this.httpCli.delete<String>(deleteUrl, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }), responseType: 'text' as 'json'
    });
  }

}
 