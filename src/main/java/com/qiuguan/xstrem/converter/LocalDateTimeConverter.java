package com.qiuguan.xstrem.converter;

import com.thoughtworks.xstream.converters.SingleValueConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author fu yuan hui
 * @date 2023-07-13 19:22:44 Thursday
 */
//@Slf4j
public class LocalDateTimeConverter implements SingleValueConverter {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String toString(Object obj) {
        try {
            if (!Objects.isNull(obj) && (obj instanceof LocalDateTime)) {
                return dateTimeFormatter.format((LocalDateTime) obj);
            }
        } catch (Exception e) {
            /**
             * 这里如果解析失败最好不要抛出异常，返回null,
             * 然后把 {@link com.thoughtworks.xstream.annotations.XStreamConverter}注解标注
             * 在需要解析的属性上，完成局部的解析映射。
             */
            //log.error("LocalDateTime 格式转换错误，args: {}", obj);
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Object fromString(String str) {
        try {
            if (StringUtils.isNotBlank(str)) {
                return LocalDateTime.parse(str, dateTimeFormatter);
            }
        } catch (Exception e) {
            //log.error("字符串格式的日期转换LocalDateTime发生错误， args: {}", str);
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean canConvert(Class type) {
        return type == LocalDateTime.class;
    }
}