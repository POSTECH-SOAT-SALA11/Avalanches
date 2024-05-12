package com.avalanches.core.domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {

    private String id;

    private String name;

    private String document;

    private String email;

    private List<Integer> ordersIds;

    public Customer(String name, String document, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.document = document;
        this.email = email;
        this.ordersIds = new ArrayList<>();;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }
}
