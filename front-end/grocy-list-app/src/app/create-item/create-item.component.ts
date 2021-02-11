import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Item } from '../services/item';
import { ItemsService } from '../services/items.service';
import { ListsService } from '../services/lists.service';

@Component({
  selector: 'app-create-item',
  templateUrl: './create-item.component.html',
  styleUrls: ['./create-item.component.css']
})
export class CreateItemComponent implements OnInit {

  id: number;
  cost: number;
  name: String;
  grocery_list_id: any;
  type_id: number;

  constructor(private itemServ: ItemsService, private router: Router, private route: ActivatedRoute) { }

  item: Item = {
    'id' : 0,
    'cost': 0,
    'name': '',
    'grocery_list_id': 0,
    'type_id': 0
  };

  itemgroup = new FormGroup({
    id: new FormControl(''),
    cost: new FormControl(''),
    name: new FormControl(''),
    grocery_list_id: new FormControl(''),
    type_id: new FormControl('')
  })


  ngOnInit(): void {
  }

  postItem(listgroup: FormGroup){
    this.item.cost = listgroup.get('cost').value;
    this.item.name = listgroup.get('name').value;
    this.grocery_list_id = this.route.params.subscribe(params => {
      this.item.grocery_list_id = +params['id']; // (+) converts string 'id' to a num
    });
    this.item.type_id = listgroup.get('type_id').value;

    this.itemServ.postItem(this.item).subscribe(
      response=>{
        window.alert("List created!")
      }, error => {
        window.alert("Could not create list");
      }
    );
  }

}
 