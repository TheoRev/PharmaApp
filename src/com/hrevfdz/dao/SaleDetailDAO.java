package com.hrevfdz.dao;

import java.util.List;

import com.hrevfdz.models.SaleDetail;
import com.hrevfdz.services.PharmacyService;

public class SaleDetailDAO extends PharmacyService<SaleDetail> {

    @Override
    public boolean Create(SaleDetail t) throws Exception {
        return super.Create(t);
    }

    @Override
    public boolean Update(SaleDetail t) throws Exception {
        return super.Update(t);
    }

    @Override
    public boolean Delete(SaleDetail t) throws Exception {
        return super.Delete(t);
    }

    @Override
    public List<SaleDetail> findAll(String t) throws Exception {
        return super.findAll(t);
    }

    @Override
    public SaleDetail findBy(String q) throws Exception {
        return super.findBy(q);
    }

    @Override
    public List<SaleDetail> findByQuery(String q) throws Exception {
        return super.findByQuery(q);
    }

    @Override
    public List<SaleDetail> findByNativeQuery(String nq) throws Exception {
        return super.findByNativeQuery(nq);
    }

}
