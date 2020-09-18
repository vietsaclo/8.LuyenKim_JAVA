package _modul;

import java.util.Scanner;

public class io {

    public static Scanner ip = new Scanner(System.in);

    public static int ScanInt(String str) {
        System.out.print(str + "=> ");
        try {
            return Integer.parseInt(ip.nextLine());
        } catch (Exception e) {
            System.err.println("Nhap Sai Dinh Dang");
        }
        return 0;
    }

    public static float ScanFloat(String str) {
        System.out.print(str + "=> ");
        try {
            return Float.parseFloat(ip.nextLine());
        } catch (Exception e) {
            System.err.println("Nhap Sai Dinh Dang");
        }
        return 0;
    }

    public static double ScanDouble(String str) {
        System.out.print(str + "=> ");
        try {
            return Double.parseDouble(ip.nextLine());
        } catch (Exception e) {
            System.err.println("Nhap Sai Dinh Dang");
        }
        return 0;
    }

    public static String ScanStr(String str) {
        System.out.print(str + "=> ");
        return ip.nextLine();
    }
}
