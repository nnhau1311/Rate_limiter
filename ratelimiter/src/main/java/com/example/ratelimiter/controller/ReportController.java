package com.example.ratelimiter.controller;

import com.example.ratelimiter.client.ManufacturerServiceClient;
import com.example.ratelimiter.client.PhoneServiceClient;
import com.example.ratelimiter.model.ManufacturerReport;
import com.example.ratelimiter.model.PhoneReport;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private PhoneServiceClient phoneServiceClient;

    @Autowired
    private ManufacturerServiceClient manufacturerServiceClient;


    @GetMapping("/manufacturers") // http://localhost:9094/api/reports/manufacturers
    @RateLimiter(name = "default")
    public ResponseEntity<List<ManufacturerReport>> getAllManufacturerReport() throws Exception {
        List<ManufacturerReport> manufacturerReportList = manufacturerServiceClient.getAllManufacturerReport();
        return new ResponseEntity<List<ManufacturerReport>>(manufacturerReportList, HttpStatus.OK);
    }

    @GetMapping("/manufacturers/{idManuafacturer}") // http://localhost:9094/api/reports/manufacturers/
    @RateLimiter(name = "default")
    public ResponseEntity<ManufacturerReport> getManufacturerById(@PathVariable("idManuafacturer") int idManuafacturer) {
        logger.info("************ This is API call method ************");
        ManufacturerReport manufacturerReport = manufacturerServiceClient.getManufacturerReportById(idManuafacturer);
        return new ResponseEntity<ManufacturerReport>(manufacturerReport, HttpStatus.OK);
    }

    @GetMapping("/phones") // http://localhost:9094/api/reports/phones
    @RateLimiter(name = "default")
    public ResponseEntity<List<PhoneReport>> getAllPhoneReport() {
        List<PhoneReport> phoneReportList = phoneServiceClient.getAllPhoneReport();
        return new ResponseEntity<List<PhoneReport>>(phoneReportList, HttpStatus.OK);
    }

    @GetMapping("/phones/{idPhone}") // http://localhost:9094/api/reports/phones/
    @RateLimiter(name = "default")
    public ResponseEntity<PhoneReport> getPhoneById(@PathVariable("idPhone") int idPhone) {
        PhoneReport phoneReport = phoneServiceClient.getPhoneReportById(idPhone);
        return new ResponseEntity<PhoneReport>(phoneReport, HttpStatus.OK);
    }

    @GetMapping("/ratelimiter")
    @RateLimiter(name = "default")
    public ResponseEntity<String> rateLimiter() {
        System.out.println("############ This is ratelimiter demo ############");
        return new ResponseEntity<String>("This is Ratelimiter Demo method", HttpStatus.OK);
    }

    @GetMapping("/timelimiter") //http://localhost:9094/api/reports/timelimiter
    @TimeLimiter(name = "default")
    public CompletableFuture<Void> timeLimiter() {

        return CompletableFuture.runAsync(runnable);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("Hello World");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}
