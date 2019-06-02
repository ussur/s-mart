package ru.vsu.cs.smart.externalapi.api;

import ru.vsu.cs.smart.db.model.Filters;
import ru.vsu.cs.smart.processing.Item;

import java.util.List;

public interface IStoreResource {
    List<? extends Item> findItems(Filters filters);
}
