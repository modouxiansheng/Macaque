package com.dmh.xa.mybatis.dao;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {

    private Long id;
    private Long orderId;
    private Long venderId;
    private Long idCompanyBranch;
    private String cky2;
    private Integer paymentType;
    private Integer orderType;
    private Long freight;
    private Integer paysumType;
    private Integer state;
    private Integer state2;
    private Integer printx;
    private Integer ziti;
    private Integer orderPopStatus;
    private Integer yn;
    private Date orderCreateDate;
    private Long supposePay;
    private Long shouldPay;
    private Date outboundDate;
    private Integer deligoodType;
    private Integer idShipmenttype;
    private Integer areaNum;
    private String consName;
    private String consAddress;
    private String consPhone;
    private String consMobilePhone;
    private String consEmail;
    private String consPostCode;
    private String remark;
    private Long parentId;
    private Integer jiFen;
    private String carrierId;
    private Integer storeId;
    private Date orderCompletetime;
    private Date created;
    private Date modified;
    //商家结算金额=ordersum-套装优惠-单品优惠
    private Long sellerOrderSum;
    //套装优惠+单品优惠
    private Long couponEventSum;
    private Long orderSum;
    private String invoiceTitle;
    private Integer invoiceContentId;
    private String invoiceType;
    private Integer dispathId;           //站点ID
    private String dispathName;           //站点名称
    private Integer province;           //省
    private Integer city;           //市
    private Integer county;           //县
    private Integer town; //镇
    private Integer invoiceState;     //是否需要开具发票(0,1为需开，2,3为不需开)
    private Long balanceUsed;
    /**
     * 使用余额
     */
    //3COD收款确认时间
    private Date paymentConfirmTime;
    /**
     * erp状态
     */
    private Integer erpOrderStatus;
    /**
     * erp修改时间
     */
    private Date erpUpdateTime;
    /**
     * erp同步时间
     */
    private Date erpSynchTime;
    private String consIndex; //收货人姓名、收货人电话、收入地址三个字段联合用作判断是否统一用户

    /**
     * erp订单表预留标记，为01表示的50位字符串，每位含义不同
     */
    private String orderSign;

    private String pin;//下单账号
    private String customerIp; //下单ip
    private Long centerId;

    private String vatInfo;     //增值税信息

    /**
     * 推荐物流公司ID
     */
    private Long recommendDeliveryId;

    /**
     * 海关编号
     */
    private String customs;

    /**
     * 海关模式
     */
    private String customsModel;

    /**
     * 供应商id
     */
    private Long supplier;

    /**
     * 门店帮导购员pin
     */
    private String salesPin;

    /**
     * 门店帮门店id
     */
    private Integer mdbStoreId;
    /**
     * 上一级父ID
     */
    private Long directParentId;

    private Integer operator;
    /**
     * pop sendPay
     */
    private String popSendPay;

    private String popSendPayData;

    private String pauseBizStatusJson;

    /**
     * sendpay2.0新增字段 sendpayMap
     */
    private String sendpayMap;

    /**
     * 来源
     */
    private String region;
}
