package ru.vsu.cs.smart.gateway.api;

import ru.vsu.cs.smart.db.model.Filters;
import ru.vsu.cs.smart.logic.Item;

import java.util.List;

public interface IStoreResource {
    public List<Item> findItems(Filters filters);
}
