package org.xmgreat.bizImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.xmgreat.bean.OfficeBean;
import org.xmgreat.biz.OfficeBiz;
import org.xmgreat.mapper.OfficeMapper;
@Service
public class OfficeBizImpl implements OfficeBiz
{
	@Resource
	private OfficeMapper officeMapper;

	@Override
	public List<OfficeBean> getOffice(int page)
	{
		// TODO Auto-generated method stub
		return officeMapper.getOffice(page);
	}

	@Override
	public void updOffice(int officeid)
	{
		// TODO Auto-generated method stub
		officeMapper.updOffice(officeid);
	}

	@Override
	public void delOffice(int officeid)
	{
		// TODO Auto-generated method stub
		officeMapper.delOffice(officeid);
	}

	@Override
	public void changeOfficeName(String name, int id)
	{
		// TODO Auto-generated method stub
		int i = officeMapper.changeOfficeName(name, id);
	}

	@Override
	public void addOffice(String officename)
	{
		// TODO Auto-generated method stub
		officeMapper.addOffice(officename);
	}

	@Override
	public List<OfficeBean> selectOffice(int page, String name)
	{
		// TODO Auto-generated method stub
		return officeMapper.selectOffice(page, name);
	}

	@Override
	public int countOff()
	{
		// TODO Auto-generated method stub
		return officeMapper.countOff();
	}

}
