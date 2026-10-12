
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyTaiLieu ql = new QuanLyTaiLieu(sc);

        while (true) {
            System.out.println("\n===== QUAN LY TAI LIEU THU VIEN =====");
            System.out.println("1. Them moi tai lieu");
            System.out.println("2. Xoa tai lieu theo ma");
            System.out.println("3. Hien thi tat ca tai lieu");
            System.out.println("4. Tim kiem tai lieu theo loai");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Nhap lua chon: ");

            String luaChon = sc.nextLine().trim();

            switch (luaChon) {
                case "1":
                    ql.themTaiLieu();
                    break;

                case "2":
                    ql.xoaTaiLieu();
                    break;

                case "3":
                    ql.hienThiTatCa();
                    break;

                case "4":
                    ql.timTheoLoai();
                    break;

                case "0":
                    System.out.println("Da thoat chuong trinh!");
                    sc.close();
                    return;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
