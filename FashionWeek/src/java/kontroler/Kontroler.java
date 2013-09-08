/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Dizajner;
import domen.Korisnik;
import domen.Revija;
import java.util.ArrayList;
import so.SOPronadjiKorisnika;

/**
 *
 * @author Lecic
 */
public class Kontroler {
    private static Kontroler instance;

    private Kontroler() {
    }

    public static Kontroler vratiObjekat() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Korisnik pronadjiKorisnika(Korisnik korisnik) throws Exception {
        try {
            SOPronadjiKorisnika so = new SOPronadjiKorisnika();
            so.izvrsiOperaciju(korisnik);
            Korisnik kor = (Korisnik) so.getKorisnik();
            return kor;

        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Revija> vratiSveRevije() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Dizajner> vratiSveDizajnere() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
