package name.krot.exchange.service;

import io.grpc.stub.StreamObserver;
import name.krot.grpc.Exchange;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class HelloServiceImpl extends name.krot.grpc.SayHelloGrpc.SayHelloImplBase {

    @Override
    public void getCourse(Exchange.RequestCourse request, StreamObserver<Exchange.ReplyCourse> responseObserver) {
        System.out.println("+++" + request.getId());
        Exchange.ReplyCourse reply = Exchange.ReplyCourse.
                newBuilder().
                setName("VTB").
                setId(request.getId()).
                setPrice((long) (Math.random() * 100)).
                build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
