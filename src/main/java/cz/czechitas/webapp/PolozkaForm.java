package cz.czechitas.webapp;

public class PolozkaForm {


    private String nazev;
    private double cena;
    private String popis;

    public String getPopis() {
        return popis;
    }

    public void setPopis(String newValue) {
        popis = newValue;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String newValue) {
        nazev = newValue;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double newValue) {
        cena = newValue;
    }
}
