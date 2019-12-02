package com.xiaoshu.admin.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.xiaoshu.admin.model.FjEntity;
import com.xiaoshu.admin.model.Qlrxx;
import com.xiaoshu.admin.model.Slxx;
import com.xiaoshu.admin.model.Ywrxx;
import com.xiaoshu.admin.oracle.mapper.KfqMainMapper; 
import com.xiaoshu.admin.service.db2.KfqMainService;

@Service
public class KfqMainServiceImp implements KfqMainService{
	
	@Autowired
	private KfqMainMapper SlxxMapper;

	@Override
	public List<Slxx> selectBdcAllList(Slxx Slxx) {
		// TODO Auto-generated method stub
		return SlxxMapper.selectBdcAllList(Slxx);
	}

	@Override
	public int findCountBdcAllList(Slxx Slxx) {
		// TODO Auto-generated method stub
		return SlxxMapper.findCountBdcAllList(Slxx);
	}

	@Override
	public List<Slxx> selectQsxxTS(Slxx Slxx) {
		// TODO Auto-generated method stub
		return SlxxMapper.selectQsxxTS(Slxx);
	}  
	
	@Override
	public List<Qlrxx> selectQlr(Qlrxx qlrTs) {
		// TODO Auto-generated method stub
		return SlxxMapper.selectQlr(qlrTs);
	}

	@Override
	public List<Ywrxx> selectYwr(Ywrxx ywrTs) {
		// TODO Auto-generated method stub
		return SlxxMapper.selectYwr(ywrTs);
	}

	@Override
	public List<FjEntity> fjxx(FjEntity fjEntity) {
		// TODO Auto-generated method stub
		return SlxxMapper.fjxx(fjEntity);
	}

	

	

}
