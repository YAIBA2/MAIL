package filechuli;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class deletemail {
public static void main(String[] args) throws IOException {
	FileOutputStream clear=new FileOutputStream("E:/����/��������/huancun.txt");
	clear.close();
	BufferedReader in = new BufferedReader(new FileReader("E:/����/�ʼ�ɾ��/canshu.txt"));
	String zhanghuming=in.readLine();
	String mailID=in.readLine();
	in.close();
	filemail.deletemail0(zhanghuming, mailID);
	String filename="E:/����/�ʼ�ɾ��/deletemail0.txt";
	socketsend a1=new socketsend(filename);
	//socket�ӵ�½�ļ����н����󷢳�            0
	//���ͽ��                                                  1
	/*FileOutputStream out=new FileOutputStream("E:/����/�ʼ�ɾ��/jieguo.txt");
	PrintStream p=new PrintStream(out);	
	String jieguo = null;//������socket����
	p.println(jieguo);
	p.close();
	out.close();*/
}
}
