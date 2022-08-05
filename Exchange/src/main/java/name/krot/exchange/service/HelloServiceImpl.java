package name.krot.exchange.service;

import io.grpc.stub.StreamObserver;
import name.krot.grpc.Reply;
import name.krot.grpc.Request;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl extends name.krot.grpc.SayHelloGrpc.SayHelloImplBase {

    @Override
    public void sayHello(Request request, StreamObserver<Reply> responseObserver) {
        Reply reply = Reply.newBuilder().setName("Hello " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
