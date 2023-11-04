import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewEquipoComponent } from './view-equipo.component';

describe('ViewEquipoComponent', () => {
  let component: ViewEquipoComponent;
  let fixture: ComponentFixture<ViewEquipoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewEquipoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewEquipoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
