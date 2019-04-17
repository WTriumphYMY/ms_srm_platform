package cn.edu.nwpu.ms_srm_platform.client;

import cn.edu.nwpu.ms_srm_platform.domain.SrmVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * @InterfaceName BalsZeroClient
 * @Author: wkx
 * @Date: 2019/4/15 16:33
 * @Version: v1.0
 * @Description:
 */
@FeignClient(value = "ms-srm-balszero")
public interface BalsZeroClient {

    @PostMapping("/module/bals/blur")
    SrmVO showSrmParas(@RequestParam("srmName") String srmName);

}
