import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	public static Hashtable<Integer, Hashtable<Integer, Socket>> tableList = new Hashtable<Integer, Hashtable<Integer,Socket>>();
	public static Hashtable<Integer, Socket> hashTable = new Hashtable<Integer, Socket>();
	public static int tableListCounts = 0;
	
	public void go() {
		ServerSocket ss = null;
		Socket s = null;
		int maxClientPerRomm = 4;
		
		int clientIndex = 0;

		try {
			ss = new ServerSocket(6666);
			System.out.println("**서버 실행**");
			// 다수의 클라이언트와 통신하기 위해 loop
			while (true) {
				s = ss.accept(); // 클라이언트 접속시 새로운 소켓이 리턴
				Server.hashTable.put(clientIndex, s);
				ServerThread st = new ServerThread(s, clientIndex);
				st.start();
				System.out.println(clientIndex + "님 입장");
				++clientIndex;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			try {
			if (s != null)
				s.close();
			if (ss != null)
				ss.close();
			}
			catch(Throwable e) {
				e.printStackTrace();
			}
			System.out.println("**서버 종료**");
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.go();

	}

}
