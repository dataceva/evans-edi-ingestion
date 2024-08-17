package com.dc.evans.edi.model.x12.enums;

public enum NameEnums {
	BUYER_NAME("BY", "Buyer Name"),
	SELLER_NAME("SE", "Seller Name"),
	SHIP_TO("ST", "Ship To"),
	SHIPPER("SH", "Shipper"),
	SHIP_FROM("SF", "Ship From"),
	MESSAGE_FROM("FR", "Message From"),
	MESSAGE_TO("TO", "Message To"),
	CORPORATE_OFFICE("CQ", "Corporate Office"),
	STORE("SN", "Store"),
	WAREHOUSE("WH", "Warehouse"),
	SUPPLIER_MANUFACTURER("SU", "Supplier/Manufacturer"),
	PURCHASER_DEPARTMENT_BUYER("PD", "Purchaser's Department Buyer"),
	ORDER_BY("OB", "Order By"),
	BENEFICIAL_OWNER("BN", "Beneficial Owner"),
	CONSIGNEE("CN", "Consignee"),
	BILL_TO_PARTY("BT", "Bill to Party"),
	PAYER("PR", "Payer");

    private final String code;
    private final String meaning;

    NameEnums(String code, String meaning) {
        this.code = code;
        this.meaning = meaning;
    }

    public String getCode() {
        return code;
    }

    public String getMeaning() {
        return meaning;
    }

    public static NameEnums getByCode(String code) {
        for (NameEnums status : values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid Name code: " + code);
    }

}
