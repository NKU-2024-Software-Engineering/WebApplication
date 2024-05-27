package com.fourteen.wms.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String account;
    private String name;
    private String password;
    private int sex;
    private int level;
    private String phone;
    private String isValid;
}
