package mas;

import java.io.IOException;

public class MasMain {
	
	/**
     * main方法测试发送短信，返回1表示成功，0表示失败
     * @throws IOException 
     */
	
    public static void main(String[] args) throws IOException{
        SMSClient.sendMsg("","[测试]你好！");

    }

}
