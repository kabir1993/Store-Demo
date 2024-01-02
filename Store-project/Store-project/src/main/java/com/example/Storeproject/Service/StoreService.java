package com.example.Storeproject.Service;


import com.example.Storeproject.Entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public interface StoreService {
    List<Store> getAllStores();
    Optional<Store> getStoreById(String id);
    Store createOrUpdateStore(Store store);
    void deleteStore(String id);
    List<Store> filterStores(String name, String category);

    Page<Store> getAllStores(Pageable pageable);
}
