package ro.pao.Repositories;

import ro.pao.Models.Drums;

import java.util.List;

public interface DrumsRepository {
    List<Drums> getAllDrums();

    void addDrums(Drums drums);

    void updateDrums(int id, Drums drums);

    void deleteDrums(int id);

    Drums getDrumsById(int id);
}
