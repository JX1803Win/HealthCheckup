package org.xmgreat.util;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092100565689";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
	 public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCbnIntbVLzHrKt1i02ac5Xg/Jf+pTeKgBffTVSrDChcwfCiM6MKAswSIN3RCk56VjLmNw4rfI/yQtYKwizgduHpUrIDbobjbD0UNWmHKsakxT12tkKYs/3Igl+g4vHDGXSafIlcHvNvVWTRlc/Jg/0t0LW2KYdwhoGy962sIiYY4i09DXIBE5ZYdkOIBkw1hHM+xBFqDs62XqqeFhpFAQ2Luw1+4L5iMX8/nmVmMscozhlqA/5Jn/zv1CtA2FwJECkztwtyuxH/w0Q5xLH9mAv8HBJm/M1AqGSbaHaIVEjxOJuELGBRqwLbRPoi9OkW+f2uT2xtrvCfUODaPCskb2ZAgMBAAECggEABnaP+/6IbXSe8z1sD1CBs3zVeksMF9YiwdSPfGmOc4Y1kkzgV03qeQzp+PApzi/08i/dJbWD1EZjZDwVVm9UUOP6oSiAzFgsO1mIJigWqznkqvl1/kpwXNFbF5gbHB9Vs1GXLxrm6XqtrTpEsWjBTOa3rfi9nYrMTe/1xhy676lRwRTCCGwrEXMRwxsv0NJMVBAMWP58RGmteQNrGS3aoUq9Pd3o+eSFWouHQXA/wJk8fLPZ3aOnsuVlcUQTGF/G0p9EIDe6bpitQ03bn9PFbXrTig6m/y3B1/fKuM1mOwGUjmX1g0Gov0Nksq93L2211S7VVV8iMpUab1DAD6drSQKBgQDzqTkra39g3XLVPZIJHhaC3CSPGuhxnvKva50tyUeelK/n2f0YE0iF1QbSI3+gdlF50YVdwd95cEsLMYgXQZtgo+pSPQDqJo8DEMt+zKjzMTUqd676Y+v9kubIFELsz9EpaIH429KD7IiIpgPZ5J3bv9qOzP2Y/Thwph1mfwi/QwKBgQCjfdt5+uDEU6r/eM//hRm8nUmU0bNxTplPCVpPPzcQ4SHb3Is5EoBGQ1i7Gt4uJNDLwE54JFMgOx84QNc8OGv7zej7mYabxnuGteRg2VBROiVzofFjG4EB4mfwGb+ijMZuubS5qRr/l9NuSRli/8yZxHG5+M4+QmtJs81io7V78wKBgA/osaHjH+r8Kn4/yeQsgb3Dj+OEFz8r6J6JgTa3GKUDAkU6F2tV/vs2AH8B8FhSwVkZ1AJeITA1o8C0WDVkhDeYHDmIYCHpqJbDpvW9eR5/zP/b1qHkmkjxKX5QzFnX68kvWKUd/S296OA7Lq8wXRo2+ZcvTTOK/P9l6S+DBdgvAoGAL7hXrIX+vy9QtRrVU1bNSVF7nbWLs+HmO7yWIJVqBEJCOMNp27G7wUZ9Crfv6/YQ/7fU75pirQC0vx2l9Uzer/PNMksAkE1h1tMWovIrUFoxfkvhgjUP9bXY8qsBVXfTn5QS3TIv0DTHoOQzRcM2PBervkWSJXgLisqxgz4XheMCgYBP+ByjHFk6hvVix5B9oFb+qROLWE7N5YbzYl0ya4jelKSr4eSl6WKpsFpMaJYFgcuv/eA2GnGeeP+1eLB6HlW4dyxz1UYDzO8XeM/tKlxqyNrPkjxlUE2IYwk8L/CWojIEFJoxnMPRWOUfICzL993B2vbJkYVxka/jBA4rAJC5xg==";	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm5yJ7W1S8x6yrdYtNmnOV4PyX/qU3ioAX301UqwwoXMHwojOjCgLMEiDd0QpOelYy5jcOK3yP8kLWCsIs4Hbh6VKyA26G42w9FDVphyrGpMU9drZCmLP9yIJfoOLxwxl0mnyJXB7zb1Vk0ZXPyYP9LdC1timHcIaBsvetrCImGOItPQ1yAROWWHZDiAZMNYRzPsQRag7Otl6qnhYaRQENi7sNfuC+YjF/P55lZjLHKM4ZagP+SZ/879QrQNhcCRApM7cLcrsR/8NEOcSx/ZgL/BwSZvzNQKhkm2h2iFRI8TibhCxgUasC20T6IvTpFvn9rk9sba7wn1Dg2jwrJG9mQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://127.0.0.1:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	/*public static String return_url = "http://127.0.0.1:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";*/
	public static String return_url = null;

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

