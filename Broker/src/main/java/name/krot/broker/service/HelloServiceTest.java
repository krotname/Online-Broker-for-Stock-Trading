package name.krot.broker.service;

import io.grpc.StatusRuntimeException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import name.krot.grpc.SayHelloGrpc;
import name.krot.grpc.SayHelloOuterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@RestController
@Slf4j
@RequiredArgsConstructor
public class HelloServiceTest {

    private final SayHelloGrpc.SayHelloBlockingStub blockingStub;

    @GetMapping("/{id}")
    public @ResponseBody
    Book getBook(@PathVariable int id) {
        log.info(String.valueOf(id));
        log.info("Will try to greet " + id + " ...");
        SayHelloOuterClass.Request request = SayHelloOuterClass.Request.newBuilder().setName(String.valueOf(id)).build();
        SayHelloOuterClass.Reply response;
        try {
            response = blockingStub.sayHello(request);
        } catch (StatusRuntimeException e) {
            log.warn("RPC failed: {0}", e.getStatus());
        }
        //log.info("Greeting: " + response.getMessage());
        try {
            response = blockingStub.sayHello(request);
            System.out.println(response);
        } catch (StatusRuntimeException e) {
            log.warn("RPC failed: {0}", e.getStatus());
        }
//        log.info("Greeting: " + response.getMessage());

        return new Book();
    }
}
