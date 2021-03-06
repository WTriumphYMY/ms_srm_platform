package cn.edu.nwpu.ms_srm_platform.client;

import cn.edu.nwpu.ms_srm_platform.domain.SrmExperiment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName ExpManageClient
 * @Author: wkx
 * @Date: 2019/5/15 14:50
 * @Version: v1.0
 * @Description:
 */
@FeignClient(value = "ms-srm-exp-manage")
public interface ExpManageClient {
    @PostMapping("/getExpByName")
    SrmExperiment getExpByName(@RequestParam String srmName);

    @PostMapping("/findAllExp")
    List<SrmExperiment> getAllExp();

    @PostMapping("/findAllSrmName")
    List<String> getAllSrmName();
}
