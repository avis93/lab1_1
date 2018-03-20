package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

	private String productId;

    private BigDecimal productPrice;

    private String productName;

    private Date productSnapshotDate;

    private String productType;

    private int quantity;
    
	private BigDecimal costOfItem;
	
	public BigDecimal getCostOfItem () {
		return costOfItem;
	}

    public Product(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate,
            String productType, int quantity, BigDecimal discount, String discountCause) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;

        this.quantity = quantity;
        
        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount);
        }

       
    }

    //getters
    public String getProductId() {
        return productId;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public String getProductType() {
        return productType;
    }
    public int getQuantity() {
        return quantity;
    }
    
    
    
}
