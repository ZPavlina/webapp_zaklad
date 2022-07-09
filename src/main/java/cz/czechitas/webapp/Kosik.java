package cz.czechitas.webapp;

public class Kosik {

    private String nazev;
    private double cena;
    private Long cislo;
    private String popis;
    private double soucet;

    public double getSoucet() {
        return soucet;
    }

    public void setSoucet(double newValue) {
        soucet = newValue;
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

    public Long getCislo() {
        return cislo;
    }

    public void setCislo(Long newValue) {
        cislo = newValue;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String newValue) {
        popis = newValue;
    }
}
