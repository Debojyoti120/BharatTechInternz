import java.util.Scanner;
public class CGPA_converter {
    public static double convertToPercentage(double cgpa) {
        // Conversion formula: CGPA * 9.5 = Percentage
        return cgpa * 9.5;
}
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your CGPA: ");
        double userCGPA = scanner.nextDouble();

        // Convert CGPA to percentage
        double percentage = convertToPercentage(userCGPA);

        System.out.println("Your CGPA " + userCGPA + " is equivalent to " + percentage + "% in percentage.");

        scanner.close();
    }
}