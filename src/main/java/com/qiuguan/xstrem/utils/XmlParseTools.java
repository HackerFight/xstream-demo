package com.qiuguan.xstrem.utils;

import com.qiuguan.xstrem.converter.BigDecimalConverterAdapter;
import com.qiuguan.xstrem.converter.LocalDateConverter;
import com.qiuguan.xstrem.converter.LocalDateTimeConverter;
import com.qiuguan.xstrem.converter.NullConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import lombok.extern.slf4j.Slf4j;

/**
 * @author qiuguan
 */
//@Slf4j
public class XmlParseTools {

    @SuppressWarnings("unchecked")
    public static <T> T strToBean(String xmlStr, Class<T> cls) {
        T targetObject;
        try {
            XStream xstream = new XStream(new DomDriver("UTF-8", new NoNameCoder()));
            xstream.ignoreUnknownElements();
            xstream.addPermission(AnyTypePermission.ANY);
            //和上面一样，也是用来解决高版本中安全问题的
            //xstream.allowTypesByWildcard(new String[]{"com.qiuguan.**"});
            xstream.processAnnotations(cls);
            xstream.autodetectAnnotations(true);
            xstream.registerConverter(new LocalDateConverter(), XStream.PRIORITY_VERY_HIGH);
            xstream.registerConverter(new LocalDateTimeConverter(), XStream.PRIORITY_VERY_HIGH);
            //框架自带的Boolean类型转换器，可以将xml中的 yes 转成true, 将 no 转成false, 默认是将 "true"字符串转成boolean类型的true
            xstream.registerConverter(new BooleanConverter("yes", "no", false));
            xstream.registerConverter(new BigDecimalConverterAdapter(), XStream.PRIORITY_VERY_HIGH);
            targetObject = (T) xstream.fromXML(xmlStr);
        } catch (Exception e) {
            throw new RuntimeException("parse error", e);
        }
        return targetObject;
    }

    public static String beanToXml(Object obj) {
        String xmlString;
        try {
            XStream xstream = new XStream(new DomDriver("UTF-8", new NoNameCoder()));
            //支持注解，不然使用的 @XStreamAlias() 注解不会生效
            xstream.autodetectAnnotations(true);
            // 不输出class信息,不然标签中会包含class属性
            xstream.aliasSystemAttribute(null, "class");
            //自定义类型转换器，优先级要高，不然还是会使用框架的转换器
            //这里如果不注册的话，序列化的时候自定义的转换器就不会生效了，只在反序列化的时候生效
            xstream.registerConverter(new LocalDateConverter(), XStream.PRIORITY_VERY_HIGH);
            xstream.registerConverter(new LocalDateTimeConverter(), XStream.PRIORITY_VERY_HIGH);
            //框架自带的Boolean类型转换器，序列化时可以将 yes 转成true, 将 no 转成false, 默认是将 "true"字符串转成boolean类型的true
            xstream.registerConverter(new BooleanConverter("yes", "no", false));
            //注册null值序列化时也可以显示标签的转换器（参考文档）
            xstream.registerConverter(new NullConverter(xstream.getMapper()), XStream.PRIORITY_LOW);
            xmlString = xstream.toXML(obj);
        } catch (Exception e) {
            throw new RuntimeException("parse error", e);
        }
        return xmlString;
    }
}
