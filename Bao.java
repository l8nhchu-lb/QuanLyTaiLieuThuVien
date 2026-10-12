
public class Bao extends TaiLieu {
    private String ngayPhatHanh;

    public Bao(String maTaiLieu, String tenNhaXuatBan,
               int soBanPhatHanh, String ngayPhatHanh) {
        super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    @Override
    public String getLoai() {
        return "Bao";
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.println("Ngay phat hanh: " + ngayPhatHanh);
    }
}
