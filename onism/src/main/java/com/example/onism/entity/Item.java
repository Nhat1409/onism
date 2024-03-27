package com.example.onism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long id;
    private String tenSP;
    private Double giaTien;
    private int quantity;
    private String kichThuoc;
}
