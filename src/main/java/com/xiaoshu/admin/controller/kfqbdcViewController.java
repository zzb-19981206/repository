package com.xiaoshu.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoshu.common.annotation.SysLog;

@Controller
@RequestMapping("/admin/kfqbdc")
public class kfqbdcViewController {
	
	@GetMapping("kfqbdcysj")
    @SysLog("跳转系统开发区不动产已收件")
    public String kfqbdcysj(){
        return "admin/kfqbdc/kfqbdcysj";
    }
	
	@GetMapping("kfqbdcytj")
    @SysLog("跳转系统开发区不动产已收件")
    public String kfqbdcytj(){
        return "admin/kfqbdc/kfqbdcytj";
    }
	
	@GetMapping("kfqbdcywc")
    @SysLog("跳转系统开发区不动产已收件")
    public String kfqbdcywc(){
        return "admin/kfqbdc/kfqbdcywc";
    }
	
	@GetMapping("sjd")
    @SysLog("新建业务")
    public String sjd(){
        return "admin/kfqUpdate/sjd";
    }
	
	@GetMapping("/ywall/deleAll")
	public String getDeleteAll() {
		return "admin/kfqbdc/deleAll";
	}

}
