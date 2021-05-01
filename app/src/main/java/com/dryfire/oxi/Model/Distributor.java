package com.dryfire.oxi.Model;

import java.util.Objects;

public class Distributor {


    private String shopName;
    private int available;
    private int capacity;
    private float pricePerUnit;
    private long pincode;
    private long mobile;
    private String address;
    private String city;
    private String donorName;

    private Distributor(String shopName, int available, int capacity, float pricePerUnit, long pincode, long mobile, String address, String city, String donorName) {
        this.shopName = shopName;
        this.available = available;
        this.capacity = capacity;
        this.pricePerUnit = pricePerUnit;
        this.pincode = pincode;
        this.mobile = mobile;
        this.address = address;
        this.city = city;
        this.donorName = donorName;
    }


    public static class Builder {

        private String shopName;
        private int available;
        private int capacity;
        private float pricePerUnit;
        private long pincode;
        private long mobile;
        private String address;
        private String city;
        private String donorName;

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
                    Objects.equals(shopName, builder.shopName) &&
                    Objects.equals(address, builder.address) &&
                    Objects.equals(city, builder.city) &&
                    Objects.equals(donorName, builder.donorName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(shopName, available, capacity, pricePerUnit, pincode, mobile, address, city, donorName);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "shopName='" + shopName + '\'' +
                    ", available=" + available +
                    ", capacity=" + capacity +
                    ", pricePerUnit=" + pricePerUnit +
                    ", pincode=" + pincode +
                    ", mobile=" + mobile +
                    ", address='" + address + '\'' +
                    ", city='" + city + '\'' +
                    ", donorName='" + donorName + '\'' +
                    '}';
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

        public Builder setAddress(String address){
            this.address = address;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setDonorName(String donorName) {
            this.donorName = donorName;
            return this;
        }

        public Distributor build(){
            return  new Distributor(shopName,available,capacity,pricePerUnit,pincode,mobile,address,city,donorName);
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

    public String getAddress(){
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getDonorName() {
        return donorName;
    }
}


