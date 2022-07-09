package cz.czechitas.webapp;

import java.nio.file.*;
import javax.jws.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {

    private InMemoryPolozkaRepository inMemoryPolozkaRepository;

    public HlavniController(InMemoryPolozkaRepository inMemoryPolozkaRepository) {
        this.inMemoryPolozkaRepository = inMemoryPolozkaRepository;
    }

    //zobraz index-eshop
    @RequestMapping("/")
    public ModelAndView zobrazIndex() {
        return new ModelAndView("redirect:/eshop/");
    }

    @RequestMapping(value = "/eshop", method = RequestMethod.GET)
    public ModelAndView zobrazEshop() {
        ModelAndView dataHolder = new ModelAndView("eshop");
        dataHolder.addObject("polozky", inMemoryPolozkaRepository.getPolozka());
        return dataHolder;
    }

    //zobraz detail

    @RequestMapping(value = "/detail/{cislo}", method = RequestMethod.GET)
    public ModelAndView zobrazDetail(@PathVariable("cislo") Long cislo) {
        ModelAndView dataHolder = new ModelAndView("detail");
        dataHolder.addObject("polozky", inMemoryPolozkaRepository.ziskejPolozkuPodleCisla(cislo));
        return dataHolder;
    }

    //pridani do kosiku

    @RequestMapping(value = "/detail/{cislo}", method = RequestMethod.POST)
    public ModelAndView pridejDoKosiku(@PathVariable("cislo") Long cislo) {
        inMemoryPolozkaRepository.pridejPolozkuDoKosiku(cislo);
        return new ModelAndView ("redirect:/kosik");
    }

    //zobraz kosik
    @RequestMapping(value = "/kosik", method = RequestMethod.GET)
    public ModelAndView zobrazKosik() {
        ModelAndView dataholder = new ModelAndView("kosik");
        dataholder.addObject("kosik", inMemoryPolozkaRepository.getSeznamVKosiku());
        dataholder.addObject("soucet", inMemoryPolozkaRepository.sectiKosik());
        return dataholder;
    }

    //smaz polozku v kosiku
    @RequestMapping(value = "/kosik/{cislo}", method = RequestMethod.POST,
                    params = "akce=DELETE")
    public ModelAndView smazPolozku(@PathVariable("cislo") Long cislo) {
        inMemoryPolozkaRepository.odeberPolozkuZKosiku(cislo);
        return new ModelAndView ("redirect:/eshop");

    }
}
