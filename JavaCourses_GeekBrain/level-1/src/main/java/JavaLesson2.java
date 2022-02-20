public class JavaLesson2 {
    public static void main(String[] args) {
        System.out.println(isSumInTheInterval(10, 10));
        System.out.println(isNumPositiveOrNegative(-1));
        System.out.println(isNumPositiveOrNegativeBoolean(0));

        showTextWithCountOfRecords("текст для теста", 5);

        System.out.println(isYearLeapYear(2022));
    }

    public static boolean isSumInTheInterval(int num1, int num2) {
        if ((num1 + num2) > 9 && (num1 + num2) < 21){
            return true;
        } else {
            return false;
        }
    }

    public static String isNumPositiveOrNegative(int num){
        if (num > 0){
            return "положительное";
        } else {
            return "отрицательное";
        }
    }

    public static boolean isNumPositiveOrNegativeBoolean(int num){
        if (num > -1){
            return true;
        } else {
            return false;
        }
    }

    public static void showTextWithCountOfRecords(String txt, int count){
        for (int i = 0; i < count; i++){
            System.out.println(txt);
        }
    }

    public static boolean isYearLeapYear(int year){
        int initYear = year - year;
        int years;
        int leapYear = 4;
        int exclusionForTheLeapYear = 100;
        int exclusionForFourHundredYears = 400;

        for (int i=initYear; i<year+1; i++){
            years = i;
            if(((years>0) && (years % exclusionForFourHundredYears == 0)) && (years == year)){  // Исключение для каждого 400 года - Високосный год
                return true;
            } else if(((years>0) && (years % exclusionForTheLeapYear == 0)) && (years == year)){ // Исключение для каждого 100 года
                return false;
            } else if (((years>0) && (years % leapYear == 0)) && (years == year)){   // Високосный год - каждые 4 года
                return true;
            } else{
                continue;
            }
        }
        return false;
    }
}
