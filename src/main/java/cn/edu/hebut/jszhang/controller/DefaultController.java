package cn.edu.hebut.jszhang.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.hebut.jszhang.domain.SignInInfo;
import cn.edu.hebut.jszhang.domain.Student;
import cn.edu.hebut.jszhang.service.SignInServiceInterface;
import cn.edu.hebut.jszhang.service.StudentServiceInterface;
import cn.edu.hebut.jszhang.util.IpUtil;

@Controller
public class DefaultController {

    @Autowired
    SignInServiceInterface signInService;

    @Autowired
    StudentServiceInterface studentService;

    @RequestMapping("/")
    String index() {
        return "index";
    }
    
    @RequestMapping("/download")
    String download(String file) {
        return "redirect:"+file;
    }
    @RequestMapping("/sign_in") 
    @ResponseBody
    String signIn(Student student, HttpServletRequest request){
        int result = studentService.checkStudent(student);
        SignInInfo signInInfo = new SignInInfo();
        signInInfo.setSno(student.getSno());
        signInInfo.setSaddress(IpUtil.getIpAddr(request));
        
        switch (result) {
            case 1:
                signInService.signIn(signInInfo);
                return "签到成功！";
            case 0:
                int i = studentService.addStudent(student);
                if(i > 0) {
                    signInService.signIn(signInInfo);
                    return "签到成功！";
                } else {
                    return "该学生未注册成功，签到失败！";
                }

            case -1:
                return "学号姓名不匹配，请重试！";
            default:
                return "签到失败！";
        }
    }
}