package filechuli;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class sockettest {

	public static void main(String[] args) throws IOException {
		//socketreceive.receivesocket();
		/*String filename="E:/����/�����ʼ�/buildsendmail1.txt";
		socketsend a1=new socketsend(filename);
		String filename1="E:/����/�����ʼ�/buildsendmail2.txt";*/
		/*socketsend a2=new socketsend(filename1);
		String filename2="E:/����/�����ʼ�/buildsendmail3.txt";
		socketsend a3=new socketsend(filename2);
		/*String filename3="E:/����/�����ʼ�/buildsendmail4.txt";
		socketsend a4=new socketsend(filename3);*/
		FileOutputStream out=new FileOutputStream("E:/����/�����ʼ�/jieguo.txt");
		out.close();

	}

}
