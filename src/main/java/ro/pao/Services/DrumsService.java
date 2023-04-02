package ro.pao.Services;

import java.util.List;

import ro.pao.Models.Drums;

public interface DrumsService {
    
    public List<Drums> getAllDrums();

    public void addDrums(Drums drums);

    public void updateDrums(Drums drums, Drums drums2);

    public void deleteDrums(Drums drums);
}
