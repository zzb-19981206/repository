package com.xiaoshu.admin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
import com.xiaoshu.common.config.MySysUser;
import com.xiaoshu.common.util.DatatablesView;

@RestController
@RequestMapping("admin/kfqfg/res")
public class kfqfgController {

	@Autowired
	private kfqMainSwService shMainSwService;
	@Autowired
	private UserService userService;
	@Autowired
	private KfqMainService shMainService;
	
	
	@PostMapping("kfqfgysj")
	@ResponseBody
	public String shfgysj(@RequestParam(name = "start", required = false) Integer start,
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
		test.setYwFgzt("0");
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
		List<Slxx> list = shMainSwService.kfqbdcfgList(test);
		List<Slxx> data = new ArrayList<>();
		for(Slxx slxx:list) {
			slxx.setSlbh(StringUtils.toString(slxx.getSlbh()));
			slxx.setBdczh(StringUtils.toString(slxx.getBdczh()));
			slxx.setQlrmc(StringUtils.toString(slxx.getQlrmc()));
			slxx.setZl(StringUtils.toString(slxx.getFwzl()));
			slxx.setQuerymc(StringUtils.toString(slxx.getQuerymc()));
			slxx.setQueryrq(StringUtils.toString(slxx.getQueryrq()));
			slxx.setYwFgzt(StringUtils.toString(slxx.getYwFgzt()));
			data.add(slxx);
		}
		int total = shMainSwService.findbdcfgCountAllList(test);
		dataTable.setDraw(draw);
		dataTable.setData(data);
		dataTable.setRecordsTotal(total);
		dataTable.setLength(length);
		String data2 = JSON.toJSONString(dataTable);
		return data2;
	}
	
	@PostMapping("kfqfgytj")
	@ResponseBody
	public String shfgytj(@RequestParam(name = "start", required = false) Integer start,
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
		test.setYwFgzt("1");
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
		List<Slxx> list = shMainSwService.kfqbdcfgList(test);
		List<Slxx> data = new ArrayList<>();
		for(Slxx slxx:list) {
			slxx.setSlbh(StringUtils.toString(slxx.getSlbh()));
			slxx.setBdczh(StringUtils.toString(slxx.getBdczh()));
			slxx.setQlrmc(StringUtils.toString(slxx.getQlrmc()));
			slxx.setZl(StringUtils.toString(slxx.getFwzl()));
			slxx.setQuerymc(StringUtils.toString(slxx.getQuerymc()));
			slxx.setQueryrq(StringUtils.toString(slxx.getQueryrq()));
			slxx.setYwFgzt(StringUtils.toString(slxx.getYwFgzt()));
			data.add(slxx);
		}
		int total = shMainSwService.findbdcfgCountAllList(test);
		dataTable.setDraw(draw);
		dataTable.setData(data);
		dataTable.setRecordsTotal(total);
		dataTable.setLength(length);
		String data2 = JSON.toJSONString(dataTable);
		return data2;
	}
	

	@PostMapping("kfqfgywc")
	@ResponseBody
	public String shfgywc(@RequestParam(name = "start", required = false) Integer start,
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
		test.setYwFgzt("2");
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
		List<Slxx> list = shMainSwService.kfqbdcfgList(test);
		List<Slxx> data = new ArrayList<>();
		for(Slxx slxx:list) {
			slxx.setSlbh(StringUtils.toString(slxx.getSlbh()));
			slxx.setBdczh(StringUtils.toString(slxx.getBdczh()));
			slxx.setQlrmc(StringUtils.toString(slxx.getQlrmc()));
			slxx.setZl(StringUtils.toString(slxx.getFwzl()));
			slxx.setQuerymc(StringUtils.toString(slxx.getQuerymc()));
			slxx.setQueryrq(StringUtils.toString(slxx.getQueryrq()));
			slxx.setYwFgzt(StringUtils.toString(slxx.getYwFgzt()));
			data.add(slxx);
		}
		int total = shMainSwService.findbdcfgCountAllList(test);
		dataTable.setDraw(draw);
		dataTable.setData(data);
		dataTable.setRecordsTotal(total);
		dataTable.setLength(length);
		String data2 = JSON.toJSONString(dataTable);
		return data2;
	}


}
