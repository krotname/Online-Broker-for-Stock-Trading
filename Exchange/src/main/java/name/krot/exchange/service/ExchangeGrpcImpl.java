package name.krot.exchange.service;

import io.grpc.stub.StreamObserver;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import name.krot.grpc.ExchangeOuterClass;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
@Slf4j
@RequiredArgsConstructor
public class ExchangeGrpcImpl extends name.krot.grpc.ExchangeGrpc.ExchangeImplBase {

    private final BondService bondService;

    @Override
    public void getCourse(ExchangeOuterClass.RequestCourse request, StreamObserver<ExchangeOuterClass.ReplyCourse> responseObserver) {

        log.info(""+request.getName());

        ExchangeOuterClass.ReplyCourse reply = bondService.getCurrentPrice(request.getName());

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
