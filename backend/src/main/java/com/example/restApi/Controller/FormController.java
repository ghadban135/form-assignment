package com.example.restApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApi.Models.Form;
import com.example.restApi.Repository.FormRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FormController {
    
    @Autowired
    private FormRepository formRepository;

    @GetMapping(value = "/forms")
    public List<Form> getForms(){
        return formRepository.findAll();
    }

    @PostMapping(value = "/form")
    public ResponseEntity<Void> saveForm(@RequestBody Form form){
        form.setTotalPayment(form.getUpfrontFee() + (form.getMonthlyCharge() * form.getInstallmentsOfPayment()));
        formRepository.save(form);
        return ResponseEntity.ok().build();
    }
}
