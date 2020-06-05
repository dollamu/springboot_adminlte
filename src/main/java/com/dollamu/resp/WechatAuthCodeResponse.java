package com.dollamu.resp;

public class WechatAuthCodeResponse {
	private String openid;// 	string 	用户唯一标识
	private String session_key;// 	string 	会话密钥
	private String unionid;// 	string 	用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见 UnionID 机制说明。
	private Long errcode;// 	number 	错误码
	private String errmsg;// 	string 	错误信息
	private Long expires_in;//过期时间
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getSession_key() {
		return session_key;
	}
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public Long getErrcode() {
		return errcode;
	}
	public void setErrcode(Long errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public Long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Long expiresIn) {
		this.expires_in = expiresIn;
	}
	

}
