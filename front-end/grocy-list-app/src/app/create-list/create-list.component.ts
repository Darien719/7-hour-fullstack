import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { List } from '../services/list';
import { ListsService } from '../services/lists.service';

@Component({
  selector: 'app-create-list',
  templateUrl: './create-list.component.html',
  styleUrls: ['./create-list.component.css']
})
export class CreateListComponent implements OnInit {

  name: string;

  list: List = {
    'id' : 0,
    'name':''
  };

  listgroup = new FormGroup({
    name: new FormControl(''),
  })
  
  constructor(private listServ: ListsService, private router: Router) { }

  ngOnInit(): void {
  }

  postList(listgroup: FormGroup){
    this.list.name = listgroup.get('name').value;

    this.listServ.postList(this.list).subscribe(
      response=>{
        window.alert("List created!")
      }, error => {
        window.alert("Could not create list");
      }
    );
  }

}
 