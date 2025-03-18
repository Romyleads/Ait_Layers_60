package utils;

/*** Author: Roman Romashko Date: 18.03.2025 ***/

public class UserValidation {

    public static boolean isEmailValid(String email) {

//1. Проверка на наличие одной собачки @
        int indexAt = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        if (indexAt==-1 || indexAt!=lastAt) {return false;}

//2. Проверка на точку после собаки
        int dotIndexAfterAt = email.indexOf('.', indexAt+1);
        if (dotIndexAfterAt==-1) {return false;}

//3. после последней точки есть 2 или более символов
        int lastDotIndex = email.lastIndexOf('.');
        if (lastDotIndex>=email.length()-2) {return false;}

//4.  Алфавит, цифры, точка, дефис, подчеркивание, тире
// for (int i = 0; i < email.length(); i++) {
//   char c = email.charAt(i);

//string.toCharArray() -> char[]
        for (char ch : email.toCharArray()) {

// проверка символа на допустимость
            boolean isPass = ch == '-' || ch == '_' || Character.isAlphabetic(ch) || ch == '.'|| ch == '@' || Character.isDigit(ch);
            if (!isPass) {return false;}
        }


//5. До собаки должен быть хотя бы один символ
        if (indexAt==0) {return false;}

//6. Первый символ - должен быть буквой. Символ с индексом 0 - буква
        if (!Character.isLetter(email.charAt(0))) {return false;}

        return true;
    }
    // Проверка пароля:
    //1. Длина пароля не менее 8 символов
    //2. Пароль содержит хотя бы одну цифру
    //3. Пароль содержит хотя бы одну малую букву
    //4. Пароль содержит хотя бы одну большую букву
    //5. Пароль содержит хотя бы один спецсимвол "!%$@&*()[]#:;-.,"

    //Пароль должен удовлетворять всем условиям
    //5 boolean переменных/флагов Каждая отвечает за свой пункт
    // Если все проверки пройдены, пароль подходит

    public static boolean isPasswordValid(String password) {

        boolean has8chars = false;
        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;
        String specialChars = "!%$@&*()[],.-";

        if (password.length() >= 8) has8chars=true;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) hasDigit = true;
            if (Character.isLowerCase(ch)) hasLower = true;
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (specialChars.indexOf(ch) != -1) hasSpecial = true;
        }
        return has8chars && hasDigit && hasLower && hasUpper && hasSpecial ;
    }
}


