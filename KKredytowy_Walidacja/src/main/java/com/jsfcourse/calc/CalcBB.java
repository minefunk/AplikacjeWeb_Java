package com.jsfcourse.calc;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named
@RequestScoped
public class CalcBB {
    private Double wysokoscKredytu;  
    private Double oprocentowanie;   
    private Integer lata;             
    private Double result;           

    @Inject
    FacesContext ctx;

    public Double getWysokoscKredytu() {
        return wysokoscKredytu;
    }

    public void setWysokoscKredytu(Double wysokoscKredytu) {
        this.wysokoscKredytu = wysokoscKredytu;
    }

    public Double getOprocentowanie() {
        return oprocentowanie;
    }

    public void setOprocentowanie(Double oprocentowanie) {
        this.oprocentowanie = oprocentowanie;
    }

    public Integer getLata() {
        return lata;
    }

    public void setLata(Integer lata) {
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
            result = (wysokoscKredytu + wysokoscKredytu * (oprocentowanie / 100)) / (lata * 12);

            return true;
        
        } catch (Exception e) {
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
}