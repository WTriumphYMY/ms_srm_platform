package cn.edu.nwpu.ms_srm_platform.controller;

import cn.edu.nwpu.ms_srm_platform.client.BalsZeroClient;
import cn.edu.nwpu.ms_srm_platform.domain.SrmVO;
import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @ClassName BalsController
 * @Author: wkx
 * @Date: 2019/4/15 16:34
 * @Version: v1.0
 * @Description:
 */
@RestController("/platform")
public class BalsController {
    @Autowired
    private BalsZeroClient balsZeroClient;

    @PostMapping("/bals")
    public String calculateBalsZero(SrmVO srmVO, @RequestParam("srmName") String srmName,
                                    @RequestPart("grains") MultipartFile[] grains){
        String balsResult = balsZeroClient.getBalsResult(srmVO, srmName, grains);
        return balsResult;
    }

    @PostMapping("/bals/blur")
    public SrmVO showParams(String srmName){
        SrmVO srmVO = balsZeroClient.showSrmParas(srmName);
        return srmVO;
    }
}
