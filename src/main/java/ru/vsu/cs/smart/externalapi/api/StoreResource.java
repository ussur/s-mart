package ru.vsu.cs.smart.externalapi.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.smart.db.model.Filters;
import ru.vsu.cs.smart.processing.Item;
import ru.vsu.cs.smart.processing.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

@Api(
        value = "/stores",
        produces = "application/json",
        consumes = "application/json",
        description = "Поиск товаров"
)
@RestController
@RequestMapping("/stores")
public class StoreResource implements IStoreResource {
    private final ItemAdapter itemConverter;
    private final CustomStoreResource customStoreResource;

    @Autowired
    public StoreResource(ItemAdapter itemConverter, CustomStoreResource customStoreResource) {
        this.itemConverter = itemConverter;
        this.customStoreResource = customStoreResource;
    }

    @Override
    @PostMapping("/search")
    @ApiOperation(
            value = "Возвращает список найденных товаров",
            httpMethod = "POST",
            notes = "Возможные значения поля category: clothing, books.",
            response = Item.class,
            responseContainer = "List"
    )
    public List<Item> findItems(@ApiParam(value = "Фильтры, применяемые при поиске товара", required = true)
                                    @RequestBody Filters filters) {
        List<List<Item>> items = new ArrayList<>();
        items.add(itemConverter.convert(
                customStoreResource.findItems(filters))
        );
        return itemConverter.compose(items);
    }
}
