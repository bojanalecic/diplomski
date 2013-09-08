/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DatabaseBroker;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import so.opsta.OpstaSO;

/**
 *
 * @author Lecic
 */
public class SOPronadjiKorisnika extends OpstaSO{
    OpstiDomenskiObjekat korisnik;

    public OpstiDomenskiObjekat getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(OpstiDomenskiObjekat korisnik) {
        this.korisnik = korisnik;
    }

   public SOPronadjiKorisnika() {
    }
    

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        try{
        OpstiDomenskiObjekat rezultat =  DatabaseBroker.getInstance().vratiPoKriterijumu((Korisnik) o, (Korisnik)o);
        korisnik = (Korisnik) rezultat;
        }catch(Exception ex){
        
        }
            
    }
    
}
