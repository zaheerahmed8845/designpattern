package org.example.common;

public class BusinessCardDesigner {

    public String designCard(Customer customer) {
        String card = "";
        card += customer.getName();
        card += "\n" + customer.getDesignation();
        card += "\n" + customer.getAddrerss();
        return card;
    }

}
