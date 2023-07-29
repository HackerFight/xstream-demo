package com.qiuguan.xstrem.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author fu yuan hui
 * @date 2023-07-29 17:28:10 Saturday
 */
@AllArgsConstructor
@Data
public class OrderDetail {

    private String id;

    private String address;

    private String type;
}
