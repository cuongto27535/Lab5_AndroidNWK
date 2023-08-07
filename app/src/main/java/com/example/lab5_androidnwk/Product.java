package com.example.lab5_androidnwk;

import java.io.Serializable;

public class Product implements Serializable {
    String name, price, desc, _id,created_timeStamp, updated_timeStamp;
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", desc='" + desc + '\'' +
                ", _id='" + _id + '\'' +
                ", created_timeStamp='" + created_timeStamp + '\'' +
                ", updated_timeStamp='" + updated_timeStamp + '\'' +
                '}';
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreated_timeStamp() {
        return created_timeStamp;
    }

    public void setCreated_timeStamp(String created_timeStamp) {
        this.created_timeStamp = created_timeStamp;
    }

    public String getUpdated_timeStamp() {
        return updated_timeStamp;
    }

    public void setUpdated_timeStamp(String updated_timeStamp) {
        this.updated_timeStamp = updated_timeStamp;
    }
}
