package com.xiaoshu.admin.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException; 
import java.util.ArrayList; 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView; 
 
import com.xiaoshu.admin.model.FjEntity; 
import com.xiaoshu.admin.model.Qlrxx; 
import com.xiaoshu.admin.model.Slxx; 
import com.xiaoshu.admin.model.Ywrxx;
import com.xiaoshu.admin.service.kfqMainSwService;
import com.xiaoshu.admin.service.db2.FjService;
import com.xiaoshu.admin.service.db2.KfqMainService;
import com.xiaoshu.admin.service.UserService;
import com.xiaoshu.common.config.FtpConfigurer;
import com.xiaoshu.common.config.MySysUser;
import com.xiaoshu.common.util.DictionaryUtils;
import com.xiaoshu.common.util.FileUtil;
import com.xiaoshu.common.util.FtpHandler;

@Controller
public class kfqViewController {

	@Autowired
	private kfqMainSwService shMainSwService;
	@Autowired
	private UserService userService;
	@Autowired
	private KfqMainService shMainService;
	
	@Autowired
	private FjService fjService;
	
	@Autowired
	private FtpConfigurer readConfig;
	
	/**
	 * 用管理员在不动产主页面通过业务号跳转到详情页面
	 * */
	@SuppressWarnings("unchecked")
	@GetMapping("mainList")
	public String mainList(ModelMap modelMap, String slbh){
		Slxx test = new Slxx();
		test.setSlbh(slbh);
		//附件信息
				FjEntity fjEntity=new FjEntity();
				fjEntity.setSlbh(slbh);
		   		List<FjEntity> fjlist= shMainService.fjxx(fjEntity);
		   		modelMap.put("fjlist", fjlist);
   		List<Slxx> qsxxList = shMainSwService.selectQsxxTS(test);
		modelMap.put("qsxxList", qsxxList);
		Qlrxx qlrTs = new Qlrxx();
		qlrTs.setQlrslbh(slbh);
		List<Qlrxx> qlrList = shMainSwService.selectQlr(qlrTs);
		modelMap.put("qlrList", qlrList);
		Ywrxx ywrTs = new Ywrxx();
		ywrTs.setYwrslbh(slbh);
		List<Ywrxx> ywrList = shMainSwService.selectYwr(ywrTs);
		modelMap.put("ywrList", ywrList);
		modelMap.put("slbh", slbh);
		return "admin/kfqUpdate/kfqQsxx";
	}
	/**
	 * 跳转到开发区不动产页面
	 * */
	@SuppressWarnings("unchecked")
	@GetMapping("kfqBwcTs")
	public String bwctz(ModelMap modelMap, String slbh) {
		Slxx test = new Slxx();
		test.setSlbh(slbh);
		//附件信息
		FjEntity fjEntity=new FjEntity();
		fjEntity.setSlbh(slbh);
   		List<FjEntity> fjlist= shMainService.fjxx(fjEntity);
   		modelMap.put("fjlist", fjlist);
   		
		List<Slxx> qsxxList = shMainService.selectQsxxTS(test);
		System.out.println("权属信息" + qsxxList.size());
		modelMap.put("qsxxList", qsxxList);
		
		Qlrxx qlrTs = new Qlrxx();
		qlrTs.setQlrslbh(slbh);
		List<Qlrxx> qlrList = shMainService.selectQlr(qlrTs);
		modelMap.put("qlrList", qlrList);
		
		Ywrxx ywrTs = new Ywrxx();
		ywrTs.setYwrslbh(slbh);
		List<Ywrxx> ywrList = shMainService.selectYwr(ywrTs);
		int a = shMainSwService.selectYwh(test);
		if(a>0){
			modelMap.put("msg", "数据已保存");
		}
		System.out.println(ywrList.size());
		modelMap.put("ywrList", ywrList);
		modelMap.put("slbh", slbh);
		return "admin/kfqUpdate/kfqQsxx";
	}
	/**
	 * 跳转到开发区税务页面
	 * */ 
	@SuppressWarnings("unchecked")
	@GetMapping("kfqswQsxx")
	public String shswQsxx(ModelMap modelMap, String slbh) {
		Slxx test = new Slxx();
		test.setSlbh(slbh);
		//附件信息
		FjEntity fjEntity=new FjEntity();
		fjEntity.setSlbh(slbh);
   		List<FjEntity> fjlist= shMainService.fjxx(fjEntity);
   		modelMap.put("fjlist", fjlist);  		
		List<Slxx> qsxxList = shMainSwService.selectQsxxTS(test);
		String jfjeZt;
		for(Slxx i:qsxxList) {
			jfjeZt=i.getJfje();
				modelMap.put("jfjeZt", i.getJfje());
		}
		
		modelMap.put("qsxxList", qsxxList);
		
		Qlrxx qlrTs = new Qlrxx();
		qlrTs.setQlrslbh(slbh);
		List<Qlrxx> qlrList = shMainSwService.selectQlr(qlrTs);
		modelMap.put("qlrList", qlrList);
		
		Ywrxx ywrTs = new Ywrxx();
		ywrTs.setYwrslbh(slbh);
		List<Ywrxx> ywrList = shMainSwService.selectYwr(ywrTs);
		int a = shMainSwService.selectYwh(test);
		if(a>0){
			modelMap.put("msg", "数据已保存");
		}
		modelMap.put("ywrList", ywrList);
		modelMap.put("slbh", slbh);
		return "admin/kfqUpdate/kfqswQsxx";
	}
	/**
	 * 跳转到开发区房管详情页面
	 * */
	@SuppressWarnings("unchecked")
	@GetMapping("kfqfgQsxx")
	public String shfgQsxx(ModelMap modelMap, String slbh) {
		Slxx test = new Slxx();
		test.setSlbh(slbh);
		//附件信息
		FjEntity fjEntity=new FjEntity();
		fjEntity.setSlbh(slbh);
   		List<FjEntity> fjlist= shMainService.fjxx(fjEntity);
   		modelMap.put("fjlist", fjlist);  		
		List<Slxx> qsxxList = shMainSwService.selectQsxxTS(test);
		modelMap.put("qsxxList", qsxxList);
		
		Qlrxx qlrTs = new Qlrxx();
		qlrTs.setQlrslbh(slbh);
		List<Qlrxx> qlrList = shMainSwService.selectQlr(qlrTs);
		modelMap.put("qlrList", qlrList);
		
		Ywrxx ywrTs = new Ywrxx();
		ywrTs.setYwrslbh(slbh);
		List<Ywrxx> ywrList = shMainSwService.selectYwr(ywrTs);
		int a = shMainSwService.selectYwh(test);
		if(a>0){
			modelMap.put("msg", "数据已保存");
		}
		modelMap.put("ywrList", ywrList);
		modelMap.put("slbh", slbh);
		return "admin/kfqUpdate/kfqfgQsxx";
	}
	/**
	 * 将数据置为历史
	 * */
	@GetMapping("/deleteAll")
	public ModelAndView deleteAll(String slbh) {
		ModelAndView view = new ModelAndView("admin/kfqbdc/deleAll");
		System.out.println(slbh);
		Slxx shMain = new Slxx();
		shMain.setSlbh(slbh);
		shMain.setZt("1");
		shMainSwService.swUpdatefje(shMain);
		return view;
	}
	/**
	 * 附件查看
	 * */
	@SuppressWarnings("unchecked")
	@GetMapping("fjck")
	public String fjck(ModelMap modelMap,String slbh) throws UnsupportedEncodingException{
		System.out.println("fjck===slbh====="+slbh);
		//附件信息查询
				FjEntity fjEntity=new FjEntity();
				fjEntity.setSlbh(slbh);
		   		List<FjEntity> fjlist= shMainService.fjxx(fjEntity);
		   		System.out.println("fjck====fjlist====="+fjlist.size());
   		modelMap.put("fjlist", fjlist);
   		
   		return "admin/kfqUpdate/fjck";
	}
	
	
	// 通过流转换照片
		@SuppressWarnings("static-access")
		@GetMapping("kfqYulan1")
		@ResponseBody
		public String createFolw(HttpServletRequest request, HttpServletResponse response, String filePath)
				throws IOException {
			System.out.println("照片路径===" + filePath);
			FtpHandler ftp = readConfig.ftpHandler();
			if (ftp.connect()) {
				ftp.disconnect();
			}
			ftp.connect();
			InputStream fis = null;
			OutputStream os = null;
			try {
				fis = ftp.getInputStream2(filePath);
				response.setContentType("image/jpeg");
				os = response.getOutputStream();
				int count = 0;
				byte[] buffer = new byte[1024 * 20];
				while ((count = fis.read(buffer)) != -1) {
					os.write(buffer, 0, count);
					os.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				fis.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "ok";
		}

		// 通过流转换pdf
		@SuppressWarnings("static-access")
		@GetMapping("kfqYulan")
		public void createFolw1(HttpServletRequest request, HttpServletResponse response, String filePath)
				throws IOException {
			System.out.println("PDF路径===" + filePath);
			FtpHandler ftp = readConfig.ftpHandler();
			if (ftp.connect()) {
				ftp.disconnect();
			}
			ftp.connect();
			InputStream fis = null;
			fis = ftp.getInputStream2(filePath);
			response.setContentType("application/pdf");
			OutputStream os = response.getOutputStream();
			writeBytes(fis, os);
		}

		// 工具
		private void writeBytes(InputStream in, OutputStream out) throws IOException {
			byte[] buffer = new byte[1024];
			int length = -1;
			while ((length = in.read(buffer)) != -1) {
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
		}
}
