package com.junly.model.user;

import java.io.Serializable;

public class TicketModel extends UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 
	 * <p class="detail">
	 * 功能：加密的用户信息
	 * </p>
	 * @Fields ticket 
	 * @author junly
	 * @date 2017年3月23日
	 */ 
	private String ticket;
	/** 
	 * <p class="detail">
	 * 功能：用户积分
	 * </p>
	 * @Fields score 
	 * @author junly
	 * @date 2017年3月23日
	 */ 
	private Integer score;
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "TicketModel [ticket=" + ticket + ", score=" + score + ", getUserId()=" + getUserId()
				+ ", getUserName()=" + getUserName() + ", getPassWord()=" + getPassWord() + ", getStatus()="
				+ getStatus() + ", getUserType()=" + getUserType() + ", getNickName()=" + getNickName() + ", getSex()="
				+ getSex() + ", getBirthday()=" + getBirthday() + ", getAuthType()=" + getAuthType() + ", getHeadUrl()="
				+ getHeadUrl() + ", getUserFrom()=" + getUserFrom() + ", getUserLevel()=" + getUserLevel()
				+ ", getLoginIp()=" + getLoginIp() + ", getLastLoginTime()=" + getLastLoginTime() + ", getCreateTime()="
				+ getCreateTime() + ", getUpdateTime()=" + getUpdateTime() + "]";
	}
	

}
