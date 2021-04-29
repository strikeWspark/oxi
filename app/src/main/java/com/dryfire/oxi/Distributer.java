package com.dryfire.oxi;

import java.util.Objects;

public class Distributer {


    private String shopName;
    private int available;
    private int capacity;
    private float pricePerUnit;
    private long pincode;
    private long mobile;

    private Distributer(String shopName, int available, int capacity, float pricePerUnit, long pincode, long mobile) {
        this.shopName = shopName;
        this.available = available;
        this.capacity = capacity;
        this.pricePerUnit = pricePerUnit;
        this.pincode = pincode;
        this.mobile = mobile;
    }

    public static class Builder {

        private String shopName;
        private int available;
        private int capacity;
        private float pricePerUnit;
        private long pincode;
        private long mobile;

        @Override
        public String toString() {
            return "Builder{" +
                    "shopName='" + shopName + '\'' +
                    ", available=" + available +
                    ", capacity=" + capacity +
                    ", pricePerUnit=" + pricePerUnit +
                    ", pincode=" + pincode +
                    ", mobile=" + mobile +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return available == builder.available &&
                    capacity == builder.capacity &&
                    Float.compare(builder.pricePerUnit, pricePerUnit) == 0 &&
                    pincode == builder.pincode &&
                    mobile == builder.mobile &&
                    Objects.equals(shopName, builder.shopName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(shopName, available, capacity, pricePerUnit, pincode, mobile);
        }

        public Builder setShopName(String shopName) {
            this.shopName = shopName;
            return this;
        }

        public Builder setAvailable(int available) {
            this.available = available;
            return this;
        }

        public Builder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder setPricePerUnit(float pricePerUnit) {
            this.pricePerUnit = pricePerUnit;
            return this;
        }

        public Builder setPincode(long pincode) {
            this.pincode = pincode;
            return this;
        }

        public Builder setMobile(long mobile) {
            this.mobile = mobile;
            return this;
        }

        public Distributer build(){
            return  new Distributer(shopName,available,capacity,pricePerUnit,pincode,mobile);
        }
    }

    public String getShopName() {
        return shopName;
    }

    public int getAvailable() {
        return available;
    }

    public int getCapacity() {
        return capacity;
    }

    public float getPricePerUnit() {
        return pricePerUnit;
    }

    public long getPincode() {
        return pincode;
    }

    public long getMobile() {
        return mobile;
    }
}
