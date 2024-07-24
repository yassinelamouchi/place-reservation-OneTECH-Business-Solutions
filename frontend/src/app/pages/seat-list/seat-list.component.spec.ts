import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeatListComponent } from './seat-list.component';

describe('SeatListComponent', () => {
  let component: SeatListComponent;
  let fixture: ComponentFixture<SeatListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SeatListComponent]
    });
    fixture = TestBed.createComponent(SeatListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
