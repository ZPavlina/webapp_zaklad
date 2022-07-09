package cz.czechitas.webapp;

import java.security.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import com.sun.org.apache.bcel.internal.generic.*;

@Repository
public class InMemoryPolozkaRepository {

    private Long sekvence = 1000L;


    private List<Polozka> seznamPolozek = new ArrayList<>(Arrays.asList(
            new Polozka(sekvence++, "Rohlík", 2.99, "tukový rohlík, váha 42 g") ,
            new Polozka(sekvence++, "Šunka", 29.90, "dušená šunka od kosti") ,
            new Polozka(sekvence++, "Pomeranč", 22.90, "země původu Španělsko") ,
            new Polozka(sekvence++, "Brambory", 55.90, "farma Dobřany, 5kg"),
            new Polozka(sekvence++, "Mléko", 22.90, "farma Dobřany, 1 litr"),
            new Polozka(sekvence++,"Jogurt", 16.90, "farma Dobřany, 140g"),
            new Polozka(sekvence++, "Vejce slepičí", 62.90, "farma Dobřany, 10ks ")
    ));

    private List<Polozka> seznamVKosiku = new ArrayList<>(Arrays.asList());

    public List<Polozka> getSeznamVKosiku() {
        return seznamVKosiku;
    }

    public void setSeznamVKosiku(List<Polozka> newValue) {
        seznamVKosiku = newValue;
    }

    public List<Polozka> getPolozka() {
        return seznamPolozek;
    }


    public void setPolozka(List<Polozka> newValue) {
        seznamPolozek = newValue;
    }

    public int najdiCisloPolozky (Long cislo) {
        for (int i = 0; i < seznamPolozek.size(); i++) {
            Polozka polozka = seznamPolozek.get(i);
            if (polozka.getCislo().equals(cislo)) {

                return i;
            }
        }
        return  -1;
    }


    public Polozka ziskejPolozkuPodleCisla (Long cislo) {
        int index = ziskejIdPodleCisla(cislo);
        return seznamPolozek.get(index);
}

    public int ziskejIdPodleCisla(Long cislo) {
            for (int i = 0; i < seznamPolozek.size(); i++) {
                if (seznamPolozek.get(i).getCislo().equals(cislo)) {
                    return i;
                }
            }
            return -1 ;
        }


    public void pridejPolozkuDoKosiku(Long cislo) {
        for (Polozka polozka : seznamPolozek) {
            if (polozka.getCislo().equals(cislo)) {
                seznamVKosiku.add(polozka);
            }
        }

    }

    public double sectiKosik () {
        Kosik kosik = new Kosik();
        double vysledek = kosik.getSoucet();
        for (int i = 0; i < seznamVKosiku.size(); i++) {
            Polozka polozka = seznamVKosiku.get(i);
            vysledek += polozka.getCena();
            vysledek = Math.round(vysledek*100)/100.0;
        }
        return vysledek;
    }

    public void odeberPolozkuZKosiku(Long cislo) {
        int index = ziskejIdPodleCisla(cislo);
        seznamVKosiku.remove(index);
        
    }
}
