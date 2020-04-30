package com.paipaiwang.thirdparty;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class MobileMsgService {

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAIOSsAKWWzEBdq";
    static final String accessKeySecret = "CDU58rHegq44jXoFqAhgO70FbtRFDi";
    
    static{
    	System.setProperty("sun.net.client.defaultConnectTimeout", "10000");//可自助调整超时时间
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");//可自助调整超时时间
    }

    public static Boolean sendRegistCodeToPhone(String phoneNumber,String code) throws ClientException {

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
       
        SendSmsRequest request = new SendSmsRequest(); //组装请求对象-具体描述见控制台-文档部分内容
        request.setPhoneNumbers(phoneNumber); //必填:待发送手机号
        request.setSignName("萧家洲毕设"); //必填:短信签名-可在短信控制台中找到
        request.setTemplateCode("SMS_135027068");  //必填:短信模板-可在短信控制台中找到
        //可选:模板中的变量替换JSON串,如模板内容为"您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"code\":\""+ code +"\"}");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

//      return sendSmsResponse;
        String respMsg = sendSmsResponse.getMessage();
        String respCode = sendSmsResponse.getCode();
        
        if("OK".equals(respMsg) && "OK".equals(respCode)){
        	return true;
        }else{
        	return false;
        }
    }
}
