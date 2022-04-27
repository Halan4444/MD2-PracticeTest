import java.util.regex.Pattern;

public class Validate {

    public static final String NAME_REGEX = "^([A-Z]+[a-z]*[ ]?)+$";
    public static final int PHONE_REGEX = Integer.parseInt("^[1-9]{9}$");
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public static final String ADRESS_REGEX = "^([^. ][.]*[ ]?)+$";
    public static final String GENDER_REGEX = "^(NAM|NỮ)+$";
    public static final String DATE_REGEX = "\"\\\\d{1,2}[-|/]\\\\d{1,2}[-|/]\\\\d{4}\"";




    public static boolean isNameValid(String name) {
        return Pattern.compile(NAME_REGEX).matcher(name).matches();
    }

//    public static boolean isPhoneValid (int number) {
//        return Pattern.compile(PHONE_REGEX).matcher(number).matches();
//    }

    public static boolean isAddreeValid(String address){
        return Pattern.compile(ADRESS_REGEX).matcher(address).matches();
    }
    public static boolean isGender_Regex (String gender) {
        return Pattern.compile(GENDER_REGEX).matcher(gender).matches();
    }
    public static boolean isDate (String date) {
        return Pattern.compile(DATE_REGEX).matcher(date).matches();
    }


    public static boolean isEmailValid(String email){
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }
//    public static boolean isPasswordValid(String password){
//        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
//    }
}
