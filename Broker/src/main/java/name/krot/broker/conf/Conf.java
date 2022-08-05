package name.krot.broker.conf;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import name.krot.grpc.SayHelloGrpc;

@Configuration
public class Conf {

    @Bean
    public SayHelloGrpc.SayHelloBlockingStub blockingStub() {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("127.0.0.1:7777")
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
        return SayHelloGrpc.newBlockingStub(channel);
    }

}
