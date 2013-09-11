/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DatabaseBroker;
import domen.Mestoodrzavanja;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import so.opsta.OpstaSO;

/**
 *
 * @author BojLec
 */
public class SOPronadjiMesta extends OpstaSO{
    List<OpstiDomenskiObjekat> mesta;

    public List<OpstiDomenskiObjekat> getMesta() {
        return mesta;
    }

    public void setMesta(ArrayList<OpstiDomenskiObjekat> mesta) {
        this.mesta = mesta;
    }
    
    
    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        mesta = new ArrayList<>();
        }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        mesta = DatabaseBroker.getInstance().vratiSveObjekte((OpstiDomenskiObjekat)o);
    }
    
}
