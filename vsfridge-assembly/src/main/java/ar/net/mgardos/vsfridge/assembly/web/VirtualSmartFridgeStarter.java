package ar.net.mgardos.vsfridge.assembly.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VirtualSmartFridgeStarter {
    public static void main( String[] args ) {
        SpringApplication.run(VirtualSmartFridgeStarter.class, args);
    }

    @RequestMapping(value = "/turnOn", method = RequestMethod.GET)
    public void turnOn() {

    }

    @RequestMapping(value = "/open", method = RequestMethod.GET)
    public void open() {

    }

    @RequestMapping(value = "/close", method = RequestMethod.GET)
    public void close() {

    }

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    public void put() {

    }

    @RequestMapping(value = "/take/{productId}", method = RequestMethod.GET)
    public void take() {

    }
}
