import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Nifdemo {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                
                System.out.println("Name: " + networkInterface.getName());
                System.out.println("Display Name: " + networkInterface.getDisplayName());
                System.out.println("Index: " + networkInterface.getIndex());
                System.out.println("Hardware Address: " + formatMACAddress(networkInterface.getHardwareAddress()));
                System.out.println("MTU: " + networkInterface.getMTU());
                System.out.println("Parent: " + (networkInterface.getParent() != null ? networkInterface.getParent().getName() : "None"));
                System.out.println("Is Up: " + networkInterface.isUp());
                System.out.println("Is Loopback: " + networkInterface.isLoopback());
                System.out.println("Is Point-to-Point: " + networkInterface.isPointToPoint());
                System.out.println("Supports Multicast: " + networkInterface.supportsMulticast());
                System.out.println("Is Virtual: " + networkInterface.isVirtual());
                
                Enumeration<NetworkInterface> subInterfaces = networkInterface.getSubInterfaces();
                while (subInterfaces.hasMoreElements()) {
                    NetworkInterface subInterface = subInterfaces.nextElement();
                    System.out.println("Subinterface: " + subInterface.getName());
                }
                
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private static String formatMACAddress(byte[] macAddress) {
        if (macAddress == null) {
            return "None";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < macAddress.length; i++) {
            sb.append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? ":" : ""));
        }
        return sb.toString();
    }
}
