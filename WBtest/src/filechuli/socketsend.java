package filechuli;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class socketsend {
	public socketsend(String filename) throws IOException { 
        int length = 0;  
        double sumL = 0 ;  
        byte[] sendBytes = null;  
        byte[] inputByte = null;  
        Socket socket = null;  
        DataOutputStream dos = null;  
        DataInputStream dis = null;
        FileInputStream fis = null;  
        FileOutputStream fos = null; 
        String filePath = "E:/����/��������/huancun.txt";
        boolean bool = false;  
        try {  
            File file = new File(filename); //Ҫ������ļ�·��  
        	//String file="hello world";
            long l = file.length();   
            socket = new Socket();    
            socket.connect(new InetSocketAddress("10.8.166.222",1935));  
            dos = new DataOutputStream(socket.getOutputStream());  
            fis = new FileInputStream(file);        
            sendBytes = new byte[1024];    
            while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {  
                sumL += length;    
                System.out.println("�Ѵ��䣺"+((sumL/l)*100)+"%");  
                dos.write(sendBytes, 0, length);  
                dos.flush();  
                //socket.shutdownOutput();  
            }   
            socket.shutdownOutput();  
            //��Ȼ�������Ͳ�ͬ����JAVA���Զ�ת������ͬ�������ͺ������Ƚ�  
            String filePath1 = "E:/����/��������/huancun.txt";
            dis = new DataInputStream(socket.getInputStream());  
            fos = new FileOutputStream(new File(filePath));      
            inputByte = new byte[1024];     
            System.out.println("��ʼ��������...");    
            while ((length = dis.read(inputByte, 0, inputByte.length)) > 0) {  
                fos.write(inputByte, 0, length);  
                fos.flush();      
            }  
            //System.out.println("��ɽ��գ�"+filePath);
           /* InputStream ips = socket.getInputStream();  
            byte[] rebyte = readStream(ips);  
            String remess = new String(rebyte);
            System.out.println(remess);
            String remess1 = remess.replace("\\n", "\r\n");
            fos = new FileOutputStream(new File(filePath));
            PrintStream p=new PrintStream(fos);*/
            /*for (int i = 0; i < remess1.length; i++) {
            	System.out.println(remess1[i]);
				p.println(remess1[i]);
			}
            p.println(remess1);
            p.close();
            //System.out.println(remess);*/
            
            if(sumL==l){  
                bool = true;  
            }  
        }catch (Exception e) {  
            System.out.println("�ͻ����ļ������쳣");  
            bool = false;  
            e.printStackTrace();    
        } finally{    
            if (dos != null)  
                dos.close();  
            if (fis != null)  
                fis.close();    
            if (fos != null)  
                fos.close();  
            if (dis != null)  
                dis.close();  
            if (socket != null)  
                socket.close();      
        }  
        //System.out.println(bool?"�ɹ�":"ʧ��");  
    }
	public static byte[] readStream(InputStream inStream) throws Exception {  
        int count = 0;  
        while (count == 0) {  
            count = inStream.available();  
        }  
        byte[] b = new byte[count];  
        inStream.read(b);  
        return b;  
    }  
}
