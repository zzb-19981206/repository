package com.xiaoshu.admin.service.db2;


import java.util.List;

import com.xiaoshu.admin.model.Bdcfile;
import com.xiaoshu.admin.model.FjEntity;
import com.xiaoshu.admin.model.Qlrxx;
import com.xiaoshu.admin.model.Slxx;
import com.xiaoshu.admin.model.Ywrxx; 

public interface KfqMainService {
	
	 
	
	List<Slxx> selectBdcAllList(Slxx shMain);
	int findCountBdcAllList(Slxx shMain);
	
	List<Slxx> selectQsxxTS(Slxx shMain);
	List<Qlrxx> selectQlr(Qlrxx qlrTs);
	List<Ywrxx> selectYwr(Ywrxx ywrTs);
	
	List<FjEntity> fjxx(FjEntity fjEntity);

}
