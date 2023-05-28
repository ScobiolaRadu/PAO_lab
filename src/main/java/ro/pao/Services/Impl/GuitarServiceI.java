package ro.pao.Services.Impl;

import java.util.List;

import ro.pao.Models.Guitar;
import ro.pao.Services.GuitarService;
import ro.pao.Repositories.GuitarRepository;

public class GuitarServiceI implements GuitarService {

    private GuitarRepository guitarRepository;

    public GuitarServiceI(GuitarRepository guitarRepository) {
        this.guitarRepository = guitarRepository;
    }

    @Override
    public List<Guitar> getAllGuitars() {
        return guitarRepository.getAllGuitars();
    }

    @Override
    public void addGuitar(Guitar guitar) {
        guitarRepository.addGuitar(guitar);
    }

    @Override
    public void updateGuitar(int id, Guitar newGuitar) {
        Guitar existingGuitar = guitarRepository.getGuitarById(id);
        if (existingGuitar != null) {
            newGuitar.setId(id); // Set the ID of the new guitar object
            guitarRepository.updateGuitar(id, newGuitar);
        } else {
            System.out.println("Guitar not found");
        }
    }

    @Override
    public void deleteGuitar(int id) {
        Guitar existingGuitar = guitarRepository.getGuitarById(id);
        if (existingGuitar != null) {
            guitarRepository.deleteGuitar(id);
        } else {
            System.out.println("Guitar not found");
        }
    }

    @Override
    public Guitar getGuitarById(int id) {
        return guitarRepository.getGuitarById(id);
    }
}
