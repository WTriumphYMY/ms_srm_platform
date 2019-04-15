package cn.edu.nwpu.ms_srm_platform.controller;

import cn.edu.nwpu.ms_srm_platform.domain.ToolsList;
import cn.edu.nwpu.ms_srm_platform.repository.ToolsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/platform")
    public String showIndex(Model model){
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
        return tool.getToolAlias();
    }
}
