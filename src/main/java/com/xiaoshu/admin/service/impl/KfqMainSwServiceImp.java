package com.xiaoshu.admin.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoshu.admin.mapper.KfqMainSwMapper;
import com.xiaoshu.admin.model.Bdcfile;
import com.xiaoshu.admin.model.Qlrxx;
import com.xiaoshu.admin.model.Slxx;
import com.xiaoshu.admin.model.Ywrxx; 
import com.xiaoshu.admin.service.kfqMainSwService; 

@Service
public class KfqMainSwServiceImp implements kfqMainSwService{
	
	@Autowired
	private KfqMainSwMapper SlxxSwMapper;

	@Override
	public List<Slxx> selectSwAllList(Slxx shMain) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.selectSwAllList(shMain);
	}

	@Override
	public int findCountSwAllList(Slxx shMain) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.findCountSwAllList(shMain);
	}

	@Override
	public int findbdcswCountAllList(Slxx shMain) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.findbdcswCountAllList(shMain);
	}

	@Override
	public int findbdcfgCountAllList(Slxx shMain) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.findbdcfgCountAllList(shMain);
	}

	@Override
	public List<Slxx> selectZt(Slxx ywh) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.selectZt(ywh);
	}

	@Override
	public boolean insertSlxx(Slxx shMain) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.insertSlxx(shMain);
	}

	@Override
	public boolean insertQlrxx(Qlrxx qlrTs) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.insertQlrxx(qlrTs);
	}

	@Override
	public boolean insertYwrxx(Ywrxx ywrTs) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.insertYwrxx(ywrTs);
	}

	@Override
	public int selectYwh(Slxx shMain) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.selectYwh(shMain);
	}

	@Override
	public boolean updatezt(Slxx shMain) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.updatezt(shMain);
	}

	@Override
	public List<Slxx> selectSwList(Slxx shMain) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.selectSwList(shMain);
	}

	@Override
	public boolean swUpdatefje(Slxx shMain) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.swUpdatefje(shMain);
	}

	@Override
	public List<Slxx> kfqbdcAllList(Slxx shMain) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.kfqbdcAllList(shMain);
	}

	@Override
	public List<Slxx> kfqbdcswList(Slxx shMain) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.kfqbdcswList(shMain);
	}

	@Override
	public List<Slxx> kfqbdcfgList(Slxx shMain) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.kfqbdcfgList(shMain);
	}

	@Override
	public List<Slxx> selectQsxxTS(Slxx shMain) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.selectQsxxTS(shMain);
	}

	@Override
	public List<Qlrxx> selectQlr(Qlrxx qlrTs) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.selectQlr(qlrTs);
	}

	@Override
	public List<Ywrxx> selectYwr(Ywrxx ywrTs) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.selectYwr(ywrTs);
	}

	@Override
	public List<Slxx> selectMain(Slxx shMain) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.selectMain(shMain);
	}

	@Override
	public int findMainCount(Slxx shMain) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.findMainCount(shMain);
	}

	@Override
	public boolean swUpdateMfje(Slxx shMain) {
		// TODO Auto-generated method stub
		return SlxxSwMapper.swUpdateMfje(shMain);
	}

	


}
