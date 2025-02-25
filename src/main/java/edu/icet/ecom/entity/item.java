package edu.icet.ecom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Entity
public class item {
    @Id
    String itemNo;
    String itemType;
    String name;
    Double price;
    String imageUrl;

    public item() {
    }

    public item(String itemNo, String itemType, String name, Double price, String imageUrl) {
        this.itemNo = itemNo;
        this.itemType = itemType;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
