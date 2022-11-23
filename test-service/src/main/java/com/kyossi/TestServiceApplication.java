package com.kyossi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class TestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestServiceApplication.class, args);
    }

}

@RefreshScope
@RestController
class MessageRestController {

    private static Logger log = LoggerFactory.getLogger(MessageRestController.class);

    @Value("${message:Hello default}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }

    @RequestMapping("/customer")
    Customer getCustomer() {
        log.info("Ndoudja Bakari");
        return new Customer("CACF","Crédit Agricole Customer Finance");
    }

    class Customer {
        String name;
        String desc;

        public Customer() {
        }

        public Customer(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "Customer{}";
        }
    }
}