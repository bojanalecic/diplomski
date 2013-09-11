/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Dizajner;
import domen.Korisnik;
import domen.Mestoodrzavanja;
import domen.OpstiDomenskiObjekat;
import domen.Revija;
import domen.Sponzor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.SOBrisanjeMesta;
import so.SOPronadjiDizajnere;
import so.SOPronadjiKorisnika;
import so.SOPronadjiMesta;
import so.SOPronadjiRevije;
import so.SOPronadjiSponzore;

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
        try{
            SOPronadjiRevije so = new SOPronadjiRevije();
            so.izvrsiOperaciju(new Revija());
            ArrayList<Revija> lista = new ArrayList<>();
            for (OpstiDomenskiObjekat odo : so.getRevije()) {
                lista.add((Revija)odo);
            }
            return lista;
        }catch(Exception ex){
          return null;   
        }
    }

    public ArrayList<Dizajner> vratiSveDizajnere() {
         try{
             SOPronadjiDizajnere so = new SOPronadjiDizajnere();
            so.izvrsiOperaciju(new Dizajner());
            ArrayList<Dizajner> lista = new ArrayList<>();
            for (OpstiDomenskiObjekat odo : so.getDizajneri()) {
                lista.add((Dizajner)odo);
            }
            return lista;
        }catch(Exception ex){
          return null;   
        }
    }

    public ArrayList<Sponzor> vratiSveSponzore() {
        try{
             SOPronadjiSponzore so = new SOPronadjiSponzore();
            so.izvrsiOperaciju(new Sponzor());
            ArrayList<Sponzor> lista = new ArrayList<>();
            for (OpstiDomenskiObjekat odo : so.getSponzori()) {
                lista.add((Sponzor)odo);
            }
            return lista;
        }catch(Exception ex){
          return null;   
        }
    }

    public ArrayList<Mestoodrzavanja> vratiSvaMesta() {
    try{
             SOPronadjiMesta so = new SOPronadjiMesta();
            so.izvrsiOperaciju(new Mestoodrzavanja());
            ArrayList<Mestoodrzavanja> lista = new ArrayList<>();
            for (OpstiDomenskiObjekat odo : so.getMesta()) {
                lista.add((Mestoodrzavanja)odo);
            }
            return lista;
        }catch(Exception ex){
          return null;   
        }   
    }

    public void obrisiMesto(Mestoodrzavanja selektovanoMesto) {
        try {
            SOBrisanjeMesta so = new SOBrisanjeMesta();
            so.izvrsiOperaciju(selektovanoMesto);
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
