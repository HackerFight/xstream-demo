package com.qiuguan.xstrem.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author fu yuan hui
 * @date 2023-07-29 17:26:37 Saturday
 */
@Data
@XStreamAlias("O:ORDER")
public class Order {

    @XStreamAsAttribute
    private String orderId;

    //int/Integer 类型
    private int count;

    @XStreamAlias("orderPrice")
    private Double price;

    //BigDecimal类型
    private BigDecimal money;

    //Byte 类型
    private Byte flag;

    private LocalDateTime buyDate;

    //Boolean 类型
    private Boolean isSuccess;

    @XStreamAlias("detail")
    private OrderDetail orderDetail;
}
