package com.xiaoshu.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaoshu.common.annotation.SysLog;

@Controller
@RequestMapping("/admin/kfqfg")	
public class kfqfgViewController {
	
	@GetMapping("kfqfgysj")
    @SysLog("跳转系统开发区不动产已收件")
    public String kfqbdcysj(){
        return "admin/kfqbdc/kfqfgysj";
    }
	
	@GetMapping("kfqfgytj")
    @SysLog("跳转系统开发区不动产已收件")
    public String kfqbdcytj(){
        return "admin/kfqbdc/kfqfgytj";
    }
	
	@GetMapping("kfqfgywc")
    @SysLog("跳转系统开发区不动产已收件")
    public String kfqbdcywc(){
        return "admin/kfqbdc/kfqfgywc";
    }

}
