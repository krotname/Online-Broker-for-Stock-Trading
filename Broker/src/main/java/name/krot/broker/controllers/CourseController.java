package name.krot.broker.controllers;

import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import name.krot.broker.dto.DtoCourse;
import name.krot.grpc.ExchangeGrpc;
import name.krot.grpc.ExchangeOuterClass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CourseController {

    private final ExchangeGrpc.ExchangeBlockingStub blockingStub;

    @GetMapping("course/{name}")
    public DtoCourse getCourse(@PathVariable String name) {
        log.info(name);
        ExchangeOuterClass.RequestCourse request = ExchangeOuterClass.RequestCourse.newBuilder().setName(name).build();
        ExchangeOuterClass.ReplyCourse response = null;
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
