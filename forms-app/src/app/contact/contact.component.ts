import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {

  countries = [
    {
      id: "IN", name: 'India',
      cities: [
        { id: "DE", name: 'Delhi' },
        { id: "MU", name: 'Mumbai' },
        { id: "HY", name: 'Hyderabad' },
        { id: "CH", name: 'Chennai' }]
    },
    {
      id: "US", name: 'U S A', cities: [
        { id: "NY", name: 'Los Angeles' },
        { id: "WA", name: 'Washington' },
        { id: "FL", name: 'Florida' },
        { id: "CH", name: 'Chicago' }]
    },
    {
      id: "UK", name: 'United Kingdom',
      cities: [
        { id: "LO", name: 'London' },
        { id: "MA", name: 'Manchester' },
        { id: "ED", name: 'Edinburgh' },
        { id: "LI", name: 'Liverpool' }]
    }
  ];

  cities = []

  submitForm(data) {
    console.log(data);
    console.table(data);
  }
  getCities(country) {

    for (let c of this.countries) {
      if (country.value == c.id) {
        this.cities = c.cities
      }
    }
  }
}
