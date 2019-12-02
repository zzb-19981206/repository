package com.xiaoshu.admin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.thymeleaf.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.xiaoshu.admin.entity.User;
import com.xiaoshu.admin.model.Bdcquery;
import com.xiaoshu.admin.model.DicItem;
import com.xiaoshu.admin.model.FjEntity; 
import com.xiaoshu.admin.model.Qlrxx; 
import com.xiaoshu.admin.model.Slxx; 
import com.xiaoshu.admin.model.Ywrxx;
import com.xiaoshu.admin.service.kfqMainSwService;
import com.xiaoshu.admin.service.UserService;
import com.xiaoshu.admin.service.db2.DicItemService;
import com.xiaoshu.admin.service.db2.KfqMainService;
import com.xiaoshu.common.annotation.SysLog;
import com.xiaoshu.common.config.MySysUser;
import com.xiaoshu.common.util.DatatablesView;
import com.xiaoshu.common.util.DateUtils;
import com.xiaoshu.common.util.DictionaryUtils;
import com.xiaoshu.common.util.FileUtil;

@RestController
@RequestMapping("admin/system/kfqUpadte")
public class kfqTsController {
	@Autowired
	private kfqMainSwService shMainSwService;
	@Autowired
	private UserService userService;
	@Autowired
	private KfqMainService shMainService;
	@Autowired
	private DicItemService dicItemService;
	/**
	 * 不动产首页
	 */
	
	@SysLog("在主页面显示原始数据（新）---管理员页面 ")
	@PostMapping("mainTz")
	@ResponseBody
	public String mainTz(@RequestParam(name = "start", required = false) Integer start,
			@RequestParam(name = "length", required = false) Integer length,
			@RequestParam(name = "draw", required = false) Integer draw,
			@RequestParam(name = "slbh", required = false) String slbh,
			@RequestParam(name = "zl", required = false) String zl,
			@RequestParam(required = false, name = "starttime") String starttime,
			@RequestParam(required = false, name = "endtime") String endtime) throws ParseException {
		DatatablesView<Slxx> dataTable = new DatatablesView<Slxx>();
		User user = userService.getById(MySysUser.id());

		Slxx test = new Slxx();
		test.setStart(start);
		test.setLength(length);
		test.setSlbh(slbh);
//		test.setQuerymc(user.getLoginName());
		test.setFwzl(zl);
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
		
		List<Slxx> list = shMainSwService.selectMain(test);
		List<Slxx> data = new ArrayList<>();
		for(Slxx slxx:list) {
			slxx.setSlbh(StringUtils.toString(slxx.getSlbh()));
			slxx.setBdczh(StringUtils.toString(slxx.getBdczh()));
			slxx.setQlrmc(StringUtils.toString(slxx.getQlrmc()));
			slxx.setFwzl(StringUtils.toString(slxx.getFwzl()));
			slxx.setQuerymc(StringUtils.toString(slxx.getQuerymc()));
			slxx.setQueryrq(StringUtils.toString(slxx.getQueryrq()));
			data.add(slxx);
		}
		// 处理收件状态
		int total = shMainSwService.findMainCount(test);
		dataTable.setDraw(draw);
		dataTable.setData(data);
		dataTable.setRecordsTotal(total);
		dataTable.setLength(length);
		String data2 = JSON.toJSONString(dataTable);
		return data2;
	}
	
