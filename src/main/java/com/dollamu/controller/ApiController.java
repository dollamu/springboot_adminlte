package com.dollamu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dollamu.property.WechatProperties;
import com.dollamu.resp.WechatAuthCodeResponse;
import com.dollamu.resp.WechatAuthenticationResponse;

@RestController
@RequestMapping("api")
public class ApiController {

	private final static Logger log = LoggerFactory.getLogger(ApiController.class);
	private static final Long EXPIRES = 72000L;
	@Autowired
	private RestTemplate wxAuthRestTemplate = new RestTemplate();
	@Autowired
	private WechatProperties wxAutoConfig;
	
	@RequestMapping("wxLogin")
	public WechatAuthenticationResponse wxLogin(String code) {
		WechatAuthCodeResponse response = getWxSession(code);

        String wxOpenId = response.getOpenid();
        //String wxSessionKey = response.getSessionKey();
        
//        Consumer consumer = new Consumer();
//        consumer.setWechatOpenid(wxOpenId);
//        loginOrRegisterConsumer(consumer);

        //Long expires = response.getExpiresIn();
        //String thirdSession = create3rdSession(wxOpenId, wxSessionKey, expires);
        return new WechatAuthenticationResponse(wxOpenId);
	}
	
	public WechatAuthCodeResponse getWxSession(String code) {
        log.info("微信登录码：{}",code);
        String urlString = wxAutoConfig.getHost() +"?appid={appid}&secret={srcret}&js_code={code}&grant_type={grantType}";
        
        WechatAuthCodeResponse res = wxAuthRestTemplate.getForObject(
        		urlString, WechatAuthCodeResponse.class,        		
        		wxAutoConfig.getAppId(),
        		wxAutoConfig.getSecret(),
                code,
                wxAutoConfig.getGrantType());
//        ObjectMapper objectMapper = new ObjectMapper();
//        ObjectReader reader = objectMapper.readerFor(WechatAuthCodeResponse.class);
//        WechatAuthCodeResponse res;
//        try {
//            res = reader.readValue(response);
//        } catch (IOException e) {
//            res = null;
//            log.error("反序列化失败", e);
//            throw new RuntimeException("调用微信接口失败",e);
//        }
//        log.info(res);
        if (null == res) {
            throw new RuntimeException("调用微信接口失败");
        }
        if (res.getErrcode() != null) {
            throw new RuntimeException(res.getErrmsg());
        }
        res.setExpires_in(res.getExpires_in() != null ? res.getExpires_in() : EXPIRES);
        return res;
    }

//    public String create3rdSession(String wxOpenId, String wxSessionKey, Long expires) {
//        String thirdSessionKey = RandomStringUtils.randomAlphanumeric(64);
//        StringBuffer sb = new StringBuffer();
//        sb.append(wxSessionKey).append("#").append(wxOpenId);
//
//        stringRedisTemplate.opsForValue().set(thirdSessionKey, sb.toString(), expires, TimeUnit.SECONDS);
//        return thirdSessionKey;
//    }

//    private void loginOrRegisterConsumer(Consumer consumer) {
//        Consumer consumer1 = consumerMapper.findConsumerByWechatOpenid(consumer.getWechatOpenid());
//        if (null == consumer1) {
//            consumerMapper.insertConsumer(consumer);
//        }
//    }

//    public void updateConsumerInfo(Consumer consumer) {
//        Consumer consumerExist = consumerMapper.findConsumerByWechatOpenid(AppContext.getCurrentUserWechatOpenId());
//        consumerExist.setUpdatedBy(1L);
//        consumerExist.setUpdatedAt(System.currentTimeMillis());
//        consumerExist.setGender(consumer.getGender());
//        consumerExist.setAvatarUrl(consumer.getAvatarUrl());
//        consumerExist.setWechatOpenid(consumer.getWechatOpenid());
//        consumerExist.setEmail(consumer.getEmail());
//        consumerExist.setNickname(consumer.getNickname());
//        consumerExist.setPhone(consumer.getPhone());
//        consumerExist.setUsername(consumer.getUsername());
//        consumerMapper.updateConsumer(consumerExist);
//    }
}
