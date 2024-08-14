package com.dc.evans.constant;

public interface ThreadNameConstant {

    /**
     * default
     */
    String DEFAULT_POOL_NAME_PREFIX = "default-pool-thread-";

    /**
     * syncInventoryJob
     */
    String SYNC_INVENTORY_POOL_NAME_PREFIX = "sync-inventory-pool-thread-";

    /**
     * orderDownloadJob
     */
    String ORDER_DOWNLOAD_POOL_NAME_PREFIX = "order-download-pool-thread-";

    /**
     * invoiceSenderJob
     */
    String INVOICE_SENDER_POOL_NAME_PREFIX = "invoice-sender-pool-thread-";

    /**
     * orderShipUpdateJob
     */
    String ORDER_SHIP_UPDATE_POOL_NAME_PREFIX = "order-ship-update-pool-thread-";

    /**
     * orderAckJob
     */
    String ORDER_ACK_POOL_NAME_PREFIX = "order-ack-pool-thread-";

}
