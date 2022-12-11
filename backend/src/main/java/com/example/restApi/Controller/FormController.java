package com.example.restApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping(value = "updateform/{id}")
    public String updateForm(@PathVariable long id, @RequestBody Form form){
        Form updatedForm = formRepository.findById(id).get();
        updatedForm.setStoreName(form.getStoreName());
        updatedForm.setEmail(form.getEmail());
        updatedForm.setBtBroadband(form.getBtBroadband());
        updatedForm.setBtTvPackage(form.getBtTvPackage());
        updatedForm.setDate(form.getDate());
        updatedForm.setOtherHandlyInformation(form.getOtherHandlyInformation());
        updatedForm.setServedBy(form.getServedBy());
        updatedForm.setSportPackage(form.getSportPackage());
        updatedForm.setTotalPayment(form.getTotalPayment());
        formRepository.save(updatedForm);
        return "form updated...";
    }

    @DeleteMapping(value = "/deleteform/{id}")
    public String deleteStore(@PathVariable long id){
        Form deleteForm = formRepository.findById(id).get();
        formRepository.delete(deleteForm);
        return "Delete Form with id: " + id;
    }
}
