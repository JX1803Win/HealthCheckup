package org.xmgreat.bizImpl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.xmgreat.biz.DetailBiz;
import org.xmgreat.mapper.DetailMapper;
import org.xmgreat.mapper.ParamMapper;
import org.xmgreat.util.Data;

@Service
public class DetailBizImpl implements DetailBiz
{
	@Resource
	private DetailMapper detailMapper;

	@Resource
	private ParamMapper paramMapper;

	public Integer totalPage;
	public Integer total;
	private Map<String, Object> resultMap = new HashMap<String, Object>();

	@Override
	public Map<String, Object> search(Map<String, Object> condition)
	{
		resultMap.put("details", detailMapper.getDetails(condition));
		resultMap.put("parameters", paramMapper.getParameters(24));
		String detailName = null;
		if (condition.get("detailName") != null)
		{
			detailName = condition.get("detailName").toString();
		}
		total = detailMapper.count(detailName);
		resultMap.put("total", total);
		if (total % Data.NUM == 0)
		{
			totalPage = total / Data.NUM;
		} else
		{
			totalPage = total / Data.NUM + 1;
		}
		if (totalPage == 0)
		{
			totalPage = 1;
		}
		resultMap.put("totalPage", totalPage);
		return resultMap;
	}

}
