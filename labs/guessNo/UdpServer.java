import java.net.*;
import java.util.Random;
import java.io.IOException;

public class UdpServer {
  private static final java.text.DateFormat DF = java.text.DateFormat.getDateTimeInstance();
  private static String getTime() {
    return DF.format(new java.util.Date());
  }
  
  
  public static void main(String[] args) {
	  System.out.println("Server Start ..");
	  
	  int ghicesteNr = 1 + (int)(Math.random() * 99);
	  
  	try {
      DatagramSocket ds = new DatagramSocket(4711);
      DatagramPacket dp = new DatagramPacket(new byte[120], 120);
      String resp;
      System.out.println("De ghicit:" + ghicesteNr);
      while (true) {
        ds.receive(dp);
        String strPrimit = new String(dp.getData()).trim();
        System.out.println("Am primit de la client " + "   " + strPrimit + " von Port " + dp.getPort());
        int nr = Integer.parseInt(strPrimit);
        if (ghicesteNr < nr) {
        	// mai mic
        	resp = " <";
        } else {
        	if (ghicesteNr > nr) {
        		// mai mare
        		resp = " >";	
        	} else  {
        		// ok
        		resp = "ok";
        	}
        }
        System.out.println("Timp trimitere: " +  getTime()); 
        dp.setData(resp.getBytes());
        ds.send(dp);        
      }

      
    } catch (SocketException e) { e.printStackTrace();}
	  catch (IOException e) { e.printStackTrace();}
  }
}
