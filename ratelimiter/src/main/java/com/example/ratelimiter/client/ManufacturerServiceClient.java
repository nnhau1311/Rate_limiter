package com.example.ratelimiter.client;

import com.example.ratelimiter.model.ManufacturerReport;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "manufacturer-service") // http://localhost:9093
public interface ManufacturerServiceClient {
        @GetMapping("api/manufacturers") //http://localhost:9093/api/manufacturers/
        public List<ManufacturerReport> getAllManufacturerReport();

        @GetMapping("api/manufacturers/{id}") //http://localhost:9093/api/manufacturers/{id}
        public ManufacturerReport getManufacturerReportById(@PathVariable("idManuafacturer") int idManuafacturer);
}
