package com.yunn.autumnnacos.model;

import lombok.Data;

@Data
public class MerchantDo {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String merchantName;

    private Long merchantNo;

    private String merchantAddress;

    private String merchantType;

    private String businessLicensesImg;

    private String idCardFrontImg;

    private String idCardAfterImg;

    private String username;

    private String mobile;

    private String password;

    private String contactsAddress;

    private String auditStatus;

    private Long tenantId;
}
