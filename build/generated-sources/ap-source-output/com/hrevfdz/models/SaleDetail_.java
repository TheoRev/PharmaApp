package com.hrevfdz.models;

import com.hrevfdz.models.Sale;
import com.hrevfdz.models.StockProducto;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-04T22:36:01")
@StaticMetamodel(SaleDetail.class)
public class SaleDetail_ { 

    public static volatile SingularAttribute<SaleDetail, Sale> codSale;
    public static volatile SingularAttribute<SaleDetail, BigInteger> subtotal;
    public static volatile SingularAttribute<SaleDetail, StockProducto> codStock;
    public static volatile SingularAttribute<SaleDetail, BigInteger> cantidad;
    public static volatile SingularAttribute<SaleDetail, Integer> codDetail;

}