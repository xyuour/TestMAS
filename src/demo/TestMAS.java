package demo;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestMAS {

	public static void main(String[] args) {
		try {
			JSONArray jsarr = new JSONArray();
			JSONObject jso = new JSONObject();
			String addSerial = "";
			String apId = "";
			String content = "";
			String ecName = "";
			String mobiles = "";
			String sign = "";
			String secretKey = "";
			
			jso.put("addSerial", addSerial);
			jso.put("apId", apId);
			jso.put("content", content);
			jso.put("ecName", ecName);
			jso.put("mobiles", mobiles);
			jso.put("sign", sign);
			String str=ecName+apId+secretKey+mobiles+content+sign+addSerial;
			System.out.println(str);
			String mac = MD5Utils.md5(str);
			System.out.println(mac);
			jso.put("mac", "");
			jsarr.add(jso);
			System.out.println(jsarr.toString());
			String encode = "";
			String encode2 = "";
            URL url = new URL("");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
//            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            // �����ļ�����:
            conn.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            // ���ý������ͷ��򷵻�415����
            //conn.setRequestProperty("accept","*/*")�˴�Ϊ�����������ý����������ͣ��Դ�����������415;
//          conn.setRequestProperty("accept","application/json");
            // �����������淢������
            if (jsarr != null && !"".equals(jsarr)) {
                byte[] writebytes = jsarr.toString().getBytes();
                // �����ļ�����
//                conn.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
                OutputStream outwritestream = conn.getOutputStream();
                outwritestream.write(encode2.getBytes());
                outwritestream.flush();
                outwritestream.close();
//                Log.d("hlhupload", "doJsonPost: conn"+conn.getResponseCode());
            }
            /*
            if (conn.getResponseCode() == 200) {
                reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                result = reader.readLine();
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	
           /* if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/
        }
	}

}
