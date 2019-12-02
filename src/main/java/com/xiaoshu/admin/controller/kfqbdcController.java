package com.xiaoshu.admin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.xiaoshu.admin.entity.User; 
import com.xiaoshu.admin.model.Slxx;
import com.xiaoshu.admin.service.kfqMainSwService;
import com.xiaoshu.admin.service.UserService;
import com.xiaoshu.admin.service.db2.KfqMainService;
import com.xiaoshu.common.annotation.SysLog;
import com.xiaoshu.common.config.MySysUser;
import com.xiaoshu.common.util.DatatablesView;

@RestController
@RequestMapping("admin/kfqbdc/res")
public class kfqbdcController {

	@Autowired
	private kfqMainSwService shMainSwService;
	@Autowired
	private UserService userService;
	@Autowired
	private KfqMainService shMainService;

	@PostMapping("kfqbdcysj")
	@ResponseBody
	public String shbdcysj(@RequestParam(name = "start", required = false) Integer start,
			@RequestParam(name = "length", required = false) Integer length,
			@RequestParam(name = "draw", required = false) Integer draw,
			@RequestParam(name = "slbh", required = false) String slbh,
			@RequestParam(name = "zl", required = false) String zl,
			@RequestParam(name = "starttime", required = false) String starttime,
			@RequestParam(name = "endtime", required = false) String endtime) throws ParseException {
		DatatablesView<Slxx> dataTable = new DatatablesView<Slxx>();
		User user = userService.getById(MySysUser.id());
		Slxx test = new Slxx();
		test.setStart(start);
		test.setLength(length);
		test.setSlbh(slbh);
		test.setYwzt("0");
		test.setZl(zl);
//		test.setQuerymc(user.getLoginName());
		if(starttime!=null && starttime.length()!=0) {
			starttime = starttime+" 00:00:00";
			System.out.println(starttime);
			test.setStarttime(starttime);
		}
		if(endtime!=null && endtime.length()!=0) {
			endtime = endtime+" 23:59:59";
			System.out.println(endtime);
			test.setEndtime(endtime);
		}
		List<Slxx> list = shMainSwService.kfqbdcAllList(test);
		 
		List<Slxx> data = new ArrayList<>();
		for(Slxx slxx:list) {
			slxx.setSlbh(StringUtils.toString(slxx.getSlbh()));
			slxx.setBdczh(StringUtils.toString(slxx.getBdczh()));
			slxx.setQlrmc(StringUtils.toString(slxx.getQlrmc()));
			slxx.setZl(StringUtils.toString(slxx.getFwzl()));
			slxx.setQuerymc(StringUtils.toString(slxx.getQuerymc()));
			slxx.setQueryrq(StringUtils.toString(slxx.getQueryrq()));
			data.add(slxx);
		}
		int total = shMainSwService.findCountSwAllList(test);
		dataTable.setDraw(draw);
		dataTable.setData(data);
		dataTable.setRecordsTotal(total);
		dataTable.setLength(length);
		String data2 = JSON.toJSONString(dataTable);
		return data2;
	}
	
	@PostMapping("kfqbdcytj")
	@ResponseBody
	public String shbdcytj(@RequestParam(name = "start", required = false) Integer start,
			@RequestParam(name = "length", required = false) Integer length,
			@RequestParam(name = "draw", required = false) Integer draw,
			@RequestParam(name = "slbh", required = false) String slbh,
			@RequestParam(name = "zl", required = false) String zl,
			@RequestParam(name = "starttime", required = false) String starttime,
			@RequestParam(name = "endtime", required = false) String endtime) throws ParseException {
		DatatablesView<Slxx> dataTable = new DatatablesView<Slxx>();
		User user = userService.getById(MySysUser.id());
		Slxx test = new Slxx();
		test.setStart(start);
		test.setLength(length);
		test.setSlbh(slbh);
		test.setYwzt("1");
		test.setZl(zl);
//		test.setQuerymc(user.getLoginName());
		
		if(starttime!=null && starttime.length()!=0) {
			starttime = starttime+" 00:00:00";
			System.out.println(starttime);
			test.setStarttime(starttime);
		}
		if(endtime!=null && endtime.length()!=0) {
			endtime = endtime+" 23:59:59";
			System.out.println(endtime);
			test.setEndtime(endtime);
		}
		List<Slxx> list = shMainSwService.kfqbdcAllList(test);
		
		List<Slxx> data = new ArrayList<>();
		for(Slxx slxx:list) {
			slxx.setSlbh(StringUtils.toString(slxx.getSlbh()));
			slxx.setBdczh(StringUtils.toString(slxx.getBdczh()));
			slxx.setQlrmc(StringUtils.toString(slxx.getQlrmc()));
			slxx.setZl(StringUtils.toString(slxx.getFwzl()));
			slxx.setQuerymc(StringUtils.toString(slxx.getQuerymc()));
			slxx.setQueryrq(StringUtils.toString(slxx.getQueryrq()));
			data.add(slxx);
		}
		int total = shMainSwService.findCountSwAllList(test);
		dataTable.setDraw(draw);
		dataTable.setData(data);
		dataTable.setRecordsTotal(total);
		dataTable.setLength(length);
		String data2 = JSON.toJSONString(dataTable);
		return data2;
	}
	

	@PostMapping("kfqbdcywc")
	@ResponseBody
	public String shbdcywc(@RequestParam(name = "start", required = false) Integer start,
			@RequestParam(name = "length", required = false) Integer length,
			@RequestParam(name = "draw", required = false) Integer draw,
			@RequestParam(name = "slbh", required = false) String slbh,
			@RequestParam(name = "zl", required = false) String zl,
			@RequestParam(name = "starttime", required = false) String starttime,
			@RequestParam(name = "endtime", required = false) String endtime) throws ParseException {
		DatatablesView<Slxx> dataTable = new DatatablesView<Slxx>();
		User user = userService.getById(MySysUser.id());
		Slxx test = new Slxx();
		test.setStart(start);
		test.setLength(length);
		test.setSlbh(slbh);
		test.setYwzt("2");
		test.setZl(zl);
//		test.setQuerymc(user.getLoginName());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(starttime!=null && starttime.length()!=0) {
			starttime = starttime+" 00:00:00";
			System.out.println(starttime);
			test.setStarttime(starttime);
		}
		if(endtime!=null && endtime.length()!=0) {
			endtime = endtime+" 23:59:59";
			System.out.println(endtime);
			test.setEndtime(endtime);
		}
		List<Slxx> list = shMainSwService.kfqbdcAllList(test);
		List<Slxx> data = new ArrayList<>();
		for(Slxx slxx:list) {
			slxx.setSlbh(StringUtils.toString(slxx.getSlbh()));
			slxx.setBdczh(StringUtils.toString(slxx.getBdczh()));
			slxx.setQlrmc(StringUtils.toString(slxx.getQlrmc()));
			slxx.setZl(StringUtils.toString(slxx.getFwzl()));
			slxx.setQuerymc(StringUtils.toString(slxx.getQuerymc()));
			slxx.setQueryrq(StringUtils.toString(slxx.getQueryrq()));
			data.add(slxx);
		}
		int total = shMainSwService.findCountSwAllList(test);
		dataTable.setDraw(draw);
		dataTable.setData(data);
		dataTable.setRecordsTotal(total);
		dataTable.setLength(length);
		String data2 = JSON.toJSONString(dataTable);
		return data2;
	}

}
