package cz.czechitas.webapp;

public class Polozka {


    private Long cislo;
    private String nazev;
    private double cena ;
    private String popis;

    @Override
    public String toString() {
        return "Polozka " +
                "id=" + cislo + ", " +
                "nazev=\"" + nazev + "\"" + ", " +
                "popis=\"" + popis + "\"" + ", " +
                "cena=" + cena;
    }

    public Polozka() {

    }

    public Polozka(Long cislo, String nazev, double cena, String popis) {
        this.nazev = nazev;
        this.cena = cena;
        this.cislo = cislo;
        this.popis = popis;
    }
//
//    public Polozka(String nazev, double cena, String popis) {
//        this.nazev = nazev;
//        this.popis = popis;
//        this.cena = cena;
//    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String newValue) {
        popis = newValue;
    }

    public Long getCislo() {
        return cislo;
    }

    public void setCislo(Long newValue) {
        cislo = newValue;
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
