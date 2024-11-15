package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_details")
public class ExcelData {
    
    @Id
    @Column(name="product_id")
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productId;
    
    @Column(name = "product_name")
    private String productName;
    
    @Column(name = "product_type")
    private String productType;
    
    @Column(name = "price")
    private String price;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
   
}

