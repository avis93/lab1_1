/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class OfferItem {

    // product
    
    BigDecimal totalCost;
    Discount discountForOffer ;
    Product productForOffer;


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discountForOffer.getDiscount() == null ? 0 : discountForOffer.getDiscount().hashCode());
        result = prime * result + (productForOffer.getProductName() == null ? 0 : productForOffer.getProductName().hashCode());
        result = prime * result + (productForOffer.getProductPrice() == null ? 0 : productForOffer.getProductPrice().hashCode());
        result = prime * result + (productForOffer.getProductId() == null ? 0 : productForOffer.getProductId().hashCode());
        result = prime * result + (productForOffer.getProductType() == null ? 0 : productForOffer.getProductType().hashCode());
        result = prime * result + productForOffer.getQuantity();
        result = prime * result + (totalCost == null ? 0 : totalCost.hashCode());
        return result;
    }

   
    public boolean equals(Object obj1, Object obj2) {
        if (this == obj1) {
            return true;
        }
        if (obj1 == null) {
            return false;
        }
        
        if (this == obj2) {
            return true;
        }
        if (obj2 == null) {
            return false;
        }
        
        if (getClass() != obj1.getClass()) {
            return false;
        }
        Product other = (Product) obj1;
        Discount otherDiscount = (Discount) obj2;
        if (discountForOffer.getDiscount() == null) {
            if (otherDiscount.getDiscount() != null) {
                return false;
            }
        } else if (!discountForOffer.getDiscount().equals(otherDiscount.getDiscount())) {
            return false;
        }
        if (productForOffer.getProductName() == null) {
            if (other.getProductName() != null) {
                return false;
            }
        } else if (!productForOffer.getProductName().equals(other.getProductName())) {
            return false;
        }
        if (productForOffer.getProductPrice() == null) {
            if (other.getProductPrice() != null) {
                return false;
            }
        } else if (!productForOffer.getProductPrice().equals(other.getProductPrice())) {
            return false;
        }
        if (productForOffer.getProductId() == null) {
            if (other.getProductId() != null) {
                return false;
            }
        } else if (!productForOffer.getProductId().equals(other.getProductId())) {
            return false;
        }
        if (productForOffer.getProductType() != other.getProductType()) {
            return false;
        }
        if (productForOffer.getQuantity() != other.getQuantity()) {
            return false;
        }
        if (productForOffer.getCostOfItem() == null) {
            if (other.getCostOfItem()!= null) {
                return false;
            }
        } else if (!productForOffer.getCostOfItem().equals(other.getCostOfItem())) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param item
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(Product product,Product other, double delta) {
        if (product.getProductName() == null) {
            if (other.getProductName() != null) {
                return false;
            }
        } else if (!product.getProductName().equals(other.getProductName())) {
            return false;
        }
        if (product.getProductPrice() == null) {
            if (other.getProductPrice() != null) {
                return false;
            }
        } else if (!product.getProductPrice().equals(other.getProductPrice())) {
            return false;
        }
        if (product.getProductId() == null) {
            if (other.getProductId() != null) {
                return false;
            }
        } else if (!product.getProductId().equals(other.getProductId())) {
            return false;
        }
        if (product.getProductType() != other.getProductType()) {
            return false;
        }

        if (product.getQuantity() != other.getQuantity()) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (product.getCostOfItem().compareTo(other.getCostOfItem()) > 0) {
            max = product.getCostOfItem();
            min = other.getCostOfItem();
        } else {
            max = other.getCostOfItem();
            min = product.getCostOfItem();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
