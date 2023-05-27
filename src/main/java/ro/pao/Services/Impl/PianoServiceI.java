package ro.pao.Services.Impl;

import java.util.List;

import ro.pao.Models.Piano;
import ro.pao.Services.PianoService;
import ro.pao.Repositories.PianoRepository;

public class PianoServiceI implements PianoService {

    private PianoRepository pianoRepository;

    public PianoServiceI(PianoRepository pianoRepository) {
        this.pianoRepository = pianoRepository;
    }

    @Override
    public List<Piano> getAllPianos() {
        return pianoRepository.getAllPianos();
    }

    @Override
    public void addPiano(Piano piano) {
        pianoRepository.addPiano(piano);
    }

    @Override
    public void updatePiano(int id, Piano newPiano) {
        Piano existingPiano = pianoRepository.getPianoById(id);
        if (existingPiano != null) {
            newPiano.setId(id); // Set the ID of the new piano object
            pianoRepository.updatePiano(id, newPiano);
        } else {
            System.out.println("Piano not found");
        }
    }

    @Override
    public void deletePiano(int id) {
        Piano existingPiano = pianoRepository.getPianoById(id);
        if (existingPiano != null) {
            pianoRepository.deletePiano(id);
        } else {
            System.out.println("Piano not found");
        }
    }

    @Override
    public Piano getPianoById(int id) {
        return pianoRepository.getPianoById(id);
    }
}
