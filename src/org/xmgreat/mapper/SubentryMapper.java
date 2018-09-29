package org.xmgreat.mapper;

import org.springframework.stereotype.Repository;
import org.xmgreat.bean.SubentryBean;

/**
 * @author 周鸿谊
 * @date 2018年9月28日
 * @description 小结结果
 */

@Repository
public interface SubentryMapper
{
	public Integer addSubentry(SubentryBean subentryBean);
}
