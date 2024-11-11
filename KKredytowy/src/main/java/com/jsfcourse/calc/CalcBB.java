package com.jsfcourse.calc;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named
@RequestScoped
public class CalcBB {
    private String wysokoscKredytu;  
    private String oprocentowanie;   
    private String lata;             
    private Double result;           

    @Inject
    FacesContext ctx;

    public String getWysokoscKredytu() {
        return wysokoscKredytu;
    }

    public void setWysokoscKredytu(String wysokoscKredytu) {
        this.wysokoscKredytu = wysokoscKredytu;
    }

    public String getOprocentowanie() {
        return oprocentowanie;
    }

    public void setOprocentowanie(String oprocentowanie) {
        this.oprocentowanie = oprocentowanie;
    }

    public String getLata() {
        return lata;
    }

    public void setLata(String lata) {
        this.lata = lata;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public boolean doTheMath() {
        try {           
            double kwota = Double.parseDouble(this.wysokoscKredytu);
            double procent = Double.parseDouble(this.oprocentowanie);
            int lataSpłaty = Integer.parseInt(this.lata);

            result = (kwota + kwota * (procent / 100)) / (lataSpłaty * 12);

            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
            return true;
        
        } catch (Exception e) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wprowadź wszystkie poprawne dane", null));
            return false;
        }
    }

    public String calc() {
        if (doTheMath()) {
            return "showresult";  
        }
        return null;
    }

    public String calc_AJAX() {
        if (doTheMath()) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Miesięczna rata: " + result, null));
        }
        return null;
    }

    public String info() {
        return "info";
    }
}