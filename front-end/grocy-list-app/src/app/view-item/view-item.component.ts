import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Item } from '../services/item';
import { ItemsService } from '../services/items.service';

@Component({
  selector: 'app-view-item',
  templateUrl: './view-item.component.html',
  styleUrls: ['./view-item.component.css']
})
export class ViewItemComponent implements OnInit {

  items: Item[];
  listNumber: any;
  num: number;
  
  constructor(private router:Router, private itemServ: ItemsService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.listNumber = this.route.params.subscribe(params => {
      this.listNumber = +params['id']; // (+) converts string 'id' to a number
      this.getAllItems(this.listNumber);

    });
  }

  getAllItems(id: number):void{
    let thisArray: Item[];
    this.num = id;
    this.itemServ.retrieveItemsByListId(id).subscribe(
      response=>{
        thisArray = Object.values(response);
        console.log(thisArray);
        this.items=thisArray;
      }
    )
  }

  deleteItem(id: number):void{
    let thisArray: Item[];
    this.itemServ.deleteItem(id).subscribe(
      response=>{
        window.location.reload();
      }
    )
  }

}
  