package com.xiaoshu.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoshu.admin.model.DicItem;
import com.xiaoshu.admin.oracle.mapper.DicItemMapper;
import com.xiaoshu.admin.service.db2.DicItemService;


@Service
public class DicItemServiceImpl implements DicItemService{
	
	@Autowired
	private DicItemMapper dicItemMapper;

	@Override
	public String itemName(DicItem dicItem) {
		// TODO Auto-generated method stub
		return dicItemMapper.itemName(dicItem);
	}

	
	

}
