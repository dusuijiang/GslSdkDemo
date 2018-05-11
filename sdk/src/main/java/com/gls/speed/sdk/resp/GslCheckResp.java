package com.gls.speed.sdk.resp;


import java.util.List;

/**
 * 资格审查
 */
public class GslCheckResp extends BaseResp {

    private List<ProductListBean> ProductList; //可购买产品信息
    public List<ProductListBean> getProductList() {
        return ProductList;
    }

    public void setProductList(List<ProductListBean> ProductList) {
        this.ProductList = ProductList;
    }

    @Override
    public String toString() {

        return "GslCheckResp{" +
                super.toString()+
                ", ProductList=" + ProductList +
                '}';
    }

    public static class ProductListBean {
        private String productCode; //产品码
        private String providerCode; //
        private int price; //产品价格
        private int longTimeType;
        private String productName;

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public String getProviderCode() {
            return providerCode;
        }

        public void setProviderCode(String providerCode) {
            this.providerCode = providerCode;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getLongTimeType() {
            return longTimeType;
        }

        public void setLongTimeType(int longTimeType) {
            this.longTimeType = longTimeType;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        @Override
        public String toString() {
            return "ProductListBean{" +
                    "productCode='" + productCode + '\'' +
                    ", providerCode='" + providerCode + '\'' +
                    ", price=" + price +
                    ", longTimeType=" + longTimeType +
                    ", productName='" + productName + '\'' +
                    '}';
        }
    }
}
