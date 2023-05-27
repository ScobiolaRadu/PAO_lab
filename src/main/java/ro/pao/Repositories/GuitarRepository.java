package ro.pao.Repositories;

import ro.pao.Models.Guitar;

import java.util.List;

public interface GuitarRepository {
    List<Guitar> getAllGuitars();
    void addGuitar(Guitar guitar);
    void updateGuitar(int id, Guitar guitar);
    void deleteGuitar(int id);
    Guitar getGuitarById(int id);
}
