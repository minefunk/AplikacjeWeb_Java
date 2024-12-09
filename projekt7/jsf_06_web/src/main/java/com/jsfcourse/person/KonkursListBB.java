package com.jsfcourse.person;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ejb.EJB;

import com.jsf.dao.KonkursDAO;
import com.jsf.entities.Konkursy;

@Named
@RequestScoped
public class KonkursListBB {

    private String nazwa;

    @EJB
    private KonkursDAO konkursDAO;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<Konkursy> getList() {
        List<Konkursy> list = null;

        // Przygotowanie parametrów wyszukiwania
        Map<String, Object> searchParams = new HashMap<>();

        if (nazwa != null && !nazwa.isEmpty()) {
            searchParams.put("nazwa", nazwa);
        }

        // Pobranie listy konkursów
        list = konkursDAO.getList(searchParams);

        return list;
    }
}
