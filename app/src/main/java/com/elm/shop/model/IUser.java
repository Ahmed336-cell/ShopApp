package com.elm.shop.model;

public interface IUser {
    String getEmail();
    String getPassword();
    boolean isValid();
}
