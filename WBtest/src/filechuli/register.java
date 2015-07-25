package filechuli;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class register {

	public static void main(String[] args) throws IOException {
		FileOutputStream clear=new FileOutputStream("E:/邮箱/接受数据/huancun.txt");
		clear.close();
		BufferedReader in = new BufferedReader(new FileReader("E:/邮箱/注册/canshu.txt"));
		String zhanghuming=in.readLine();
		String mima=in.readLine();
		in.close();
		filemail.registermail(zhanghuming, mima);
		String filename="E:/邮箱/注册/registermail.txt";
		socketsend a1=new socketsend(filename);
		//socket从登陆文件夹中将请求发出            0
		//传送结果                                                  1
		/*FileOutputStream out=new FileOutputStream("E:/邮箱/注册/jieguo.txt");
		PrintStream p=new PrintStream(out);	
		String jieguo = null;//这里由socket返回
		p.println(jieguo);
		p.close();
		out.close();*/
		
	}

}
