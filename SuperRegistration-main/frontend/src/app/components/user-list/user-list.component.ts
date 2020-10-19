import { Component, OnInit } from '@angular/core';
import { RestApiService } from "../../shared/rest-api.service";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: []
})
export class UserListComponent implements OnInit {

  User: any = [];

  constructor(public restApi: RestApiService) { }

  ngOnInit(): void {
    this.loadUsers()
  }

  loadUsers() {
    return this.restApi.getUsers().subscribe((data: {}) => {
      this.User = data;
    })
 }
}
