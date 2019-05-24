//package cn.edu.nwpu.ms_srm_platform.filters;
//
//import cn.edu.nwpu.ms_srm_platform.client.UserClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @ClassName LoginInterceptor
// * @Author: wkx
// * @Date: 2019/5/22 16:33
// * @Version: v1.0
// * @Description: 登陆拦截器
// */
//public class LoginInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    private UserClient userClient;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token = (String) request.getSession().getAttribute("token");
//        if (token == null || token == ""){
//            response.sendRedirect(userClient.getUserLoginUrl()+"/platformlogin.html");
//            return false;
//        }
//        return true;
//    }
//}
