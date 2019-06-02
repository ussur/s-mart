package ru.vsu.cs.smart.externalapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.cs.smart.db.model.Filters;
import ru.vsu.cs.smart.externalapi.source.CustomStore;
import ru.vsu.cs.smart.processing.Item;

import java.util.List;

@Service
public class CustomStoreService {
    private final CustomStore customStore;

    @Autowired
    public CustomStoreService(CustomStore customStore) {
        this.customStore = customStore;
    }

    public List<? extends Item> findItems(Filters filters) {
        return customStore.getItems();
    }
}
