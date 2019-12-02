package com.xiaoshu.admin.oracle.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoshu.admin.model.Bdcfile;
import com.xiaoshu.admin.model.DicItem;
public interface DicItemMapper extends BaseMapper<DicItem>{
	
	public String itemName(DicItem dicItem);

}
