package ro.pao.Services;

import ro.pao.Models.Drums;

import java.util.List;

public interface DrumsService {
    List<Drums> getAllDrums();

    void addDrums(Drums guitar);

    void updateDrums(int id, Drums newDrums);

    void deleteDrums(int id);

    Drums getDrumsById(int id);
}