	@SysLog("在主页面显示原始数据（新）---不动产页面 ")
	@PostMapping("mainbdcTz")
	@ResponseBody
	public String mainbdcTz(@RequestParam(name = "start", required = false) Integer start,
			@RequestParam(name = "length", required = false) Integer length,
			@RequestParam(name = "draw", required = false) Integer draw,
			@RequestParam(name = "slbh", required = false) String slbh,
			@RequestParam(name = "zl", required = false) String zl,
			@RequestParam(required = false, name = "starttime") String starttime,
			@RequestParam(required = false, name = "endtime") String endtime) throws ParseException {
		DatatablesView<Slxx> dataTable = new DatatablesView<Slxx>();
		User user = userService.getById(MySysUser.id());
		Slxx test = new Slxx();
		test.setStart(start);
		test.setLength(length);
		test.setSlbh(slbh);
		test.setFwzl(zl);
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
		List<Slxx> list = shMainSwService.selectMain(test);
		List<Slxx> data = new ArrayList<>();
		for(Slxx slxx:list) {
			slxx.setSlbh(StringUtils.toString(slxx.getSlbh()));
			slxx.setBdczh(StringUtils.toString(slxx.getBdczh()));
			slxx.setQlrmc(StringUtils.toString(slxx.getQlrmc()));
			slxx.setFwzl(StringUtils.toString(slxx.getFwzl()));
			slxx.setQuerymc(StringUtils.toString(slxx.getQuerymc()));
			slxx.setQueryrq(StringUtils.toString(slxx.getQueryrq()));
			data.add(slxx);
		}
		int total = shMainSwService.findMainCount(test);
		dataTable.setDraw(draw);
		dataTable.setData(data);
		dataTable.setRecordsTotal(total);
		dataTable.setLength(length);
		String data2 = JSON.toJSONString(dataTable);
		return data2;
		
		
	}
	
	@SysLog("在主页面显示原始数据（新）---不动产页面 ")
	@PostMapping("mainswTz")
	@ResponseBody
	public String mainswTz(@RequestParam(name = "start", required = false) Integer start,
			@RequestParam(name = "length", required = false) Integer length,
			@RequestParam(name = "draw", required = false) Integer draw,
			@RequestParam(name = "slbh", required = false) String slbh,
			@RequestParam(name = "zl", required = false) String zl,
			@RequestParam(required = false, name = "starttime") String starttime,
			@RequestParam(required = false, name = "endtime") String endtime) throws ParseException {
		DatatablesView<Slxx> dataTable = new DatatablesView<Slxx>();
		User user = userService.getById(MySysUser.id());
		Slxx test = new Slxx();
		test.setStart(start);
		test.setLength(length);
		test.setSlbh(slbh);
		test.setFwzl(zl);
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
		List<Slxx> list = shMainSwService.selectMain(test);
		List<Slxx> data = new ArrayList<>();
		for(Slxx slxx:list) {
			slxx.setSlbh(StringUtils.toString(slxx.getSlbh()));
			slxx.setBdczh(StringUtils.toString(slxx.getBdczh()));
			slxx.setQlrmc(StringUtils.toString(slxx.getQlrmc()));
			slxx.setFwzl(StringUtils.toString(slxx.getFwzl()));
			slxx.setQuerymc(StringUtils.toString(slxx.getQuerymc()));
			slxx.setQueryrq(StringUtils.toString(slxx.getQueryrq()));
			data.add(slxx);
		}
		int total = shMainSwService.findMainCount(test);
		dataTable.setDraw(draw);
		dataTable.setData(data);
		dataTable.setRecordsTotal(total);
		dataTable.setLength(length);
		String data2 = JSON.toJSONString(dataTable);
		return data2;
		
	}
	@SysLog("在主页面显示原始数据（新）---不动产页面 ")
	@PostMapping("mainfgTz")
	@ResponseBody
	public String mainfgTz(@RequestParam(name = "start", required = false) Integer start,
			@RequestParam(name = "length", required = false) Integer length,
			@RequestParam(name = "draw", required = false) Integer draw,
			@RequestParam(name = "slbh", required = false) String slbh,
			@RequestParam(name = "zl", required = false) String zl,
			@RequestParam(required = false, name = "starttime") String starttime,
			@RequestParam(required = false, name = "endtime") String endtime) throws ParseException {
		DatatablesView<Slxx> dataTable = new DatatablesView<Slxx>();
		User user = userService.getById(MySysUser.id());
		Slxx test = new Slxx();
		test.setStart(start);
		test.setLength(length);
		test.setSlbh(slbh);
		test.setFwzl(zl);
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
		List<Slxx> list = shMainSwService.selectMain(test);
		List<Slxx> data = new ArrayList<>();
		for(Slxx slxx:list) {
			slxx.setSlbh(StringUtils.toString(slxx.getSlbh()));
			slxx.setBdczh(StringUtils.toString(slxx.getBdczh()));
			slxx.setQlrmc(StringUtils.toString(slxx.getQlrmc()));
			slxx.setFwzl(StringUtils.toString(slxx.getFwzl()));
			slxx.setQuerymc(StringUtils.toString(slxx.getQuerymc()));
			slxx.setQueryrq(StringUtils.toString(slxx.getQueryrq()));
			data.add(slxx);
		}
		int total = shMainSwService.findMainCount(test);
		dataTable.setDraw(draw);
		dataTable.setData(data);
		dataTable.setRecordsTotal(total);
		dataTable.setLength(length);
		String data2 = JSON.toJSONString(dataTable);
		return data2;
		
	}
	
