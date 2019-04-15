package cn.edu.nwpu.ms_srm_platform.client;

import cn.edu.nwpu.ms_srm_platform.domain.SrmVO;
import cn.edu.nwpu.ms_srm_platform.utils.SpringMultipartEncoder;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


/**
 * @InterfaceName BalsZeroClient
 * @Author: wkx
 * @Date: 2019/4/15 16:33
 * @Version: v1.0
 * @Description:
 */
@FeignClient(value = "ms-srm-balszero", configuration = BalsZeroClient.MultipartSupportConfig.class)
public interface BalsZeroClient {
//TODO: feign上传文件及传递对象问题待解决
    @PostMapping(value = "/module/bals", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String getBalsResult(SrmVO srmVO, @RequestParam("srmName") String srmName,
                         @RequestPart("igGrain") MultipartFile[] grains);

    @PostMapping("/module/bals/blur")
    SrmVO showSrmParas(@RequestParam("srmName") String srmName);

    @Configuration
    class MultipartSupportConfig {
        @Autowired
        private ObjectFactory<HttpMessageConverters> messageConverters;
        @Bean
        public Encoder feignEncoder() {
            return new SpringMultipartEncoder(new SpringEncoder(messageConverters));
        }
    }
}
