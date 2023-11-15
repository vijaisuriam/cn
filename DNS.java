import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Scanner;
import java.awt.Desktop;

public class DNS {
    static String getHostString(InetSocketAddress socketAddress) {
        InetAddress address = socketAddress.getAddress();
        if (address == null) {
            // The InetSocketAddress was specified with a string (either a numeric IP or a
            // host name). If
            // it is a name, all IPs for that name should be tried. If it is an IP address,
            // only that IP
            // address should be tried.
            return socketAddress.getHostName();
        }
        // The InetSocketAddress has a specific address: we should only try that
        // address. Therefore we
        // return the address and ignore any host name that may be available.
        return address.getHostAddress();
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter 1 to enter IP , 2 to enter domain name : ");
        String options = in.nextLine();
        if (options.equals("2")) {
            System.out.print("Enter website domain name : ");
        } else {
            System.out.print("Enter website IP : ");
        }
        String message;
        message = in.nextLine();
        Desktop desk = Desktop.getDesktop();
        InetAddress host = InetAddress.getByName(message);
        String q = host.toString();
        int k = q.indexOf('/');
        String ip = q.substring(k + 1);
        if (options.equals("2")) {
            System.out.println("The Domain IP is : " + ip);
        }
        String mesage = "http://" + message;
        desk.browse(new URI(mesage));
        in.close();
    }
}