package ro.pao.Models.Abstracts;

import ro.pao.Models.Enums.EnumInstruments;

public class AbstractInstrument {

    protected String brand;
    protected String name;
    protected EnumInstruments type;
    protected int price;
    protected int quantity;

    public AbstractInstrument(String brand, String name, int price, int quantity) {
        
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = EnumInstruments.UNDEFINED;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumInstruments getType() {
        return type;
    }

    public void setType(EnumInstruments type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
