
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyTaiLieu {
    private ArrayList<TaiLieu> danhSach = new ArrayList<>();
    private Scanner sc;

    public QuanLyTaiLieu(Scanner sc) {
        this.sc = sc;
    }

    private String nhapChuoi(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            String s = sc.nextLine().trim();

            if (!s.isEmpty()) {
                return s;
            }

            System.out.println("Khong duoc de trong!");
        }
    }

    private int nhapSoNguyen(String thongBao, int min, int max) {
        while (true) {
            System.out.print(thongBao);

            try {
                int n = Integer.parseInt(sc.nextLine().trim());

                if (n >= min && n <= max) {
                    return n;
                }

                System.out.println("Vui long nhap so tu "
                        + min + " den " + max + "!");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap mot so nguyen!");
            }
        }
    }

    private boolean maDaTonTai(String ma) {
        for (TaiLieu tl : danhSach) {
            if (tl.getMaTaiLieu().equalsIgnoreCase(ma)) {
                return true;
            }
        }

        return false;
    }

    private String nhapMaMoi() {
        while (true) {
            String ma = nhapChuoi("Nhap ma tai lieu: ");

            if (!maDaTonTai(ma)) {
                return ma;
            }

            System.out.println("Ma tai lieu da ton tai!");
        }
    }

    public void themTaiLieu() {
        System.out.println("\n--- THEM TAI LIEU ---");
        System.out.println("1. Sach");
        System.out.println("2. Tap chi");
        System.out.println("3. Bao");

        int loai = nhapSoNguyen("Chon loai tai lieu: ", 1, 3);

        String ma = nhapMaMoi();
        String nxb = nhapChuoi("Nhap ten nha xuat ban: ");
        int soBan = nhapSoNguyen(
                "Nhap so ban phat hanh: ", 1, 1000000);

        switch (loai) {
            case 1:
                String tacGia = nhapChuoi("Nhap ten tac gia: ");
                int soTrang = nhapSoNguyen(
                        "Nhap so trang: ", 1, 1000000);

                danhSach.add(
                        new Sach(ma, nxb, soBan, tacGia, soTrang));
                break;

            case 2:
                int soPhatHanh = nhapSoNguyen(
                        "Nhap so phat hanh: ", 1, 1000000);
                int thang = nhapSoNguyen(
                        "Nhap thang phat hanh (1-12): ", 1, 12);

                danhSach.add(
                        new TapChi(ma, nxb, soBan,
                                soPhatHanh, thang));
                break;

            case 3:
                String ngay = nhapChuoi(
                        "Nhap ngay phat hanh (dd/MM/yyyy): ");

                danhSach.add(new Bao(ma, nxb, soBan, ngay));
                break;
        }

        System.out.println("Them tai lieu thanh cong!");
    }

    public void xoaTaiLieu() {
        System.out.println("\n--- XOA TAI LIEU ---");
        String ma = nhapChuoi("Nhap ma tai lieu can xoa: ");

        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaTaiLieu()
                    .equalsIgnoreCase(ma)) {
                danhSach.remove(i);
                System.out.println("Xoa tai lieu thanh cong!");
                return;
            }
        }

        System.out.println("Khong tim thay ma tai lieu!");
    }

    public void hienThiTatCa() {
        System.out.println("\n--- DANH SACH TAI LIEU ---");

        if (danhSach.isEmpty()) {
            System.out.println("Danh sach tai lieu dang rong!");
            return;
        }

        for (TaiLieu tl : danhSach) {
            System.out.println("-------------------------");
            tl.hienThi();
        }
    }

    public void timTheoLoai() {
        System.out.println("\n--- TIM KIEM THEO LOAI ---");
        System.out.println("1. Sach");
        System.out.println("2. Tap chi");
        System.out.println("3. Bao");

        int loai = nhapSoNguyen("Chon loai can tim: ", 1, 3);

        String loaiCanTim;

        switch (loai) {
            case 1:
                loaiCanTim = "Sach";
                break;
            case 2:
                loaiCanTim = "Tap chi";
                break;
            default:
                loaiCanTim = "Bao";
                break;
        }

        boolean timThay = false;

        for (TaiLieu tl : danhSach) {
            if (tl.getLoai().equals(loaiCanTim)) {
                System.out.println("-------------------------");
                tl.hienThi();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong co tai lieu thuoc loai nay!");
        }
    }
}
