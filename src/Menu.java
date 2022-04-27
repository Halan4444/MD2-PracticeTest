import java.util.Scanner;

public class Menu {

    static Views views = new Views();
    static Scanner scanner = new Scanner(System.in);

    public static void boss(){
        menuBoss();
        try {
            System.out.println("\nChọn chức năng ");
            System.out.print("\t➺ ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    views.showContact();
                    break;
                case 2:
                    views.add();
                    break;
                case 3:
                    views.update();
                    break;
                case 4:
                    views.delete();
                    break;
                case 5:
                    views.search();
                    break;
                case 6:
                    System.out.println("Đọc file đã ghi: ");
                    views.showContact();
                    break;
                case 7:
                    System.out.println("File được ghi liên tục vào Csv sau mỗi lần thêm, sửa, xóa: ");
                    views.showContact();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("▲ Chọn chức năng không đúng! Vui lòng chọn lại ▲");
                    boss();
            }
        } catch (Exception e) {
            System.out.println("Nhập sai! vui lòng nhập lại");
            boss();
        }
    }
    public static void menuBoss() {
        System.out.println("⚪ ⚪ ⚪ CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪");
        System.out.println("⚪     Chọn chức năng theo số để tiếp tục        ⚪");
        System.out.println("⚪     1. Xem danh sách                          ⚪");
        System.out.println("⚪     2. Thêm mới                               ⚪");
        System.out.println("⚪     3. Cập nhật                               ⚪");
        System.out.println("⚪     4. Xóa                                    ⚪");
        System.out.println("⚪     5. Tìm kiếm                               ⚪");
        System.out.println("⚪     6. Đọc từ file                            ⚪");
        System.out.println("⚪     7. Ghi vào file                           ⚪");
        System.out.println("⚪     8. Exit                                   ⚪");
        System.out.println("⚪                                               ⚪");
        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪  ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪  ⚪");
    }




}
