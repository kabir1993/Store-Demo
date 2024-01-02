package com.example.Storeproject.Controller;

import com.example.Storeproject.Entity.Store;
import com.example.Storeproject.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> getAllStores(){
        return storeService.getAllStores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable String id){
        Optional<Store> store = storeService.getStoreById(id);

        return store.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Store> createOrUpdateStore(@RequestBody Store store){

        Store savedStore = storeService.createOrUpdateStore(store);
        return new ResponseEntity<>(savedStore, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable String id){

        storeService.deleteStore(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/filter")
    public List<Store> fileStores(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) String category){

        return storeService.filterStores(name, category);
    }
}
