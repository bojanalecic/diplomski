package domen;



import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Bojana
 */
public interface OpstiDomenskiObjekat {
    
   public String vratiNazivKlase();
    
    public String vratiSveAtribute();
    
    public String vratiUpdateAtribute();
    
    public ArrayList<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) throws Exception;
    
    public OpstiDomenskiObjekat vratiJedanObjekat(long sifra, ResultSet rs) throws Exception;
    
    public String vratiKljuc();

    public String vratiVrednostKljuca();
    
    public String sqlUpitVratiJedan();
    
    public String sqlUpitVratiSve();
    
    public String sqlUpitVratiSveSlozene();
    
    public String sqlUpitVratiJedanSlozeni();
    
    public String vratiSpoljniKljuc();

    public String vratiVrednostSpoljnogKljuca();

    
}
