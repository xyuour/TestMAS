package mas;

/**
 * ���Ͷ�����Ӧʵ��
 */
public class SendRes {
    private String rspcod;//��Ӧ��
    private String msgGroup;//��Ϣ���κţ�����MASƽ̨���ɣ�������֤�����ύ�����״̬�����һ���ԣ�ȡֵmsgGroup��ע:���������֤��ͨ��msgGroupΪ��
    private boolean success;

    public String getRspcod() {
        return rspcod;
    }

    public void setRspcod(String rspcod) {
        this.rspcod = rspcod;
    }

    public String getMsgGroup() {
        return msgGroup;
    }

    public void setMsgGroup(String msgGroup) {
        this.msgGroup = msgGroup;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
