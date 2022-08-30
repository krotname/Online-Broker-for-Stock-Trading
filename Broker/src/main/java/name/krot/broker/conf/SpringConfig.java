package name.krot.broker.conf;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import name.krot.grpc.ExchangeGrpc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Value("${app.exchange-url}")
    private String exchangeUrl;

    @Bean
    public ExchangeGrpc.ExchangeBlockingStub blockingStub() {
        ManagedChannel channel = ManagedChannelBuilder.forTarget(exchangeUrl)
                .usePlaintext()
                .build();
        return ExchangeGrpc.newBlockingStub(channel);
    }

}
