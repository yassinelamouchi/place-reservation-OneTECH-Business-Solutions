import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-seats',
  templateUrl: './seats.component.html',
  styleUrls: ['./seats.component.css']
})
export class SeatsComponent {

  //get current date from url
  date = this.route.snapshot.paramMap.get('date');
  index:number = -1;
  
  currentDate = new Date();

  constructor(private route: ActivatedRoute) { 

  }
  
  range = (num: number) => {
    return new Array(num).fill(0).map((_, i) => i);
  }

  onSeatClick(index: number) {
    this.index = index;
  }

}
