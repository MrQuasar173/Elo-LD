public class RoundingClass {
    public static double roundTwoDigits(double x){
        return (double) (Math.round(x * 100)) / 100;
    }
}
