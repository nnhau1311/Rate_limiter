package com.example.ratelimiter.client;

import com.example.ratelimiter.model.PhoneReport;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "phone-service") // http://localhost:9092/api/phones
public interface PhoneServiceClient {
    @GetMapping("api/phones")
    public List<PhoneReport> getAllPhoneReport();

    @GetMapping("api/phones/{id}") //http://localhost:9092/api/phones/{id}
    public PhoneReport getPhoneReportById(@PathVariable("idPhone") int idPhone);
}
