package FR.utils;

import javax.swing.*;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.util.TimeZone;
import java.util.UUID;

public class Utils {
    public static final String JDBC_Driver_SQLite = "org.sqlite.JDBC";
    public static final String JDBC_URL_SQLite = String.format("jdbc:sqlite:%s",
            Paths.get(Utils.ooprogrammingdir(), "ooprogramming.sqlite").toString());
    //public  static final ImageIcon IMAGE = new ImageIcon("C:\\Users\\draxt\\IdeaProjects\\ProgettoFR\\src\\main\\java\\FR\\Aestethics\\logombe.jpg");
    public static final ImageIcon IMAGE = new ImageIcon("C:\\Users\\Giovanni\\IdeaProjects\\FRproject\\src\\main\\java\\FR\\Aestethics\\logombe.jpg");

    public static final String JDBC_Driver_MySQL = "com.mysql.cj.jdbc.Driver";
    /* public static final String JDBC_URL_MySQL = "jdbc:mysql://localhost:3306/MBE?user=admin&password=Inter2010&serverTimezone=" +
            TimeZone.getDefault().getID(); */

    public static final String JDBC_URL_MySQL = "jdbc:mysql://localhost:3306/MBE?user=afolloni&password=tB2021/n&serverTimezone=" +
            TimeZone.getDefault().getID();


    public static String ooprogrammingdir() {
        String path = String.format("%s%s%s%s%s", System.getProperty("user.home"), System.getProperty("file.separator"),
                "Desktop", System.getProperty("file.separator"), "ooprgramming");
        new File(path).mkdirs();
        return path;
    }

    public static UUID asUUID(byte[] bytes) {
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        long firstLong = bb.getLong();
        long secondLong = bb.getLong();
        return new UUID(firstLong, secondLong);
    }

    public static byte[] asBytes(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }
}
