/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.Revija;
import java.util.ArrayList;
import java.util.List;
import so.opsta.OpstaSO;

/**
 *
 * @author BojLec
 */
public class SOPronadjiRevije extends OpstaSO{
    
    List<OpstiDomenskiObjekat> revije;

    public List<OpstiDomenskiObjekat> getRevije() {
        return revije;
    }

    public void setRevije(List<OpstiDomenskiObjekat> revije) {
        this.revije = revije;
    }
    

    public SOPronadjiRevije() {
        revije = new ArrayList<>();
    }

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        revije = DatabaseBroker.getInstance().vratiSveObjekte((OpstiDomenskiObjekat)o);
    }

    
    
    
}
