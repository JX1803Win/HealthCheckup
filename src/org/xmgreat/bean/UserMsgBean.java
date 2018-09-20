package org.xmgreat.bean;

import org.springframework.stereotype.Component;

@Component
public class UserMsgBean //用戶信息表
{
	private Integer msgId; //信息ID
	private UserInfoBean userInfoBean; //用戶bean
	private String msgTime;	//信息时间
	private String msgTitle;//消息标题
	private String msgCon;  //消息内容
	
	public UserMsgBean() {
		
	}

	public Integer getMsgId()
	{
		return msgId;
	}

	public void setMsgId(Integer msgId)
	{
		this.msgId = msgId;
	}

	public UserInfoBean getUserInfoBean()
	{
		return userInfoBean;
	}

	public void setUserInfoBean(UserInfoBean userInfoBean)
	{
		this.userInfoBean = userInfoBean;
	}

	public String getMsgTime()
	{
		return msgTime;
	}

	public void setMsgTime(String msgTime)
	{
		this.msgTime = msgTime;
	}

	public String getMsgTitle()
	{
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle)
	{
		this.msgTitle = msgTitle;
	}

	public String getMsgCon()
	{
		return msgCon;
	}

	public void setMsgCon(String msgCon)
	{
		this.msgCon = msgCon;
	}
	
}
