public class Contact {
    private int phoneNumber;
    private String contactGroup;
    private String name;
    private String gender;
    private String address;
    private String date;
    private String email;

    public Contact() {
    }

    public Contact(int phoneNumber, String contactGroup, String name, String gender, String address, String date, String email) {
        this.phoneNumber = phoneNumber;
        this.contactGroup = contactGroup;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.date = date;
        this.email = email;
    }
    public Contact (String raw) {
        String [] strings = raw.split(",");
        this.phoneNumber = Integer.parseInt(strings[0]);
        this.contactGroup= strings[1];
        this.name = strings[2];
        this.gender = strings[3];
        this.address = strings[4];
        this.date = strings[5];
        this.email = strings[6];
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactGroup() {
        return contactGroup;
    }

    public void setContactGroup(String contactGroup) {
        this.contactGroup = contactGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {

        return phoneNumber + "," + contactGroup + "," + name + "," + gender+ "," + address + "," + date + "," + email ;

    }
}
