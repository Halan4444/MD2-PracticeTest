import java.util.List;
import java.util.Scanner;

public class Views {
    Scanner scanner = new Scanner(System.in);
    Service service = new Service();
    Menu menu =  new Menu();

    public Views() {
    }


    public void showContact() {
        System.out.println("Danh Sách Liên Lạc: ");
        System.out.println(" Đầu số +84 (Mã vùng VN)");
        List<Contact> contacts = service.getContacts();
        for (Contact contact : contacts) {
            System.out.printf("\t\t\t\t%-10s %-2s %-5s %-2s %-10s %-2s %-5s %-2s %-5s %-2s %-5s %-5s%-2s %-15s\n", contact.getPhoneNumber(),"|",contact.getContactGroup(),
                    "|",contact.getName(),"|", contact.getGender(),"|",  contact.getAddress(),"|",  contact.getDate(),"|",  contact.getEmail(),"|");
        }
        menu.boss();
    }

    public void findPhonenumberByNameBoss() {
        System.out.print("Nhập tên người cần tìm: ");
        scanner.nextLine();
        String name = scanner.nextLine().toUpperCase();
        boolean found = false;
        List<Contact> p = service.getContacts();
        for (Contact contact : p) {
            if (contact.getName().toUpperCase().contains(name)) {
                System.out.printf("\t\t\t\t%-10s %-2s %-25s %-2s %-30s %-2s %-15s %-2s %-25s %-2s %-11s %-15s%-2s %-11s\n", contact.getPhoneNumber(),"|",contact.getContactGroup(),
                        "|",contact.getName(),"|", contact.getGender(),"|",  contact.getAddress(),"|",  contact.getDate(),"|",  contact.getEmail(),"|");

                found = true;
            }
        }
        if (!found) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t ✖ Không có người này ✖");
        }
//        System.out.println("\t\t\t\t=========================================================================================================================");
        menu.boss();
    }

    public void add() {
        int phoneNumber;
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Nhập số điện thoại muốn thêm : ");
            System.out.print("\t➺ ");
            try {
                phoneNumber = input.nextInt();
                if (phoneNumber >= 0) {
                    if (service.existPhoneNumber(phoneNumber)) {
                        System.out.println(" ❌ SDT này đã tồn tại ❌");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("\t ❌ Số điện thoại không được để bằng 0 ❌");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("\t ❌ Số điện thoại phải là 1 dãy 10 chữ số ❌");
                System.out.println();
            }
        }
        System.out.println("Nhập vào nhóm danh bạ mới: ");
        String contactGroup = scanner.nextLine();
        System.out.println("Nhập vào họ và tên mới: ");
        String name = scanner.nextLine();
        System.out.println("Nhập vào giới tính Nam/Nữ ");
        String gender = scanner.nextLine();
        System.out.println("Nhập vào địa chỉ mới ");
        String address = scanner.nextLine();
        System.out.println("Nhập vào ngày tháng năm sinh ví dự 2/12/1998 ");
        String date = scanner.nextLine();
        System.out.println("Nhập vào email dạng user@domain.com : ");
        String email = scanner.nextLine();
        Contact contact = new Contact (phoneNumber,contactGroup,name,gender,address,date,email);
        service.add(contact);
        System.out.println("✔ Bạn đã thêm danh bạ thành công ✔\n");
        System.out.println("DATA ==============================================================" +
                "=====================================================================================");
        menu.boss();
    }

    public void delete() {
        int phoneNumber;
            Scanner input = new Scanner(System.in);
            System.out.println("Nhập số điện thoại muốn xóa: ");
            System.out.print("\t➺ ");
            try {
                phoneNumber = input.nextInt();
               for (int i=0; i<service.getContacts().size();i++){
                   if (phoneNumber == service.getContacts().get(i).getPhoneNumber()){
                       System.out.println("Xóa số điện thoại này: " + service.getContacts().get(i).getPhoneNumber());
                       service.getContacts().remove(i);
                       service.save();
                       break;
                   }
                   else {
                       System.out.println("Không có có sdt này! ");
                       break;
                   }
               }
            } catch (Exception e) {
                System.out.println("\t ❌ Số điện thoại phải là 1 dãy 10 chữ số ❌");
                System.out.println();
            }
        menu.boss();
    }


    public void update() {
        int phoneNumber;
        Contact update = null;
        while (true) {
            System.out.println("Nhập số điện thoại cần sửa");
            System.out.print("\t➺ ");
            try {
                phoneNumber = Integer.parseInt(scanner.nextLine());
                if (phoneNumber > 0) {
                    if (service.existPhoneNumber(phoneNumber)) {
                        update = service.findContentByPhone(phoneNumber);
                        break;
                    } else {
                        System.out.println(" ❌ Sdt này không tồn tại ❌");
                    }
                } else {
                    System.out.println("\t ❌ Sdt phải lớn hơn 0 ❌");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("\t ❌ Sdt phải là 1 dãy 10 số ❌");
                System.out.println();
            }
        }
        noChange();
        while (true) {
            System.out.println("Nhập vào nhóm danh bạ mới: ");
            System.out.print("\t➺ ");
            try {
                String contactGroup = scanner.nextLine();
                if (!(contactGroup.equalsIgnoreCase("-1") )) {
                        update.setContactGroup(contactGroup);
                        break;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("\t ❌ Nhóm danh bạ phải là 1 chuỗi ❌");
                System.out.println();
            }
        }
        noChange();
        while (true) {
            System.out.println("Nhập họ và tên mới: ");
            System.out.print("\t➺ ");
            try {
                String name = scanner.nextLine();
                if (!(name.equalsIgnoreCase("-1"))) {
                        update.setName(name);
                        break;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("\t ❌ Họ và tên phải là 1 chuỗi ❌");
                System.out.println();
            }
        }
        noChange();
        while (true) {
            System.out.println("Nhập giới tính (Nam/Nữ) : ");
            System.out.print(" \t➺ ");
            String gender = scanner.nextLine();
            if (!(gender.equalsIgnoreCase("-1"))) {
                update.setGender(gender);
                break;
            } else {
                break;
            }
        }
        noChange();
        while (true) {
            System.out.println("Nhập địa chỉ mới : ");
            System.out.print(" \t➺ ");
            String address = scanner.nextLine();
            if (!(address.equalsIgnoreCase("-1"))) {
                update.setAddress(address);
                break;
            } else {
                break;
            }
        }
        noChange();
        while (true) {
            System.out.println("Nhập ngày sinh mới : ");
            System.out.print(" \t➺ ");
            String date = scanner.nextLine();
            if (!(date.equalsIgnoreCase("-1"))) {
                update.setDate(date);
                break;
            } else {
                break;
            }
        }
        noChange();
        while (true) {
            System.out.println("Nhập email mới : ");
            System.out.print(" \t➺ ");
            String email = scanner.nextLine();
            if (!(email.equalsIgnoreCase("-1"))) {
                update.setDate(email);
                break;
            } else {
                break;
            }
        }
        service.update(phoneNumber, update);
        System.out.println("✔ Bạn đã cập nhật danh bạ thành công ✔\n");
        System.out.println("DATA ==============================================================" +
                "=====================================================================================");
        menu.boss();
    }

    public void noChange() {
        System.out.println(" ⦿ Nếu không thay đổi gì thì nhập: -1 ⦿ ");
    }

    public void findByPhoneNumber() {
        System.out.print("Nhập số điện thoại cần tìm: ");
        int phoneNumber = scanner.nextInt();
        boolean found = false;
        List<Contact> p = service.getContacts();
        for (Contact contact: p) {
            if (contact.getPhoneNumber() == phoneNumber) {
                System.out.printf("\t\t\t\t%-10s %-2s %-25s %-2s %-30s %-2s %-15s %-2s %-25s %-2s %-11s %-15s%-2s %-11s\n", contact.getPhoneNumber(),"|",contact.getContactGroup(),
                        "|",contact.getName(),"|", contact.getGender(),"|",  contact.getAddress(),"|",  contact.getDate(),"|",  contact.getEmail(),"|");

                found = true;
            }
        }
        if (!found) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t ✖ Không có só điện thoại này ✖");
        }
        menu.boss();
    }

    public void search() {
        System.out.println("Nhập vào lựa chọn: ");
        System.out.println("1 để tìm theo số điện thoại ");
        System.out.println("2 để tìm theo tên người dùng ");
        int number = scanner.nextInt();
        switch (number) {
            case 1:
                findByPhoneNumber();
                break;
            case 2:
                findPhonenumberByNameBoss();
                break;
        }

    }






}
