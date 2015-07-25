package filechuli;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class loginmail {

	public static void main(String[] args) throws IOException {
		FileOutputStream clear=new FileOutputStream("E:/邮箱/登陆/jieguo.txt");
		clear.close();
		FileOutputStream clear1=new FileOutputStream("E:/邮箱/接受数据/huancun.txt");
		clear1.close();
		BufferedReader in = new BufferedReader(new FileReader("E:/邮箱/登陆/canshu.txt"));
		String zhanghuming=in.readLine();
		String mima=in.readLine();
		in.close();
		filemail.loginmail0(zhanghuming,mima);	
		String filename="E:/邮箱/登陆/loginmail0.txt";
		socketsend a1=new socketsend(filename);
		//socket从登陆文件夹中将请求发出            
		//socketreceive.receivesocket();
		//传送结果                                                  1
		BufferedReader in1 = new BufferedReader(new FileReader("E:/邮箱/接受数据/huancun.txt"));
		String zhuangtai=in1.readLine();
		if(Integer.parseInt(zhuangtai)==0){
			String key;
			StringBuffer sb1 = new StringBuffer();
			while ((key = in1.readLine())!=null) {
				sb1.append(key);
			}
			key=sb1.toString();
			//System.out.println(key);
			FileOutputStream out=new FileOutputStream("E://邮箱/接受密钥/RSA_priv.dat");
			PrintStream p=new PrintStream(out);
			p.println(key);
			p.close();
			out.close();
			in1.close();FileOutputStream out2=new FileOutputStream("E:/邮箱/登陆/jieguo.txt");
			PrintStream p1=new PrintStream(out2);	
			p1.println("0");
			p1.close();
			out2.close();
			return;
		}
		if(Integer.parseInt(zhuangtai)==1){
			FileOutputStream out=new FileOutputStream("E:/邮箱/登陆/jieguo.txt");
			PrintStream p=new PrintStream(out);	
			p.println("1");
			p.close();
			out.close();
			return;
		}
		if(Integer.parseInt(zhuangtai)==2){
			FileOutputStream out=new FileOutputStream("E:/邮箱/登陆/jieguo.txt");
			PrintStream p=new PrintStream(out);	
			p.println("2");
			p.close();
			out.close();
			return;
		}
		if(Integer.parseInt(zhuangtai)==9){
			FileOutputStream out=new FileOutputStream("E:/邮箱/登陆/jieguo.txt");
			PrintStream p=new PrintStream(out);	
			p.println("9");
			p.close();
			out.close();
			return;
		}
		
		/*BufferedReader in1 = new BufferedReader(new FileReader("E:/邮箱/发送邮件/canshu.txt"));
		String zhuangtai=in.readLine();
		FileOutputStream out=new FileOutputStream("E:/邮箱/注册/jieguo.txt");
		PrintStream p=new PrintStream(out);	
		String jieguo = null;//这里由socket返回
		p.println(jieguo);
		p.close();
		out.close();*/
		
	}

}
