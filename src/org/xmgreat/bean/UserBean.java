package org.xmgreat.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
// 用户类
//@Component("userBean")
public class UserBean {

	private Integer userId;// 用户id
	private String username;// 用户名
	private String psw;// 密码
	private String sex;// 性别
	private Integer eduId;// 学历id
	private String eduName;// 学历
	private String occ;// 职业
	private Long tel;// 手机号
	private String email;// 邮箱
	private Long integral;// 积分
	private Integer upNum;// 上传数量
	private Integer downNum;// 下载数量
	@Resource
	private ParamBean pb;
	private String registerTime;// 注册时间
	
	public UserBean() {
		
	}

	private UserBean(Builder b) {
		this.userId = b.userId;
		this.username = b.username;
		this.psw = b.psw;
		this.sex = b.sex;
		this.eduId = b.eduId;
		this.eduName = b.eduName;
		this.occ = b.occ;
		this.tel = b.tel;
		this.email = b.email;
		this.integral = b.integral;
		this.upNum = b.upNum;
		this.downNum = b.downNum;
		this.pb = b.pb;
		this.registerTime = b.registerTime;

	}
	@Component("userBuilder")
	public static class Builder {
		private Integer userId;// 用户id
		private String username;// 用户名
		private String psw;// 密码
		private String sex;// 性别
		private Integer eduId;// 学历id
		private String eduName;// 学历
		private String occ;// 职业
		private Long tel;// 手机号
		private String email;// 邮箱
		private Long integral;// 积分
		private Integer upNum;// 上传数量
		private Integer downNum;// 下载数量
		private ParamBean pb;
		private String registerTime;// 注册时间

		public Builder userId(Integer userId) {
			this.userId = userId;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder psw(String psw) {
			this.psw = psw;
			return this;
		}

		public Builder sex(String sex) {
			this.sex = sex;
			return this;
		}

		public Builder eduId(Integer eduId) {
			this.eduId = eduId;
			return this;
		}
		
		public Builder eduName(String eduName) {
			this.eduName = eduName;
			return this;
		}

		public Builder occ(String occ) {
			this.occ = occ;
			return this;
		}

		public Builder tel(Long tel) {
			this.tel = tel;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder integral(Long integral) {
			this.integral = integral;
			return this;
		}

		public Builder upNum(Integer upNum) {
			this.upNum = upNum;
			return this;
		}

		public Builder downNum(Integer downNum) {
			this.downNum = downNum;
			return this;
		}

		public Builder pb(ParamBean pb) {
			this.pb = pb ;
			return this;
		}

		public Builder registerTime(String registerTime) {
			this.registerTime = registerTime;
			return this;
		}

		public UserBean builder() {
			return new UserBean(this);
		}

	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEduName() {
		return eduName;
	}

	public void setEduName(String eduName) {
		this.eduName = eduName;
	}

	public String getOcc() {
		return occ;
	}

	public void setOcc(String occ) {
		this.occ = occ;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIntegral() {
		return integral;
	}

	public void setIntegral(Long integral) {
		this.integral = integral;
	}

	public Integer getUpNum() {
		return upNum;
	}

	public void setUpNum(Integer upNum) {
		this.upNum = upNum;
	}

	public Integer getDownNum() {
		return downNum;
	}

	public void setDownNum(Integer downNum) {
		this.downNum = downNum;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	
	public Integer getEduId() {
		return eduId;
	}
	
	public void setEduId(Integer eduId) {
		this.eduId = eduId;
	}

	public ParamBean getPb() {
		return pb;
	}

	public void setPb(ParamBean pb) {
		this.pb = pb;
	}

	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", username=" + username + ", psw=" + psw + ", sex=" + sex + ", eduId="
				+ eduId + ", eduName=" + eduName + ", occ=" + occ + ", tel=" + tel + ", email=" + email + ", integral="
				+ integral + ", upNum=" + upNum + ", downNum=" + downNum + ", pb=" + pb + ", registerTime="
				+ registerTime + "]";
	}

}
