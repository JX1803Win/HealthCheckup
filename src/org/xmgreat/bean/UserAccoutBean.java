package org.xmgreat.bean;

public class UserAccoutBean//用户账户表
{
	private Integer accoutId;//账户ID
	private Integer userId;//用户ID
	private Double balance;//余额
	private String occurTime;//发生时间
	private String occurMatter;//发生事项
	private Double money;//金额
	private UserInfoBean userInfoBean;//用户实体
	public UserAccoutBean() {
		super();
	}

	public Integer getAccoutId() {
		return accoutId;
	}

	public void setAccoutId(Integer accoutId) {
		this.accoutId = accoutId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(String occurTime) {
		this.occurTime = occurTime;
	}

	public String getOccurMatter() {
		return occurMatter;
	}

	public void setOccurMatter(String occurMatter) {
		this.occurMatter = occurMatter;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public UserInfoBean getUserInfoBean() {
		return userInfoBean;
	}

	public void setUserInfoBean(UserInfoBean userInfoBean) {
		this.userInfoBean = userInfoBean;
	}
	
	
	
}
