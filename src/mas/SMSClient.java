package mas;

import mas.JSONUtils;
import mas.Md5Util;
import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class SMSClient {

    private static String apId="";
    private static String secretKey="";
    private static String ecName = "";//集团名称
    private static String sign = "";//网关签名编码
    private static String addSerial = "";//拓展码 填空
//    public static String msg = "";
    public static String url = "";//请求url
    
    private static Logger log = Logger.getLogger("mas.smsclient");

    public static int sendMsg(String mobiles,String content) throws IOException{
        SendReq sendReq = new SendReq();
        sendReq.setApId(apId);
        sendReq.setEcName(ecName);
        sendReq.setSecretKey(secretKey);
        sendReq.setContent(content);
        sendReq.setMobiles(mobiles);
        sendReq.setAddSerial(addSerial);
        sendReq.setSign(sign);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(sendReq.getEcName());
        stringBuffer.append(sendReq.getApId());
        stringBuffer.append(sendReq.getSecretKey());
        stringBuffer.append(sendReq.getMobiles());
        stringBuffer.append(sendReq.getContent());
        stringBuffer.append(sendReq.getSign());
        stringBuffer.append(sendReq.getAddSerial());
        log.info(stringBuffer.toString());

        sendReq.setMac(Md5Util.getMD5((stringBuffer.toString()), false, 32));
        log.info(sendReq.getMac());

        String reqText = JSONUtils.objectToJson(sendReq);
        log.info(reqText);
        String encode = Base64.encodeBase64String(reqText.getBytes("utf-8"));
        log.info(encode);

        String resStr = sendPost(url,encode);

        log.info(resStr);

        SendRes sendRes = JSONUtils.jsonToPojo(resStr,SendRes.class);

        if(sendRes.isSuccess() && !"".equals(sendRes.getMsgGroup()) && "success".equals(sendRes.getRspcod())){
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数
     * @return 所代表远程资源的响应结果
     */
    private static String sendPost(String url, String param) {
        OutputStreamWriter out = null;

        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
//            Map<String, List<String>> headerFields = conn.getHeaderFields();
//            log.info(headerFields.toString());
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("contentType","utf-8");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            out = new OutputStreamWriter(conn.getOutputStream());
            out.write(param);
            out.flush();


            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

}
