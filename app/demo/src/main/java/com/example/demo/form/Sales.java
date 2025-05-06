package com.example.demo.form;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Sales {
    
    private String salesNo;

    private List<SalesItem> items;


    public static final Sales sample() {
        Sales sales = new Sales();
        sales.setSalesNo("S0001");
        sales.setItems(List.of(
            new SalesItem("ポテト", "100", "2"),
            new SalesItem("コーラ", "200", "4"),
            new SalesItem("チュロス", "300", "6")
        ));
        return sales;
    }
}
