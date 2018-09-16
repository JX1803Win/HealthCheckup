package org.xmgreat.bean;

import org.springframework.stereotype.Component;

/**
 * @author 宋卓伟
 * @date 2018年9月8日
 * @description 参数类
 */
@Component("pb")
public class ParamBean {

	private Integer paramId;// 参数id
	private String paramName;// 参数名称
	private Integer paramType;// 参数类型

	public ParamBean() {
		
	}
	
	public ParamBean(Integer paramId, String paramName) {
		this.paramId =paramId;
		this.paramName = paramName;
	}
	private ParamBean(Builder b) {
		this.paramId = b.paramId;
		this.paramName = b.paramName;
		this.paramType = b.paramType;
	}
	
	@Component("paramBuilder")
	public static class Builder {
		private Integer paramId;// 参数id
		private String paramName;// 参数名称
		private Integer paramType;// 参数类型
		
		public Builder paramId(Integer paramId) {
			this.paramId = paramId;
			return this;
		}
		
		public Builder paramName(String paramName) {
			this.paramName = paramName;
			return this;
		}
		
		public Builder paramType(Integer paramType) {
			this.paramType = paramType;
			return this;
		}
		
		public ParamBean builder() {
			return new ParamBean(this);
		}
	}
	
	public Integer getParamId() {
		return paramId;
	}

	public void setParamId(Integer paramId) {
		this.paramId = paramId;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public Integer getParamType() {
		return paramType;
	}

	public void setParamType(Integer paramType) {
		this.paramType = paramType;
	}

	@Override
	public String toString() {
		return "ParamBean [paramId=" + paramId + ", paramName=" + paramName + ", paramType=" + paramType + "]";
	}

}
