package io.quarkus.qe.kafka;

import io.quarkus.qe.kafka.resources.ConfluentTestProfile;
import io.quarkus.test.junit.DisabledOnNativeImage;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;

@QuarkusTest
@TestProfile(ConfluentTestProfile.class)
@DisabledOnNativeImage
public class ConfluentKafkaTest extends KafkaCommonTest {
    private static final String STOCK_MONITOR_SSE_ENDPOINT = "http://localhost:8083/stock/stream";

    @Override
    protected String getServerSentEventURL() {
        return STOCK_MONITOR_SSE_ENDPOINT;
    }
}