	@PostMapping("mainSjd")
	@ResponseBody
	public ModelAndView findAllList(String slbh){
		ModelAndView view = new ModelAndView(new MappingJackson2JsonView());
		//字典
				DicItem item=new DicItem();
				//权属信息查询
				Slxx test = new Slxx();
				test.setSlbh(slbh);
		   		List<Slxx> qsxxList = shMainService.selectQsxxTS(test);
		   		List<Slxx> qsxxList1 = new ArrayList<Slxx>();
		   		for(Slxx i:qsxxList) {
		   			item.setDicname("房屋结构");
		   			item.setItemval(i.getFwjg());
		   			String fwjg = dicItemService.itemName(item);
		   			i.setFwjg(fwjg);
		   			
		   			item.setDicname("土地权利类型");
		   			item.setItemval(i.getQllx());
		   			String qllx = dicItemService.itemName(item);
		   			i.setQllx(qllx);
		   			
		   			qsxxList1.add(i);
		   		}
		   		view.addObject("qsxxList", qsxxList1);
		   		//权利人信息查询
		   		Qlrxx qlrTs = new Qlrxx();
				qlrTs.setQlrslbh(slbh);
				List<Qlrxx> qlrList = shMainService.selectQlr(qlrTs);		
				List<Qlrxx> qlrList1 = new ArrayList<Qlrxx>();
		   		for(Qlrxx j:qlrList) {
		   			item.setDicname("证件类型");
		   			item.setItemval(j.getQlrzjzl());
		   			String qlrzjzl = dicItemService.itemName(item);
		   			j.setQlrzjzl(qlrzjzl);;
		   			
		   			item.setDicname("共有方式");
		   			item.setItemval(j.getQlrgyfs());
		   			String qlrgyfs = dicItemService.itemName(item);
		   			j.setQlrgyfs(qlrgyfs);
		   			
		   			qlrList1.add(j);
		   		}
				view.addObject("qlrList", qlrList1);
				//义务人信息查询
				Ywrxx ywrTs = new Ywrxx();
				ywrTs.setYwrslbh(slbh);
				List<Ywrxx> ywrList = shMainService.selectYwr(ywrTs);
				List<Ywrxx> ywrList1 = new ArrayList<Ywrxx>();
		   		for(Ywrxx g:ywrList) {
		   			item.setDicname("证件类型");
		   			item.setItemval(g.getYwrzjzl());
		   			String ywrzjzl = dicItemService.itemName(item);
		   			g.setYwrzjzl(ywrzjzl);
		   			
		   			ywrList1.add(g);
		   		}	
				view.addObject("ywrList", ywrList);
				
				//附件信息查询
				FjEntity fjEntity=new FjEntity();
				fjEntity.setSlbh(slbh);
		   		List<FjEntity> fjlist= shMainService.fjxx(fjEntity);
		   		view.addObject("fjlist", fjlist);
				return view;
	}
	
	/**
	 * 将三河原始库数据保存到独立数据库mysql
	 */

