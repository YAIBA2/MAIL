package filechuli;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class register {

	public static void main(String[] args) throws IOException {
		FileOutputStream clear=new FileOutputStream("E:/����/��������/huancun.txt");
		clear.close();
		BufferedReader in = new BufferedReader(new FileReader("E:/����/ע��/canshu.txt"));
		String zhanghuming=in.readLine();
		String mima=in.readLine();
		in.close();
		filemail.registermail(zhanghuming, mima);
		String filename="E:/����/ע��/registermail.txt";
		socketsend a1=new socketsend(filename);
		//socket�ӵ�½�ļ����н����󷢳�            0
		//���ͽ��                                                  1
		/*FileOutputStream out=new FileOutputStream("E:/����/ע��/jieguo.txt");
		PrintStream p=new PrintStream(out);	
		String jieguo = null;//������socket����
		p.println(jieguo);
		p.close();
		out.close();*/
		
	}

}
