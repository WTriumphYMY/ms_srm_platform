package cn.edu.nwpu.ms_srm_platform.controller;

import cn.edu.nwpu.ms_srm_platform.client.ExpFilterClient;
import cn.edu.nwpu.ms_srm_platform.client.ExpManageClient;
import cn.edu.nwpu.ms_srm_platform.domain.SrmExperiment;
import cn.edu.nwpu.ms_srm_platform.domain.ToolsList;
import cn.edu.nwpu.ms_srm_platform.domain.User;
import cn.edu.nwpu.ms_srm_platform.repository.ToolsListRepository;
import cn.edu.nwpu.ms_srm_platform.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName IndexController
 * @Author: wkx
 * @Date: 2019/4/15 10:42
 * @Version: v1.0
 * @Description:
 */
@Controller
public class IndexController {

    @Autowired
    private ToolsListRepository toolsListRepository;
    @Autowired
    private ExpManageClient expManageClient;
    @Autowired
    private ExpFilterClient expFilterClient;
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(){
        return "balslogin";
    }

    @GetMapping("/platform")
    public String showIndex(Model model, HttpServletRequest request){
        Object user = request.getSession().getAttribute("user");
        if (user == null){
            return "redirect:/login";
        }
        List<ToolsList> toolsList = toolsListRepository.findAll();
        model.addAttribute("toolsList", toolsList);
        return "index";
    }

    /**
     * 返回各个计算模块的视图
     * @param id 模块id
     * @param model
     * @return
     */
    @GetMapping("/module/{id}")
    public String showModule(@PathVariable Integer id, Model model){
        ToolsList tool = toolsListRepository.getOne(id);
        List<ToolsList> toolsList = toolsListRepository.findAll();
        model.addAttribute("toolsList", toolsList);
        model.addAttribute("tool", tool);
        return "forward:/"+tool.getToolAlias();
    }

    @GetMapping("/expmanage")
    public String showExpManage(Model model){
        model.addAttribute("expData", expManageClient.getAllExp());
        return "expmanage";
    }

    @GetMapping("/expfilter")
    public String showExpFilter(Model model){
        model.addAttribute("srmNames", expManageClient.getAllSrmName());
        return "expfilter";
    }

    @GetMapping("/expfilter/{srmName}")
    public String selectedExpFilter(@PathVariable String srmName, Model model){
        ToolsList tool = toolsListRepository.findByToolAlias("expfilter");
        List<ToolsList> toolsList = toolsListRepository.findAll();
        model.addAttribute("toolsList", toolsList);
        model.addAttribute("tool", tool);
        SrmExperiment srmExperiment = expManageClient.getExpByName(srmName);
        String[] tStrArr = srmExperiment.getExpTime().split(",");
        String[] pStrArr = srmExperiment.getExpPressure().split(",");
        String[] fStrArr = srmExperiment.getExpForce().split(",");
        double[] pArr = new double[pStrArr.length];
        double[] fArr = new double[fStrArr.length];
        for (int i = 0; i < pStrArr.length; i++) {
            pArr[i] = Double.parseDouble(pStrArr[i]);
            fArr[i] = Double.parseDouble(fStrArr[i]);
        }
        List<Double> pSmoothList = expFilterClient.getSmoothData(pArr);
        List<Double> fSmoothList = expFilterClient.getSmoothData(fArr);
        model.addAttribute("timeSeries", Arrays.asList(tStrArr));
        model.addAttribute("rawPSeries", Arrays.asList(pStrArr));
        model.addAttribute("rawFSeries", Arrays.asList(fStrArr));
        model.addAttribute("smoothPSeries", pSmoothList);
        model.addAttribute("smoothFSeries", fSmoothList);
        return "expfilter";
    }

    @GetMapping("/entirebals")
    public String showEntirebals(){
        return "entirebals";
    }

    @PostMapping("/login")
    public String login(User user, HttpServletRequest request, Model model){
        if (userService.login(user)){
            request.getSession().setAttribute("user", user);
            return "redirect:/platform";
        }else {
            model.addAttribute("message", "用户名或密码错误");
            return "balslogin";
        }
    }
}
