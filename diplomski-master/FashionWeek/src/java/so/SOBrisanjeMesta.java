/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import so.opsta.OpstaSO;

/**
 *
 * @author BojLec
 */
public class SOBrisanjeMesta extends OpstaSO{

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
      DatabaseBroker.getInstance().obrisiProstObjekat((OpstiDomenskiObjekat)o);
    }
    
}
