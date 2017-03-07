package com.hrevfdz.models;

import com.hrevfdz.models.SaleDetail;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-04T22:36:01")
@StaticMetamodel(Sale.class)
public class Sale_ { 

    public static volatile SingularAttribute<Sale, Date> fecha;
    public static volatile SingularAttribute<Sale, Integer> codigo;
    public static volatile SingularAttribute<Sale, BigInteger> total;
    public static volatile ListAttribute<Sale, SaleDetail> saleDetailList;

}