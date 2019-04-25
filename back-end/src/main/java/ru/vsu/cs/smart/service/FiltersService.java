package ru.vsu.cs.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.cs.smart.model.Filters;
import ru.vsu.cs.smart.persistence.FiltersRepository;

@Service
public class FiltersService {
    @Autowired
    private FiltersRepository filtersRepository;

    public Filters save(Filters filters) {
        return filtersRepository.save(filters);
    }

    public void delete(Filters filters) {
        filtersRepository.delete(filters);
    }
}
