package src.main.java.ro.pao;

import src.main.java.ro.pao.Models.Admin;
import src.main.java.ro.pao.Models.Client;
import src.main.java.ro.pao.Models.Drums;
import src.main.java.ro.pao.Models.Guitar;
import src.main.java.ro.pao.Models.Piano;
import src.main.java.ro.pao.Services.GuitarService;
import src.main.java.ro.pao.Services.Impl.GuitarServiceI;

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
