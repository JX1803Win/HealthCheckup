package org.xmgreat.bizImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.xmgreat.bean.UserPhyRecordBean;
import org.xmgreat.biz.AppoBiz;
import org.xmgreat.mapper.AppoMapper;
@Repository
public class AppoBizImpl implements AppoBiz{

	@Resource
	private AppoMapper appoMapper;
	
	
	@Override
	public void addPhyRecord(UserPhyRecordBean uprb, String time) {
		appoMapper.addPhyRecord(uprb);
		appoMapper.addAppoRecord(uprb, time);
	}

}
