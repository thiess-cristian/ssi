import java.net.*;
import java.util.Arrays;

public class InternetAdresse {
	
	
  public static void main( String args[] ) {
    try {
      InetAddress iaddr = InetAddress.getByName( "google.it" );
      
	  System.out.println( iaddr.getHostName() + " : " +
                iaddr.getHostAddress() );
				
				
				
	  InetAddress[] arr = InetAddress.getAllByName( "google.it" );
	  System.out.println("arr: " + Arrays.asList(arr));
	  
    }
    catch (UnknownHostException e)
      { System.err.println( "Host nicht bekannt" ); }
  }
}
