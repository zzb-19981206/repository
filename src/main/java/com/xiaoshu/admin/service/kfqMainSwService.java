package com.xiaoshu.admin.service;

import java.util.List;

import com.xiaoshu.admin.model.Bdcfile;
import com.xiaoshu.admin.model.Qlrxx;
import com.xiaoshu.admin.model.Slxx;
import com.xiaoshu.admin.model.Ywrxx; 

public interface kfqMainSwService {

	List<Slxx> selectSwAllList(Slxx shMain);

	int findCountSwAllList(Slxx shMain);

	int findbdcswCountAllList(Slxx shMain);

	int findbdcfgCountAllList(Slxx shMain);

	List<Slxx> selectZt(Slxx ywh);

	boolean insertSlxx(Slxx shMain);

	boolean insertQlrxx(Qlrxx qlrTs);

	boolean insertYwrxx(Ywrxx ywrTs);

	int selectYwh(Slxx shMain);

	boolean updatezt(Slxx shMain);

	List<Slxx> selectSwList(Slxx shMain);

	boolean swUpdatefje(Slxx shMain);

	List<Slxx> kfqbdcAllList(Slxx shMain);

	List<Slxx> kfqbdcswList(Slxx shMain);

	List<Slxx> kfqbdcfgList(Slxx shMain);
	
	List<Slxx> selectQsxxTS(Slxx shMain);
	List<Qlrxx> selectQlr(Qlrxx qlrTs);
	List<Ywrxx> selectYwr(Ywrxx ywrTs);
	List<Slxx> selectMain(Slxx shMain);
	int findMainCount(Slxx shMain);
	//买房和卖方收税金额
	boolean swUpdateMfje(Slxx shMain);

}
