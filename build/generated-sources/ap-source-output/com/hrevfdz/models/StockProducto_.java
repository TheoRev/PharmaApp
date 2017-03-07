package com.hrevfdz.models;

import com.hrevfdz.models.Laboratorio;
import com.hrevfdz.models.SaleDetail;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-04T22:36:01")
@StaticMetamodel(StockProducto.class)
public class StockProducto_ { 

    public static volatile SingularAttribute<StockProducto, BigInteger> monto;
    public static volatile SingularAttribute<StockProducto, String> lote;
    public static volatile SingularAttribute<StockProducto, String> presentacion;
    public static volatile SingularAttribute<StockProducto, Integer> codStock;
    public static volatile ListAttribute<StockProducto, SaleDetail> saleDetailList;
    public static volatile SingularAttribute<StockProducto, Integer> cantidad;
    public static volatile SingularAttribute<StockProducto, String> nombre;
    public static volatile SingularAttribute<StockProducto, Laboratorio> codLab;

}