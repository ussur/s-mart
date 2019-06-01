package ru.vsu.cs.smart.gateway.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.smart.db.model.Filters;
import ru.vsu.cs.smart.logic.Item;
import ru.vsu.cs.smart.logic.ItemConverter;

import java.util.ArrayList;
import java.util.List;

@RestController("/stores")
public class StoreResource implements IStoreResource {
    private final ItemConverter itemConverter;
    private final EbayResource ebayResource;

    @Autowired
    public StoreResource(ItemConverter itemConverter, EbayResource ebayResource) {
        this.itemConverter = itemConverter;
        this.ebayResource = ebayResource;
    }

    @Override
    @GetMapping("/search")
    public List<Item> findItems(@RequestBody Filters filters) {
        List<List<Item>> items = new ArrayList<>();
        items.add(ebayResource.findItems(filters));
        return itemConverter.compose(items);
    }
}
