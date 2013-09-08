/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author BojLec
 */
@ViewScoped
public class PrikazRevija {

    public PrikazRevija() {
    }
    
    public ArrayList<String> prikaziSveRevije(){
        ArrayList<String> revije = new ArrayList<String>();
        return revije;
    }
            
}
