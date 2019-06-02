package ru.vsu.cs.smart.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.cs.smart.db.model.Filters;
import ru.vsu.cs.smart.db.repository.FiltersRepository;

import java.util.List;

@Service
public class FiltersService {
    @Autowired
    private FiltersRepository filtersRepository;

    public List<Filters> findAllByCurrentUser(Long userId) {
        return filtersRepository.findAllByCurrentUser(userId);
    }

    public Filters save(Filters filters) {
        return filtersRepository.save(filters);
    }

    public void delete(Long id) {
        filtersRepository.deleteById(id);
    }

    public void delete(Filters filters) {
        filtersRepository.delete(filters);
    }
}
