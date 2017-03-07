package com.hrevfdz.models;

import com.hrevfdz.models.StockProducto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-04T22:36:01")
@StaticMetamodel(Laboratorio.class)
public class Laboratorio_ { 

    public static volatile SingularAttribute<Laboratorio, String> nomLab;
    public static volatile ListAttribute<Laboratorio, StockProducto> stockProductoList;
    public static volatile SingularAttribute<Laboratorio, Integer> codLab;

}