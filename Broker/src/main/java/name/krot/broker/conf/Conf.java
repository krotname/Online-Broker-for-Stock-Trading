package name.krot.broker.conf;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import name.krot.grpc.ExchangeGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Conf {

    @Bean
    public ExchangeGrpc.ExchangeBlockingStub blockingStub() {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("127.0.0.1:7777")
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
        return ExchangeGrpc.newBlockingStub(channel);
    }

}
