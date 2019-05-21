package cn.edu.nwpu.ms_srm_platform.controller;

import cn.edu.nwpu.ms_srm_platform.client.BalsZeroClient;
import cn.edu.nwpu.ms_srm_platform.domain.SrmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/bals/blur")
    public SrmVO showParams(String srmName){
        SrmVO srmVO = balsZeroClient.showSrmParas(srmName);
        return srmVO;
    }
}
