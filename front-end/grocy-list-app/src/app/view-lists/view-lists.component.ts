import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { List } from '../services/list';
import { ListsService } from '../services/lists.service';

@Component({
  selector: 'app-view-lists',
  templateUrl: './view-lists.component.html',
  styleUrls: ['./view-lists.component.css']
})
export class ViewListsComponent implements OnInit {

  lists: List[];

  constructor(private router:Router, private listServ: ListsService) { }


  ngOnInit(): void {
    this.getAllLists();
  }

  getAllLists():void{
    let thisArray: List[];
    this.listServ.retrieveAllList().subscribe(
      response=>{
        thisArray = Object.values(response);
        this.lists=thisArray;
      }
    )
  }

  deleteList(id: number):void{
    let thisArray: List[];
    this.listServ.deleteList(id).subscribe(
      response=>{
        window.location.reload();
      }
    )
  }
 
}
 