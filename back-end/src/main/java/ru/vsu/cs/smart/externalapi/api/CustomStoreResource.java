package ru.vsu.cs.smart.externalapi.api;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.smart.db.model.Filters;
import ru.vsu.cs.smart.externalapi.service.CustomStoreService;
import ru.vsu.cs.smart.processing.Item;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.stream.Collectors;

@ApiIgnore
@RestController
public class CustomStoreResource implements IStoreResource {
    private final CustomStoreService customStoreService;

    @Autowired
    public CustomStoreResource(CustomStoreService customStoreService) {
        this.customStoreService = customStoreService;
    }


    @Override
    @PostMapping("/customStore")
    public List<? extends Item> findItems(@RequestBody Filters filters) {
        Preconditions.checkNotNull(filters);
        Preconditions.checkNotNull(filters.getCategory());
        final String hint = filters.getHint();
        return customStoreService.findItems(filters).stream().filter(
            item -> item.getCategory().isEqualTo(filters.getCategory())
                && (hint == null || item.getProductName().toLowerCase().contains(hint.toLowerCase()))
                && (filters.getMaxPrice()== null || filters.getMaxPrice() >= item.getPrice())
                && (filters.getMinPrice()== null || filters.getMinPrice() <= item.getPrice())
                && (filters.getRating() == null || filters.getRating() <= item.getRating())
        ).collect(Collectors.toList());
    }
}
