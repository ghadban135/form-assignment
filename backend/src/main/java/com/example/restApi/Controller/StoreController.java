package com.example.restApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApi.Models.Store;
import com.example.restApi.Repository.StoreRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;
    
    @GetMapping(value = "/")
    public String getPage(){
            return "welcome";
    }

    @GetMapping(value = "/stores")
    public List<Store> getStores(){
        return storeRepository.findAll();
    }

    @GetMapping(value = "/store/{id}")
    public Store getStore(@PathVariable long id){
        Store selectedStore = storeRepository.findById(id).get();
        return selectedStore;
    }

    @PostMapping(value = "/store")
    public String saveStore(@RequestBody Store store){
        storeRepository.save(store);
        return "..saved!";
    }

    @PutMapping(value = "update/{id}")
    public String updateStore(@PathVariable long id, @RequestBody Store store){
        Store updatedStore = storeRepository.findById(id).get();
        updatedStore.setName(store.getName());
        updatedStore.setAddress(store.getAddress());
        updatedStore.setPhoneNumber(store.getPhoneNumber());
        storeRepository.save(updatedStore);
        return "updated...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteStore(@PathVariable long id){
        Store deleteStore = storeRepository.findById(id).get();
        storeRepository.delete(deleteStore);
        return "Delete Store with id: " + id;
    }
}
