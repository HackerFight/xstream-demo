package com.qiuguan.xstrem.bean;

import com.qiuguan.xstrem.converter.BigDecimalConverterAdapter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author fu yuan hui
 * @date 2023-07-29 17:41:53 Saturday
 */
@XStreamAlias("Person")
@Data
public class Person {

    private String name;

    private String country;

    private String city;

    private BigDecimal salary;

    private LocalDate birthDay;

}
