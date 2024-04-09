package org.wind57.gatewaydemo.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GatewayController {

    private final DiscoveryClient discoveryClient;

    public GatewayController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/services")
    List<String> services() {
        return discoveryClient.getServices();
    }

    @GetMapping("/instances")
    List<ServiceInstance> instances(@RequestParam(name = "serviceId") String serviceId) {
        return discoveryClient.getInstances(serviceId);
    }

}
