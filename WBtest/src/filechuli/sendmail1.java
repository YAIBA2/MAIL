package filechuli;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import RSA.RSAUtils1;

public class sendmail1 {

	public static void main(String[] args) throws IOException {
		
			// TODO Auto-generated method stub
			FileOutputStream clear=new FileOutputStream("E:/����/�����ʼ�/jieguo.txt");
			clear.close();
			FileOutputStream clear1=new FileOutputStream("E:/����/��������/huancun.txt");
			clear1.close();
			//BufferedReader in = new BufferedReader(new FileReader("E:/����/�����ʼ�/canshu.txt"));
			InputStreamReader read = new InputStreamReader(
	                new FileInputStream("E:/����/�����ʼ�/canshu.txt"),"UTF-8");//���ǵ������ʽ
	                BufferedReader in = new BufferedReader(read);
			String fajianren=in.readLine();
			String shoujianren=in.readLine();
			String zhuti=in.readLine();
			String mail;
			StringBuffer sb = new StringBuffer(); 
			System.out.println(zhuti);
			while ((mail = in.readLine())!=null) {
				//System.out.println(mail);
				sb.append(mail+"\r\n");
			}
			in.close();
			mail=sb.toString();	
			System.out.println(mail);
			int hash=mail.hashCode();
			String hashcode=String.valueOf(hash);
			System.out.println(hash);
			//ǩ������
			BufferedReader in3 = new BufferedReader(new FileReader("E://����/������Կ/RSA_priv.dat"));//����Կ
			String pri;
			StringBuffer sb2 = new StringBuffer(); 
			while ((pri = in3.readLine())!=null) {
				System.out.println(pri);
				sb2.append(pri);
			}
			in3.close();
			pri=sb2.toString();
			String hashtest = RSAUtils1.encrypt1(hashcode,RSAUtils1.getPrivateKey(pri));
			System.out.println(hashtest);
			
			//System.out.println(mail);
			filemail.buildsendmail0(fajianren, shoujianren);
			String filename="E:/����/�����ʼ�/buildsendmail0.txt";
			socketsend a=new socketsend(filename);
			//
			//
			BufferedReader in1 = new BufferedReader(new FileReader("E:/����/��������/huancun.txt"));
			String zhuangtai=in1.readLine();
			if(Integer.parseInt(zhuangtai)==0){
				String key;
				StringBuffer sb1 = new StringBuffer();
				while ((key = in1.readLine())!=null) {
					sb1.append(key);
				}
				key=sb1.toString();
				//System.out.println(key);
				/*FileOutputStream out=new FileOutputStream("E://����/������Կ/RSA_publ1.dat");
				PrintStream p=new PrintStream(out);
				p.println(key);
				p.close();
				out.close();*/
				String cipherText = RSAUtils1.encrypt(mail, 
						RSAUtils1.getPublicKey(key)); 
				filemail.buildsendmail1(fajianren, shoujianren, zhuti, cipherText,hashtest);
				in1.close();
				String filename1="E:/����/�����ʼ�/buildsendmail1.txt";
				socketsend a2=new socketsend(filename1);
				BufferedReader in2 = new BufferedReader(new FileReader("E:/����/��������/huancun.txt"));
				String biaoshi=in2.readLine();
				in2.close();
				FileOutputStream out=new FileOutputStream("E:/����/�����ʼ�/jieguo.txt");
				PrintStream p=new PrintStream(out);	
				p.println(biaoshi);
				p.close();
				out.close();
			}
			if(Integer.parseInt(zhuangtai)==1){
				FileOutputStream out=new FileOutputStream("E:/����/�����ʼ�/jieguo.txt");
				PrintStream p=new PrintStream(out);	
				p.println("1");
				p.close();
				out.close();
				in1.close();
				return;
			}
			if(Integer.parseInt(zhuangtai)==9){
				FileOutputStream out=new FileOutputStream("E:/����/�����ʼ�/jieguo.txt");
				PrintStream p=new PrintStream(out);	
				p.println("9");
				p.close();
				out.close();
				in1.close();
				return;
			}
		}
	

}
