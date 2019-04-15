package cn.edu.nwpu.ms_srm_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class MsSrmPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsSrmPlatformApplication.class, args);
    }

}
