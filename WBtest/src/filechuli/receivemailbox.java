package filechuli;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class receivemailbox {

	public static void main(String[] args) throws IOException {
		FileOutputStream clear=new FileOutputStream("E:/邮箱/接受数据/huancun.txt");
		clear.close();
		BufferedReader in = new BufferedReader(new FileReader("E:/邮箱/收件夹/canshu.txt"));
		String zhanghuming=in.readLine();
		in.close();
		filemail.receivemailbox0(zhanghuming);	
		String filename="E:/邮箱/收件夹/receivemailbox0.txt";
		socketsend a1=new socketsend(filename);
		//socket从登陆文件夹中将请求发出            0
		//传送结果                                                  1
	}

}