	@PostMapping("/insertMysql")
	public ModelAndView insertMysql(String slbh) {
		ModelAndView view = new ModelAndView(new MappingJackson2JsonView());
		User user = userService.getById(MySysUser.id());
		//字典
		DicItem item=new DicItem();
		// 处理日期
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 是否插入成功
		String msg = "";
		// 权属
		Slxx test = new Slxx();
		test.setSlbh(slbh);
		int a = shMainSwService.selectYwh(test);

		if (a < 1) {
			List<Slxx> qsxxList = shMainService.selectQsxxTS(test);
			for (Slxx i : qsxxList) {
				i.setQuerymc(user.getLoginName());
				i.setQueryrq(sdf.format(date));
				i.setYwzt("0");
				i.setZt("0");
				
				item.setDicname("房屋结构");
	   			item.setItemval(i.getFwjg());
	   			String fwjg = dicItemService.itemName(item);
	   			i.setFwjg(fwjg);
	   			
	   			item.setDicname("土地权利类型");
	   			item.setItemval(i.getQllx());
	   			String qllx = dicItemService.itemName(item);
	   			i.setQllx(qllx);
				
				
				shMainSwService.insertSlxx(i);
			}
			// 权利人
			Qlrxx testQLlr = new Qlrxx();
			testQLlr.setQlrslbh(slbh);
			List<Qlrxx> qlrList = shMainService.selectQlr(testQLlr);
			for (Qlrxx j : qlrList) {
				item.setDicname("证件类型");
	   			item.setItemval(j.getQlrzjzl());
	   			String qlrzjzl = dicItemService.itemName(item);
	   			j.setQlrzjzl(qlrzjzl);;
	   			
	   			item.setDicname("共有方式");
	   			item.setItemval(j.getQlrgyfs());
	   			String qlrgyfs = dicItemService.itemName(item);
	   			j.setQlrgyfs(qlrgyfs);
	   			System.out.println("插入权利人===="+j.getQlr());
				shMainSwService.insertQlrxx(j);
			}
			// 义务人
			Ywrxx testYwr = new Ywrxx();
			testYwr.setYwrslbh(slbh);
			List<Ywrxx> ywrList = shMainService.selectYwr(testYwr);
			for (Ywrxx k : ywrList) {
				item.setDicname("证件类型");
	   			item.setItemval(k.getYwrzjzl());
	   			String ywrzjzl = dicItemService.itemName(item);
	   			k.setYwrzjzl(ywrzjzl); 
	   			System.out.println("插入义务人===="+k.getYwrqlr());
				shMainSwService.insertYwrxx(k);
			}
			msg = "数据更新成功";
		}
		view.addObject("msg", msg);
		return view;
	}

	/**
	 * 将不动产状态提交税务
	 */
	@PostMapping("/upDateSwZt")
	public ModelAndView updateSwzt(String slbh,String tsr){
		ModelAndView view = new ModelAndView(new MappingJackson2JsonView());
		Slxx shMain = new Slxx();
		shMain.setSlbh(slbh);
		shMain.setYwzt("1");
		shMain.setYwSwzt("0");
		shMain.setYwFgzt("2");

		shMain.setSwblr(tsr);
		boolean msg = shMainSwService.swUpdatefje(shMain);
		view.addObject("msg", msg);
		return view;
	}
	/**
	 * 结束流程
	 * */
	@PostMapping("/upDateywZt")
	public ModelAndView updateywzt(String slbh){
		ModelAndView view = new ModelAndView(new MappingJackson2JsonView());
		Slxx shMain = new Slxx();
		shMain.setSlbh(slbh);
		shMain.setYwzt("2");
		shMain.setYwSwzt("2");
		boolean msg = shMainSwService.swUpdatefje(shMain);
		view.addObject("msg", msg);
		return view;
	}
	/**
	 * 买方税务金额
	 */

	@PostMapping("/updateSfje")
	public ModelAndView swUpdate(String ywh, String mfje,String smfje) {
		ModelAndView view = new ModelAndView(new MappingJackson2JsonView());
		User user = userService.getById(MySysUser.id());
		Slxx shMain = new Slxx();
		shMain.setSlbh(ywh);
		shMain.setMfje(mfje);
		shMain.setSmfje(smfje);
		shMain.setYwSwzt("2");
		shMain.setYwFgzt("2");
		shMain.setSwblrq(DateUtils.getDate());
		boolean msg = shMainSwService.swUpdateMfje(shMain);
		view.addObject("msg", msg);
		return view;
	}
	
	

}
