package ro.pao.Services;

import ro.pao.Models.Guitar;

import java.util.List;

public interface GuitarService {
    List<Guitar> getAllGuitars();

    void addGuitar(Guitar guitar);

    void updateGuitar(int id, Guitar newGuitar);

    void deleteGuitar(int id);

    Guitar getGuitarById(int id);
}
