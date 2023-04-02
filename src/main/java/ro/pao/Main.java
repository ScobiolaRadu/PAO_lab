package ro.pao;

import ro.pao.Models.Admin;
import ro.pao.Models.Client;
import ro.pao.Models.Drums;
import ro.pao.Models.Guitar;
import ro.pao.Models.Piano;
import ro.pao.Services.GuitarService;
import ro.pao.Services.Impl.GuitarServiceI;

public class Main {
    public static void main(String[] args) {
    Guitar guitar = new Guitar("Ibanez", "Rg370", 2100, 5, "Stratocaster");
    Guitar guitar2 = new Guitar("Epiphone", "G400", 1500, 12, "SG");
    Guitar guitar3 = new Guitar("Fender", "Stratocaster", 3000, 6, "Stratocaster");

    GuitarService guitarService = new GuitarServiceI();

    guitarService.addGuitar(guitar);
    guitarService.addGuitar(guitar2);
    System.out.println(guitarService.getAllGuitars());
    guitarService.updateGuitar(guitar, guitar3);
    System.out.println(guitarService.getAllGuitars());
    guitarService.deleteGuitar(guitar2);
    System.out.println(guitarService.getAllGuitars());

    }
}
