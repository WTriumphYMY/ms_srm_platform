package cn.edu.nwpu.ms_srm_platform.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @InterfaceName ExpFilterClient
 * @Author: wkx
 * @Date: 2019/5/16 20:40
 * @Version: v1.0
 * @Description:
 */
@FeignClient(value = "ms-srm-expfilter")
public interface ExpFilterClient {
    @PostMapping("/smoothData")
    List<Double> getSmoothData(@RequestBody double[] rawData);
}
