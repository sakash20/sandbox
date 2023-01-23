package com.redhat.service.smartevents.manager.v2;

public class TestConstants {

    public static final String DEFAULT_BRIDGE_ID = "myId";
    public static final String DEFAULT_CUSTOMER_ID = "kekkobar";
    public static final String DEFAULT_ORGANISATION_ID = "myOrg";
    public static final String DEFAULT_USER_NAME = "kekkobar";
    public static final String DEFAULT_BRIDGE_NAME = "myBridge";
    public static final String DEFAULT_BRIDGE_ENDPOINT = "https://bridge.redhat.com";

    public static final String DEFAULT_BRIDGE_TLS_CERTIFICATE = "tlsCertificate";
    public static final String DEFAULT_BRIDGE_TLS_KEY = "tlsKey";

    public static final String SHARD_ID = DEFAULT_CUSTOMER_ID;
    public static final String DEFAULT_SHARD_ROUTER_CANONICAL_HOSTNAME = "router." + SHARD_ID + ".com";

    public static final String DEFAULT_PROCESSOR_ID = "myProcessorId";
    public static final String DEFAULT_PROCESSOR_NAME = "myProcessor";

    public static final String DEFAULT_CONNECTOR_ID = "myConnectorId";
    public static final String DEFAULT_CONNECTOR_NAME = "myConnector";
    public static final String DEFAULT_CONNECTOR_EXTERNAL_ID = "myConnectorExternalId";
    public static final String DEFAULT_CONNECTOR_TYPE_ID = "my_connector_0.1";
    public static final String DEFAULT_CONNECTOR_TOPIC_NAME = "myTopicName";

    public static final String DEFAULT_CLOUD_PROVIDER = "aws";
    public static final String DEFAULT_REGION = "us-east-1";

    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_PAGE_SIZE = 10;

    public static final String FAILED_CONDITION_ERROR_CODE = "OPENBRIDGE-1";
    public static final String FAILED_CONDITION_ERROR_MESSAGE = "Something went wrong";
}
