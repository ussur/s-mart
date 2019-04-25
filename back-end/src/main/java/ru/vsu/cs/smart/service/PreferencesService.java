package ru.vsu.cs.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.cs.smart.model.Preferences;
import ru.vsu.cs.smart.persistence.PreferencesRepository;

@Service
public class PreferencesService {
    @Autowired
    private PreferencesRepository preferencesRepository;

    public Preferences save(Preferences preferences) {
        return preferencesRepository.save(preferences);
    }

    public void delete(Preferences preferences) {
        preferencesRepository.delete(preferences);
    }
}
