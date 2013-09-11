/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.opsta;

import db.DatabaseBroker;

/**
 *
 * @author Lecic
 */
public abstract class OpstaSO {
    
    public final void izvrsiOperaciju(Object o) throws Exception {
        try {
             DatabaseBroker.getInstance().zapocniTransakciju();           
             izvrsiKonkretnuOperaciju(o);
             DatabaseBroker.getInstance().commit();
        } catch (Exception e) {
            DatabaseBroker.getInstance().rollback();
            throw e;
        } finally {
            DatabaseBroker.getInstance().zatvoriEntityManager();
        }
    }

    protected abstract void proveriPreduslov(Object o) throws Exception;

    protected abstract void izvrsiKonkretnuOperaciju(Object o) throws Exception;
    
}
