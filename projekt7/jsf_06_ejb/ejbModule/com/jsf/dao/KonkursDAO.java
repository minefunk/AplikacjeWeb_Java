package com.jsf.dao;

import java.util.List;
import java.util.Map;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.jsf.entities.Konkursy;

// DAO - Data Access Object for Konkurs entity
// Designed to serve as an interface between higher layers of application and data.
// Implemented as a stateless Enterprise Java bean - server-side code that can be invoked even remotely.

@Stateless
public class KonkursDAO {
    private final static String UNIT_NAME = "jsfcourse-simplePU";

    // Dependency injection (no setter method is needed)
    @PersistenceContext(unitName = UNIT_NAME)
    protected EntityManager em;

    // Method to create (add) a new Konkurs
    public void create(Konkursy konkursy) {
        em.persist(konkursy);
    }

    // Method to merge (update) an existing Konkurs
    public Konkursy merge(Konkursy konkursy) {
        return em.merge(konkursy);
    }

    // Method to remove a Konkurs
    public void remove(Konkursy konkursy) {
        em.remove(em.merge(konkursy));
    }

    // Method to find a specific Konkurs by its ID
    public Konkursy find(Object id) {
        return em.find(Konkursy.class, id);
    }

    // Method to retrieve the full list of Konkursy
    public List<Konkursy> getFullList() {
        List<Konkursy> list = null;

        // Corrected entity name
        Query query = em.createQuery("select k from Konkursy k");

        try {
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Method to retrieve a filtered list of Konkursy based on search parameters
    public List<Konkursy> getList(Map<String, Object> searchParams) {
        List<Konkursy> list = null;

        // 1. Build query string with parameters
        String select = "select k ";
        String from = "from Konkursy k "; // Corrected entity name
        String where = "";
        String orderby = "order by k.dataRozpoczecia desc, k.nazwa";

        // Filter by name (nazwa)
        String nazwa = (String) searchParams.get("nazwa");
        if (nazwa != null) {
            if (where.isEmpty()) {
                where = "where ";
            } else {
                where += "and ";
            }
            where += "k.nazwa like :nazwa ";
        }

        // Filter by start date (data_rozpoczecia)
        Object dataRozpoczecia = searchParams.get("dataRozpoczecia");
        if (dataRozpoczecia != null) {
            if (where.isEmpty()) {
                where = "where ";
            } else {
                where += "and ";
            }
            where += "k.dataRozpoczecia >= :dataRozpoczecia ";
        }

        // 2. Create query object
        Query query = em.createQuery(select + from + where + orderby);

        // 3. Set configured parameters
        if (nazwa != null) {
            query.setParameter("nazwa", nazwa + "%");
        }
        if (dataRozpoczecia != null) {
            query.setParameter("dataRozpoczecia", dataRozpoczecia);
        }

        // 4. Execute query and retrieve list of Konkursy objects
        try {
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
