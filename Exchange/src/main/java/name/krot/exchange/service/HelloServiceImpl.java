package name.krot.exchange.service;

import io.grpc.stub.StreamObserver;
import name.krot.grpc.Reply;
import name.krot.grpc.Request;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class HelloServiceImpl extends name.krot.grpc.SayHelloGrpc.SayHelloImplBase {

    @Override
    public void sayHello(Request request, StreamObserver<Reply> responseObserver) {
        System.out.println("+++" + request.getName());
        Reply reply = Reply.newBuilder().setName("Hello " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
