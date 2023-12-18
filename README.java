import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class GetTimeFromInternet {

    private static final int NTP_PORT = 123;
    private static final long NTP_OFFSET = 2208988800L;

    public static void main(String[] args) throws IOException {
        InetAddress serverAddress = InetAddress.getByName("time.google.com");
        DatagramSocket socket = new DatagramSocket();
        byte[] request = new byte[48];
        DatagramPacket requestPacket = new DatagramPacket(request, request.length, serverAddress, NTP_PORT);
        socket.send(requestPacket); 
        byte[] response = new byte[48];
        DatagramPacket responsePacket = new DatagramPacket(response, response.length);
        socket.receive(responsePacket);
        long ntpTime = extractNtpTime(response);
        long javaTime = ntpTime - NTP_OFFSET;
        Date date = new Date(javaTime * 1000);
        System.out.println("Current time from internet: " + date);
        socket.close();
    }
    private static long extractNtpTime(byte[] response) {
        long result = 0;
        for (int i = 40; i < 48; i++) {
            result <<= 8;
            result |= response[i] & 0xff;
        }
        return result;
    }
}- 👋 Hi, I’m @ronittosteam50
- 👀 I’m interested in ...
- 🌱 I’m currently learning ...
- 💞️ I’m looking to collaborate on ...
- 📫 How to reach me ...

<!---
ronittosteam50/ronittosteam50 is a ✨ special ✨ repository because its `README.md` (this file) appears on your GitHub profile.
You can click the Preview link to take a look at your changes.
--->
