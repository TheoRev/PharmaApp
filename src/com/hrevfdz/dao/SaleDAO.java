package com.hrevfdz.dao;

import java.util.List;

import com.hrevfdz.models.Sale;
import com.hrevfdz.services.PharmacyService;

public class SaleDAO extends PharmacyService<Sale> {

    @Override
    public boolean Create(Sale t) throws Exception {
        return super.Create(t);
    }

    @Override
    public boolean Update(Sale t) throws Exception {
        return super.Update(t);
    }

    @Override
    public boolean Delete(Sale t) throws Exception {
        return super.Delete(t);
    }

    @Override
    public List<Sale> findAll(String t) throws Exception {
        return super.findAll(t);
    }

    @Override
    public Sale findBy(String q) throws Exception {
        return super.findBy(q);
    }

    @Override
    public List<Sale> findByQuery(String q) throws Exception {
        return super.findByQuery(q);
    }

    @Override
    public List<Sale> findByNativeQuery(String nq) throws Exception {
        return super.findByNativeQuery(nq);
    }

}
