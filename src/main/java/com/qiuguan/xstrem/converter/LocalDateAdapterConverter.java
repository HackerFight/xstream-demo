package com.qiuguan.xstrem.converter;

import com.thoughtworks.xstream.converters.SingleValueConverter;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Objects;

/**
 * @author fu yuan hui
 * @date 2023-07-29 18:10:20 Saturday
 */
public class LocalDateAdapterConverter implements SingleValueConverter {

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Override
    public String toString(Object obj) {
        try {
            if (!Objects.isNull(obj)) {
                return dateFormatter.format((TemporalAccessor) obj);
            }
        } catch (Exception e) {
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
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean canConvert(Class type) {
        return type == LocalDate.class;
    }
}
