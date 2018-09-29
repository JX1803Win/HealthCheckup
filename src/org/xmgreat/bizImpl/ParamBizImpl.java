package org.xmgreat.bizImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.xmgreat.bean.ParameterBean;
import org.xmgreat.biz.ParamBiz;
import org.xmgreat.mapper.ParamMapper;
@Service
public class ParamBizImpl implements ParamBiz{

	@Resource
	private ParamMapper paramMapper;
	
	@Override
	public List<ParameterBean> search(String typeName, Integer pageNo) {
		return paramMapper.search(typeName, pageNo);
	}

	@Override
	public Integer countOfSearch(String typeName) {
		return paramMapper.countOfSearch(typeName);
	}

	@Override
	public void del(Integer parameterId) {
		paramMapper.del(parameterId);
	}

	@Override
	public List<ParameterBean> queryAllTypeName() {
		return paramMapper.queryAllTypeName();
	}

	@Override
	public void addParam(ParameterBean pb) {
		paramMapper.addParam(pb);
	}

	@Override
	public void alterParam(ParameterBean pb) {
		paramMapper.alterParam(pb);
	}

}
