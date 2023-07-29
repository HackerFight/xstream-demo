package com.qiuguan.xstrem.converter;

import com.thoughtworks.xstream.converters.SingleValueConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Objects;

/**
 * @author fu yuan hui
 * @date 2023-07-13 19:22:44 Thursday
 */
//@Slf4j
public class LocalDateConverter implements SingleValueConverter {

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public String toString(Object obj) {
        try {
            if (!Objects.isNull(obj)) {
                return dateFormatter.format((TemporalAccessor) obj);
            }
        } catch (Exception e) {
            //log.error("LocalDate 格式转换错误，args: {}", obj);
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Object fromString(String str) {
        try {
            if (StringUtils.isNotBlank(str)) {
                return LocalDate.parse(str, dateFormatter);
            }
        } catch (Exception e) {
            //log.error("字符串格式的日期转换LocalDate发生错误， args: {}", str);
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean canConvert(Class type) {
        return type == LocalDate.class;
    }
}