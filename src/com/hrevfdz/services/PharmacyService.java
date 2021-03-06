package com.hrevfdz.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class PharmacyService<T> implements IPharmacy<T> {

    private final EntityManager em;

    public PharmacyService() {
        em = PharmacyConexion.getInstance().getFactory().createEntityManager();
    }

    @Override
    public boolean Create(T t) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean Update(T t) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean Delete(T t) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(t));
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<T> findAll(String t) throws Exception {
        List<T> lista = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT t FROM " + t + " t");
            lista = query.getResultList();
            em.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    @Override
    public T findBy(String q) throws Exception {
        T t = null;

        try {
            em.getTransaction().begin();
            Query query = em.createQuery(q);
            t = (T) query.getSingleResult();
            em.close();
        } catch (Exception e) {
            throw e;
        }

        return t;
    }

    @Override
    public List<T> findByQuery(String q) throws Exception {
        List<T> lista = null;

        try {
            em.getTransaction().begin();
            Query query = em.createQuery(q);
            lista = query.getResultList();
            em.close();
        } catch (Exception e) {
            System.out.println("ERROR HIBERNATE: " + e.getMessage());
            throw e;
        }

        return lista;
    }

    @Override
    public List<T> findByNativeQuery(String nq) throws Exception {
        List<T> lista = null;

        try {
            em.getTransaction().begin();
            Query query = em.createNativeQuery(nq);
            lista = query.getResultList();
            em.close();
        } catch (Exception e) {
            System.out.println("ERROR HIBERNATE: " + e.getMessage());
            throw e;
        }

        return lista;
    }

}
