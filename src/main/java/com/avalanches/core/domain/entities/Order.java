package com.avalanches.core.domain.entities;

import jdk.jfr.Timespan;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;

public class Order {

    private String id = UUID.randomUUID().toString();

    private OrderStatus status;

    private BigDecimal value;

    private String customerId;

    private LocalDateTime createdDate;

    private LocalDateTime finishedDate;

    // FIXME: Analisar como vai ser feito
    private Timespan waitTime;

    private List<Integer> productsIds;

}
