package mas;

/**
 * ���Ͷ�������ʵ��
 */
public class SendReq {
    private String ecName;//���ſͻ�����
    private String apId;//�û���
    private String secretKey;//����
    private String mobiles;//�ֻ����붺�ŷָ���
    private String content;//���Ͷ�������
    private String sign;//����ǩ�����룬���ǩ���������й��ƶ����ſ�ͨ�ʺź���䣬��������MAS��ҳ�˹�����ϵͳ-SMS�ӿڹ����������ء�
    private String addSerial;//��չ�룬�������ƶ���˾�����ͨ����д���������ľ�ȷƥ��ͨ��������д���ַ���("")����������ƶ���˾�������չ�롣
    private String mac;//API�������ǩ�������ǩ���㷨����ecName��apId��secretKey��mobiles��content ��sign��addSerial����˳��ƴ�ӣ�Ȼ��ͨ��md5(32λСд)�����ó���ֵ��

    public String getEcName() {
        return ecName;
    }

    public void setEcName(String ecName) {
        this.ecName = ecName;
    }

    public String getApId() {
        return apId;
    }

    public void setApId(String apId) {
        this.apId = apId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getMobiles() {
        return mobiles;
    }

    public void setMobiles(String mobiles) {
        this.mobiles = mobiles;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAddSerial() {
        return addSerial;
    }

    public void setAddSerial(String addSerial) {
        this.addSerial = addSerial;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
