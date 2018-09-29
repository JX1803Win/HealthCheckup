package org.xmgreat.bizImpl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.xmgreat.bean.DetailBean;
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
		Integer currentPage = (Integer) condition.get("currentPage");
		if (currentPage > totalPage)
		{
			currentPage = totalPage;
		}
		int max = currentPage * Data.NUM + 1;
		int min = (currentPage - 1) * Data.NUM;
		condition.put("max", max);
		condition.put("min", min);
		resultMap.put("currentPage", currentPage);
		resultMap.put("details", detailMapper.getDetails(condition));
		resultMap.put("parameters", paramMapper.getParameters(24));
		return resultMap;
	}

	@Override
	public void addDetail(DetailBean detailBean)
	{
		detailMapper.addDetail(detailBean);

	}

	@Override
	public void updateDetail(DetailBean detailBean)
	{
		detailMapper.updateDetail(detailBean);

	}

	@Override
	public void delDetail(Integer subentryId)
	{
		detailMapper.delDetail(subentryId);

	}

}
