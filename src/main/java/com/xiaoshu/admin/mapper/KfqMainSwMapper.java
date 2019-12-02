package com.xiaoshu.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
 
import java.util.List; 

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
 

import com.xiaoshu.admin.model.Qlrxx;
import com.xiaoshu.admin.model.Slxx;
import com.xiaoshu.admin.model.Ywrxx;

public interface KfqMainSwMapper extends BaseMapper<Slxx> {

	List<Slxx> selectSwAllList(Slxx shMain);

	int findCountSwAllList(Slxx shMain);

	int findbdcswCountAllList(Slxx shMain);

	int findbdcfgCountAllList(Slxx shMain);

	@Select("select * from slxx t where t.slbh = #{slbh} ")
	List<Slxx> selectZt(Slxx ywh);

	boolean insertSlxx(Slxx shMain);

	boolean insertQlrxx(Qlrxx qlrTs);

	boolean insertYwrxx(Ywrxx ywrTs);

	@Select("select count(*) from slxx where slbh=#{slbh}")
	int selectYwh(Slxx shMain);

	@Update("update slxx set zt='2' where slbh=#{slbh}")
	boolean updatezt(Slxx shMain);

	List<Slxx> selectSwList(Slxx shMain);

	boolean swUpdatefje(Slxx shMain);

	List<Slxx> kfqbdcAllList(Slxx shMain);

	List<Slxx> kfqbdcswList(Slxx shMain);

	List<Slxx> kfqbdcfgList(Slxx shMain);

	List<Slxx> selectQsxxTS(Slxx shMain);

	List<Qlrxx> selectQlr(Qlrxx qlrTs);

	List<Ywrxx> selectYwr(Ywrxx ywrTs);
	
	//首页数据显示查询
	List<Slxx> selectMain(Slxx shMain);
	//首页显示数据总数
	int findMainCount(Slxx shMain);

	boolean swUpdateMfje(Slxx shMain);


}