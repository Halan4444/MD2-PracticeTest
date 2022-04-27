import java.util.ArrayList;
import java.util.List;

public class Service {

    List<Contact> contactList = new ArrayList<>();
    public static  String path = "F:\\Thucthicode\\AirlineReservation-master\\Test2bc\\src\\data\\contact.csv";

    public void add(Contact newContact) {
        contactList.add(newContact);
        CSVUtils.write(path, contactList);
    }
    public void save() {
        CSVUtils.write(path, contactList);
    }


    public void update(int phoneNumber, Contact updateContact) {
        getContacts();
        for (int i = 0; i < contactList.size(); i++) {
            if(contactList.get(i).getPhoneNumber() == phoneNumber){
                contactList.set(i,updateContact);
                CSVUtils.write(path, contactList);
            }
        }
    }


    public List<Contact> getContacts() {
        List<Contact> newContactList = new ArrayList<>();
        List<String> reads = CSVUtils.read(path);
        for (String read:reads) {
            newContactList.add(new Contact(read));
        }
        return contactList = newContactList;
    }

    public void delete (int phoneNumber, Contact newContact) {
        getContacts();
        Contact contact = findContentByPhone(phoneNumber);
        contactList.remove(contact);
        CSVUtils.write(path, contactList);
    }


    public void updateGroup(int phoneNumber, String group) {
        getContacts();
        for (int i = 0; i < contactList.size(); i++) {
            if(contactList.get(i).getPhoneNumber() == phoneNumber){
                contactList.get(i).setContactGroup(group);
                CSVUtils.write(path, contactList);
            }
        }
    }

    public String getGroup(int phoneNumber) {
        getContacts();
       String group = null;
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber() == phoneNumber) {
                group =contact.getContactGroup();
            }
        }
        return group;
    }

    public boolean existPhoneNumber(int phoneNumber){
        getContacts();
        for (Contact contact: contactList) {
            if (contact.getPhoneNumber() == phoneNumber){
                return true;
            }
        }
        return false;
    }

    public boolean existName (String name){
        getContacts();
        for (Contact contact: contactList) {
            if (contact.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public Contact findContentByPhone(int phoneNumber){
        getContacts();
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber() == phoneNumber){
                return contact;
            }
        }
        System.out.println("\t\t\t\tKhông có số điện thoại này!");
        return null;
    }


}
