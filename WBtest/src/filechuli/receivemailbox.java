package filechuli;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class receivemailbox {

	public static void main(String[] args) throws IOException {
		FileOutputStream clear=new FileOutputStream("E:/����/��������/huancun.txt");
		clear.close();
		BufferedReader in = new BufferedReader(new FileReader("E:/����/�ռ���/canshu.txt"));
		String zhanghuming=in.readLine();
		in.close();
		filemail.receivemailbox0(zhanghuming);	
		String filename="E:/����/�ռ���/receivemailbox0.txt";
		socketsend a1=new socketsend(filename);
		//socket�ӵ�½�ļ����н����󷢳�            0
		//���ͽ��                                                  1
	}

}
