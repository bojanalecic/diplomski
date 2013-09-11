/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import so.opsta.OpstaSO;

/**
 *
 * @author BojLec
 */
public class SOPronadjiSponzore extends OpstaSO{
    
    List<OpstiDomenskiObjekat> sponzori;

    public SOPronadjiSponzore() {
        sponzori = new ArrayList<>();
    }

    public List<OpstiDomenskiObjekat> getSponzori() {
        return sponzori;
    }

    public void setSponzori(List<OpstiDomenskiObjekat> sponzori) {
        this.sponzori = sponzori;
    }

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        sponzori = DatabaseBroker.getInstance().vratiSveObjekte((OpstiDomenskiObjekat)o);
    }
    
    
    
}
