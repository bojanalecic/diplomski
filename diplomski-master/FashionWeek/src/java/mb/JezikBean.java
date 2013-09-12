/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author BojLec
 */
@ManagedBean(name = "mbJezikBean")
@SessionScoped
public class JezikBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String countryCode;
    private static Map<String, Object> drzave;
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    static {
        drzave = new LinkedHashMap<String, Object>();
        drzave.put("Srpski", Locale.forLanguageTag("sr_RS_Latn"));
        drzave.put("English", Locale.forLanguageTag("en_GB_Latn"));

    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setVountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void selektujJezik(String selektovanJezik) {
        countryCode = selektovanJezik;
        for (Map.Entry<String, Object> entry : drzave.entrySet()) {

            if (entry.getValue().toString().equals(selektovanJezik)) {
                FacesContext.getCurrentInstance()
                        .getViewRoot().setLocale((Locale) entry.getValue());
                if (entry.getKey().equals("Srpski")) {
                    locale = new Locale("sr", "RS", "Latin");
                    break;
                } else {
                    locale = new Locale("en", "GB");
                    break;
                }
            }
        }
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
