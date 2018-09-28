package mas;


import java.security.MessageDigest;
//import sun.misc.BASE64Encoder;
import org.apache.commons.codec.binary.Base64;
 
public class Md5Util {
	/**
	 * 
	 * @param pwd
	 *            ��Ҫ���ܵ��ַ���
	 * @param type
	 *            ��ĸ��Сд(falseΪĬ��Сд��trueΪ��д)
	 * @param bit
	 *            ���ܵ����ͣ�16,32,64��
	 * @return
	 */
	public static String getMD5(String pwd, boolean isUpper, Integer bit) {
		String md5 = new String();
		try {
			// �������ܶ���
			MessageDigest md = MessageDigest.getInstance("md5");
			if (bit == 64) {
//				BASE64Encoder bw = new BASE64Encoder();
//				String bsB64 = bw.encode(md.digest(pwd.getBytes("utf-8")));
//				String bsB64 = bw.(md.digest(pwd.getBytes("utf-8")));
//				md5 = bsB64;
				md5 = Base64.encodeBase64String(md.digest(pwd.getBytes("utf-8")));
			} else {
				// ����MD5����
				md.update(pwd.getBytes("utf-8"));
				byte b[] = md.digest();
				int i;
				StringBuffer sb = new StringBuffer("");
				for (int offset = 0; offset < b.length; offset++) {
					i = b[offset];
					if (i < 0)
						i += 256;
					if (i < 16)
						sb.append("0");
					sb.append(Integer.toHexString(i));
				}
				md5 = sb.toString();
				if(bit == 16) {
					//��ȡ32λmd5Ϊ16λ
					String md16 = md5.substring(8, 24).toString();
					md5 = md16;
					if (isUpper)
						md5 = md5.toUpperCase();
					return md5;
				}
			}
			//ת���ɴ�д
			if (isUpper)
				md5 = md5.toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("md5�����׳��쳣��");
		}
 
		return md5;
	}
 
	public static void main(String[] args) throws Exception {
		String a = "";
		String md5a = getMD5(a, false, 32);
		System.out.println(md5a);
		System.out.println(md5a.length());
	}
}
