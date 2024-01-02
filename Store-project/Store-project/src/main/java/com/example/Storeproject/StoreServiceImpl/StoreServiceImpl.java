package com.example.Storeproject.StoreServiceImpl;

import com.example.Storeproject.Entity.Store;
import com.example.Storeproject.Repository.StoreRepository;
import com.example.Storeproject.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;
    
    @Override
    public Optional<Store> getStoreById(String id) {
        return storeRepository.findById(id);
    }

    @Override
    public Store createOrUpdateStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public void deleteStore(String id) {
        storeRepository.deleteById(id);
    }

    @Override
    public List<Store> filterStores(String name, String category) {
        // Implement filtering logic based on name and category
        // You can use storeRepository.findBy<FieldName>ContainingIgnoreCase() methods
        return storeRepository.findAll();
    }

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Page<Store> getAllStores(Pageable pageable) {
        return storeRepository.findAll(pageable);
    }

}
