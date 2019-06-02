package ru.vsu.cs.smart.externalapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.smart.db.model.Filters;
import ru.vsu.cs.smart.processing.Item;
import ru.vsu.cs.smart.processing.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StoreResource implements IStoreResource {
    private final ItemAdapter itemConverter;
    private final CustomStoreResource customStoreResource;

    @Autowired
    public StoreResource(ItemAdapter itemConverter, CustomStoreResource customStoreResource) {
        this.itemConverter = itemConverter;
        this.customStoreResource = customStoreResource;
    }

    @Override
    @PostMapping("/stores/search")
    public List<Item> findItems(@RequestBody Filters filters) {
        List<List<Item>> items = new ArrayList<>();
        items.add(itemConverter.convert(
                customStoreResource.findItems(filters))
        );
        return itemConverter.compose(items);
    }
}
