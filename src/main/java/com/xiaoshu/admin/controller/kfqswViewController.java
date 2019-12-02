package com.xiaoshu.admin.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaoshu.common.annotation.SysLog;

@Controller
@RequestMapping("/admin/kfqsw")
public class kfqswViewController {
	
	@GetMapping("kfqswysj")
    @SysLog("跳转系统开发区税务已收件")
    public String kfqbdcysj(){
        return "admin/kfqbdc/kfqswysj";
    }
	
	@GetMapping("kfqswywj")
    @SysLog("跳转系统开发区税务已提交")
    public String kfqbdcytj(){
        return "admin/kfqbdc/kfqswytj";
    }
	
	@GetMapping("kfqswywc")
    @SysLog("跳转系统开发区税务已完成")
    public String kfqbdcywc(){
        return "admin/kfqbdc/kfqswywc";
    }


}