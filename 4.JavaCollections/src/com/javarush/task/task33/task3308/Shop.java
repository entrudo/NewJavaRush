package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "Shop")
@XmlRootElement
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    @XmlAnyElement
    public String[] secretData;

    @XmlType(name = "Goods")
    @XmlRootElement
    private static class Goods {
        @XmlList
        public List<String> names = new ArrayList<>();
    }
}
