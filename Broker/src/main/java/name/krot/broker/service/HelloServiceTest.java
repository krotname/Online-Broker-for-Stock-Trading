package name.krot.broker.service;

import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import name.krot.broker.entity.DtoCourse;
import name.krot.grpc.Exchange;
import name.krot.grpc.SayHelloGrpc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class HelloServiceTest {

    private final SayHelloGrpc.SayHelloBlockingStub blockingStub;

    @GetMapping("/{id}")
    public @ResponseBody
    DtoCourse getBook(@PathVariable int id) {
        log.info(String.valueOf(id));
        Exchange.RequestCourse request = Exchange.RequestCourse.newBuilder().setId(id).build();
        Exchange.ReplyCourse response = null;
        try {
            response = blockingStub.getCourse(request);
            log.info("Price: " + response.getPrice());
        } catch (StatusRuntimeException e) {
            log.warn("RPC failed: {0}", e.getStatus());
        }
        return DtoCourse.builder()
                .name(response.getName())
                .price(response.getPrice())
                .id(response.getId())
                .build();
    }
}
