package com.avalanches.core.domain.entities;

import java.math.BigDecimal;
import java.util.List;

public class Product {

    private int id;

    private BigDecimal value;

    private int amount;

    private ProductCategory category;

    private String name;

    private String description;

    private List<Integer> images;

}
