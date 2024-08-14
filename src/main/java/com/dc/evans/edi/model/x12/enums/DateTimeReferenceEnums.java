package com.dc.evans.edi.model.x12.enums;

public enum DateTimeReferenceEnums {
	SHIP_BY_DATE("010", "Ship By Date"),
    DELIVER_BY_DATE("002", "Deliver By Date"),
	SHIPPED_DATE("011", "Shipped Date"),
    ESTIMATE_DELIVERY_DATE("017", "Estimated Deliver Date"),
    EFFECTIVE_DATE("007", "Effective Date"),
    SHIP_NOT_BEFORE_DATE("037", "Ship Not Before Date"),
    SHIP_NO_LATER_DATE("038", "Ship No Later Date"),
    DO_NOT_DELIVER_AFTER_DATE("063", "Do Not Deliver After Date");

    private final String code;
    private final String meaning;

    DateTimeReferenceEnums(String code, String meaning) {
        this.code = code;
        this.meaning = meaning;
    }

    public String getCode() {
        return code;
    }

    public String getMeaning() {
        return meaning;
    }

    public static DateTimeReferenceEnums getByCode(String code) {
        for (DateTimeReferenceEnums status : values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid ShippingStatus code: " + code);
    }

}
