import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Strings_Cycles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 4.1.
        System.out.println("4.1. Счётчик сколько раз подстрока встречается в строке");
        System.out.println("Введите строку:");
        String inputString = scanner.nextLine();
        System.out.println("Введите подстроку:");
        String subString = scanner.nextLine();

        int count = counter(inputString, subString);
        System.out.println("Подстрока '" + subString + "' встречается " + count + " раза");
        System.out.println();

        // 4.2.
        System.out.println("4.2. Цензура");
        System.out.println("Введите строку:");
        String censoredString = scanner.nextLine();
        censoredString = censorWords(censoredString, "кака", "бяка");
        System.out.println(censoredString);
        System.out.println();

        // 4.3.
        System.out.println("4.3. Преобразование формата даты");
        System.out.println("Введите дату в формате 'дд.мм.гггг':");
        String dateString = scanner.nextLine();
        String formattedDate = formatDateString(dateString);
        System.out.println(formattedDate);
        System.out.println();

        // 4.4.
        System.out.println("4.4. Преобразование формата даты (Date и SimpleDateFormat)");
        System.out.println("Введите дату в формате 'дд.мм.гггг':");
        String dateString2 = scanner.nextLine();
        String formattedDate2 = formatDateWithDateFormat(dateString2);
        System.out.println(formattedDate2);
        System.out.println();

        scanner.close();
    }

    // 4.1.
    public static int counter(String text, String subString) {
        int count = 0;
        int startIndex = 0;
        while (startIndex != -1) {
            startIndex = text.indexOf(subString, startIndex);
            if (startIndex != -1) {
                count++;
                startIndex += subString.length();
            }
        }
        return count;
    }

    // 4.2.
    public static String censorWords(String text, String word1, String word2) {
        String censored = "вырезано цензурой";
        text = text.replaceAll(word1, censored);
        text = text.replaceAll(word2, censored);
        return text;
    }

    // 4.3.
    public static String formatDateString(String date) {

        String day = date.substring(0, 2);
        String month = date.substring(3, 5);
        String year = date.substring(6, 10);

        int Dayint = Integer.parseInt(day);
        int Mounthint = Integer.parseInt(month);
        if (Dayint>=1 && Dayint<=31 && Mounthint>=1 && Mounthint<=12) {
            return year + "-" + month + "-" + day;
        } else{
            System.out.println("Некорректное значение  дня и месяца");
            return null;
        }
    }

    // 4.4.
    public static String formatDateWithDateFormat(String dateString) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(dateString);

            SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
            String dayString = dayFormat.format(date);
            int day = Integer.parseInt(dayString);

            SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
            String monthString = monthFormat.format(date);
            int month = Integer.parseInt(monthString);

            if (day < 1 || day > 31 || month < 1 || month > 12) {
                System.err.println("Некорректное значение  дня и месяца.");
                return null;
            } return outputFormat.format(date);
        } catch (ParseException e) {
            System.err.println("Некорректный формат даты!");
            return null;
        }
    }
}
