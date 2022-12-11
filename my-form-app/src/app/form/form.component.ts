import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})

export class FormComponent implements OnInit {

  formFieldsGroup: FormGroup;
  storeOptions: any[]=[];
  today: string = new Date().toISOString().split('T')[0];

  constructor(private http:HttpClient){
    this.formFieldsGroup = new FormGroup({
      storeName: new FormControl('', Validators.required),
      storeAddress: new FormControl(''),
      storePhoneNumber: new FormControl(''),
      date: new FormControl(this.today),
      servedBy: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      btBroadband: new FormControl('', Validators.required),
      btTvPackage: new FormControl('', Validators.required),
      monthlyCharge: new FormControl('', Validators.required),
      upfrontFee: new FormControl('', Validators.required),
      installmentsOfPayment: new FormControl('', Validators.required),
      totalPayment: new FormControl(''),
      otherHandlyInformation: new FormControl('', Validators.required),
      sportPackage: new FormControl('', Validators.required)
    })
  }

  ngOnInit(): void {
    this.http.get<string[]>('http://localhost:8080/stores').subscribe(storeOptions => { 
      this.storeOptions = storeOptions;
    });
  }

  onStoreNameChange(event:any){       
    this.http.get(`http://localhost:8080/store/${event.target.value}`).subscribe((store:any) => {
      this.formFieldsGroup.patchValue({
      storeAddress: store.address,
      storePhoneNumber: store.phoneNumber
      })
    })
  }

  onFormSubmit() {
    this.http.post('http://localhost:8080/form', this.formFieldsGroup.value).subscribe(() => {
    console.error("success");
    },
    error => {
    console.error(error);
    alert('An error occurred while saving the form.');
    });
  }
}