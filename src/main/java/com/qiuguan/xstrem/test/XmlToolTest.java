package com.qiuguan.xstrem.test;

import com.qiuguan.xstrem.bean.Order;
import com.qiuguan.xstrem.bean.OrderDetail;
import com.qiuguan.xstrem.bean.Person;
import com.qiuguan.xstrem.utils.XmlParseTools;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author fu yuan hui
 * @date 2023-07-29 17:26:20 Saturday
 */
public class XmlToolTest {

    public static void main(String[] args) {


        OrderDetail orderDetail = new OrderDetail("1001", "北京朝阳区", "3");

        Order order = new Order();
        order.setOrderId("1000000000001");
        order.setCount(3);
        order.setMoney(new BigDecimal("588"));
        order.setPrice(666.56);
        order.setBuyDate(LocalDateTime.now());
        order.setIsSuccess(true);

        order.setOrderDetail(orderDetail);


        String orderXml = XmlParseTools.beanToXml(order);
        System.out.println("orderXml = " + orderXml);


        System.out.println("==========================================================");

        String xml = "<Person>\n" +
                "  <name>zhangsan</name>\n" +
                "  <country>中国</country>\n" +
                "  <city>beijing</city>\n" +
                "  <salary></salary>\n" +
                "  <birthDay>2023-07-29</birthDay>\n" +
                "</Person>";

        Person person = XmlParseTools.strToBean(xml, Person.class);
        System.out.println("person = " + person);
    }
}
