/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Bojana
 */
public class DatabaseBroker {
    
    private static DatabaseBroker instance;
    private EntityManagerFactory emf;
    private EntityManager em;

    public static DatabaseBroker getInstance() {
        if (instance == null) {
            instance = new DatabaseBroker();
        }
        return instance;
    }

    private DatabaseBroker() {
        emf = Persistence.createEntityManagerFactory("fashionweek");
    }

    public void zapocniTransakciju() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public void zatvoriEntityManager() {
        em.close();
    }

    public void commit() throws Exception {
        try {
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Greska prilikom commit-a transakcije!");
        }
    }

    public void rollback() throws Exception {
        try {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            throw new Exception("Nastala je greska prilikom rollbacka!");
        }
    }
    
   public OpstiDomenskiObjekat vratiPoKriterijumu(OpstiDomenskiObjekat odo, OpstiDomenskiObjekat kriterijum) throws SQLException, Exception {
       try{
       String upit = "SELECT " + odo.vratiNazivKlase().substring(odo.vratiNazivKlase().indexOf(" ") + 1) + " FROM " + odo.vratiNazivKlase()+ "  WHERE ";
       String[] kljucevi = odo.vratiKljuc().split(",");
       String[] vrednostiKljuceva =odo.vratiVrednostKljuca().split(",");
       
       for (int i = 0; i < kljucevi.length; i++) {
            if (i == kljucevi.length - 1) {
                upit += kljucevi[i] + " = :uslov" + i;
            } else {
                upit += kljucevi[i] + " = :uslov" + i + " AND ";
            }
        }
        Query q = em.createQuery(upit);
        for (int i = 0; i < vrednostiKljuceva.length; i++) {
            q.setParameter("uslov" + i, vrednostiKljuceva[i]);
        }
        
       if(q.getResultList().size()>0){
        OpstiDomenskiObjekat rezultat = (OpstiDomenskiObjekat) q.getSingleResult();
        return rezultat;
       }return null;
       }catch(Exception ex){
           return null;
       }
    }
   public List<OpstiDomenskiObjekat> vratiSveObjekte(OpstiDomenskiObjekat odo) throws Exception {
       try{
       Query q =em.createNamedQuery(odo.vratiNazivKlase() + ".findAll");
       List<Object> rs = q.getResultList();
       List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        for (Object opstiDomenskiObjekat : rs) {
           lista.add((OpstiDomenskiObjekat)opstiDomenskiObjekat);
           return lista;
       }
       }catch(Exception ex){
           System.out.println(ex.getStackTrace());
           return null;
       }
        return null;
    }
   
    public void obrisiProstObjekat(OpstiDomenskiObjekat odo) throws Exception {
        Query q = em.createQuery("DELETE FROM " + odo.vratiNazivKlase() + " WHERE " + odo.vratiKljuc() + " = :id");
        q.setParameter("id", odo.vratiVrednostKljuca()).executeUpdate();
    }
    
    
//    public void sacuvaj(OpstiDomenskiObjekat  odo) throws Exception{
//       String upit ="INSERT INTO "+odo.vratiNazivKlase()+" VALUES ("+odo.vratiSveAtribute()+")";
//            System.out.println(upit);
//            Statement st = connection.createStatement();
//            st.executeUpdate(upit);
//            st.close();
//    }
//    
//    public void izmeni(OpstiDomenskiObjekat odo) throws Exception{
//        String upit ="UPDATE "+odo.vratiNazivKlase()+" SET "+odo.vratiUpdateAtribute()+" WHERE "+odo.vratiKljuc()+"="+odo.vratiVrednostKljuca();   
//            System.out.println(upit);
//            Statement st = connection.createStatement();
//            st.executeUpdate(upit);
//            st.close();
//    }
//    
//    public ArrayList<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws Exception{
//        String upit = odo.sqlUpitVratiSve();
//        Statement st = connection.createStatement();
//        ResultSet rs = st.executeQuery(upit);
//        return odo.vratiListuObjekata(rs);
//    }
//    
//    public ArrayList<OpstiDomenskiObjekat> vratiSveSlozene(OpstiDomenskiObjekat odo) throws SQLException, Exception{
//        String upit = odo.sqlUpitVratiSveSlozene();
//        System.out.println(upit);
//        Statement st = connection.createStatement();
//        ResultSet rs = st.executeQuery(upit);
//        return odo.vratiListuObjekata(rs);
//    }
//
//    public ArrayList<OpstiDomenskiObjekat> vratiPoKriterijumu(OpstiDomenskiObjekat odo, OpstiDomenskiObjekat kriterijum) throws SQLException, Exception {
//        String upit = odo.sqlUpitVratiSveSlozene()+" WHERE "+odo.vratiSpoljniKljuc()+" = "+kriterijum.vratiVrednostKljuca();
//        System.out.println(upit);
//        Statement st = connection.createStatement();
//        ResultSet rs = st.executeQuery(upit);
//        return odo.vratiListuObjekata(rs);
//    }
//
//    public void obrisi(OpstiDomenskiObjekat odo) throws SQLException, Exception {
//        String upit = "DELETE FROM "+odo.vratiNazivKlase()+" WHERE "+odo.vratiKljuc()+" = "+odo.vratiVrednostKljuca();
//        System.out.println(upit);
//        Statement statement = connection.createStatement();
//            statement.executeUpdate(upit);
//            statement.close();
//    }
//


      
}
