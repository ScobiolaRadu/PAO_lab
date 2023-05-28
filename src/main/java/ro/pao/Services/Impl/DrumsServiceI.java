package ro.pao.Services.Impl;

import java.util.List;

import ro.pao.Models.Drums;
import ro.pao.Services.DrumsService;
import ro.pao.Repositories.DrumsRepository;

public class DrumsServiceI implements DrumsService {

    private DrumsRepository guitarRepository;

    public DrumsServiceI(DrumsRepository guitarRepository) {
        this.guitarRepository = guitarRepository;
    }

    @Override
    public List<Drums> getAllDrums() {
        return guitarRepository.getAllDrums();
    }

    @Override
    public void addDrums(Drums guitar) {
        guitarRepository.addDrums(guitar);
    }

    @Override
    public void updateDrums(int id, Drums newDrums) {
        Drums existingDrums = guitarRepository.getDrumsById(id);
        if (existingDrums != null) {
            newDrums.setId(id); // Set the ID of the new guitar object
            guitarRepository.updateDrums(id, newDrums);
        } else {
            System.out.println("Drums not found");
        }
    }

    @Override
    public void deleteDrums(int id) {
        Drums existingDrums = guitarRepository.getDrumsById(id);
        if (existingDrums != null) {
            guitarRepository.deleteDrums(id);
        } else {
            System.out.println("Drums not found");
        }
    }

    @Override
    public Drums getDrumsById(int id) {
        return guitarRepository.getDrumsById(id);
    }
}
