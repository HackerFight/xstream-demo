package com.qiuguan.xstrem.converter;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @author fu yuan hui
 * @date 2023-07-29 16:41:53 Saturday
 */
public class BigDecimalConverterAdapter extends AbstractSingleValueConverter {

    @Override
    public boolean canConvert(Class type) {
        return type == BigDecimal.class;
    }

    @Override
    public Object fromString(String str) {
        return StringUtils.isNotBlank(str) ? new BigDecimal(str) : null;
    }
}
