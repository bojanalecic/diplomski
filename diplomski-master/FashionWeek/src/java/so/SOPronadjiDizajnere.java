/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DatabaseBroker;
import domen.Dizajner;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import so.opsta.OpstaSO;

/**
 *
 * @author BojLec
 */
public class SOPronadjiDizajnere extends OpstaSO{
    
    List<OpstiDomenskiObjekat> dizajneri;

    public SOPronadjiDizajnere() {
        dizajneri = new ArrayList<OpstiDomenskiObjekat>();
    }

    public List<OpstiDomenskiObjekat> getDizajneri() {
        return dizajneri;
    }

    public void setDizajneri(List<OpstiDomenskiObjekat> dizajneri) {
        this.dizajneri = dizajneri;
    }

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        dizajneri = DatabaseBroker.getInstance().vratiSveObjekte((OpstiDomenskiObjekat)o);
    }
    
    
    
}
