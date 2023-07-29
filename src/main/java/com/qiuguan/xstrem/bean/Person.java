package com.qiuguan.xstrem.bean;

import com.qiuguan.xstrem.converter.BigDecimalConverterAdapter;
import com.qiuguan.xstrem.converter.LocalDateAdapterConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
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

    /**
     * 如果属性上标注了这个注解，那么他会使用这里指定的转换器去工作，而不会使用
     * 全局的转换器。{@link com.qiuguan.xstrem.utils.XmlParseTools}
     */
    @XStreamConverter(value = LocalDateAdapterConverter.class)
    private LocalDate birthDay;

}
