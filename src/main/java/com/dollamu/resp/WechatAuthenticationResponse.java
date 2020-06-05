package com.dollamu.resp;

public class WechatAuthenticationResponse  {

	private String openid;

	public WechatAuthenticationResponse(String openid) {		
		this.openid = openid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	

}
