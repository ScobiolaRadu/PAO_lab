package ro.pao.Models;

import ro.pao.Models.Abstracts.AbstractInstrument;
import ro.pao.Models.Enums.EnumInstruments;

public class Piano extends AbstractInstrument{

    private String key;

    public Piano(String brand, String name, int price, int quantity, String key) {
        super(brand, name, price, quantity);
        this.type = EnumInstruments.PIANO;
        this.key = key;
    }
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Piano [brand= " + brand + ", name= " + name + ", key= " + key + ", price= " + price + ", quantity= "
                + quantity +"]";
    }
}
