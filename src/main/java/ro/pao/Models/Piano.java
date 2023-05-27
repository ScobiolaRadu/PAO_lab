package ro.pao.Models;

import ro.pao.Models.Abstracts.AbstractInstrument;
import ro.pao.Models.Enums.EnumInstruments;

public class Piano extends AbstractInstrument {

    private int id;
    private String key;

    public Piano(int id, String brand, String name, int price, int quantity, String key) {
        super(brand, name, price, quantity);
        this.id = id;
        this.type = EnumInstruments.PIANO;
        this.key = key;
    }

    public Piano(String brand, String name, int price, int quantity, String key) {
        super(brand, name, price, quantity);
        this.type = EnumInstruments.PIANO;
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Piano [id= " + id + ", brand= " + brand + ", name= " + name + ", key= " + key + ", price= " + price
                + ", quantity= "
                + quantity + "]";
    }
}
