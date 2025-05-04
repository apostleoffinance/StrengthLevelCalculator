import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double BW = getValidInput(sc, "Input your Body Weight (BW):", 500);
        double Sq = getValidInput(sc, "Input your Squat PR:", 1500);
        double BP = getValidInput(sc, "Input your Bench Press PR:", 800);
        double Dl = getValidInput(sc, "Input your Deadlift PR:", 1500);

        // Print summary
        System.out.println("\nSummary:");
        System.out.println("Body Weight: " + BW + " kg");
        System.out.println("Squat PR: " + Sq + " kg");
        System.out.println("Bench Press PR: " + BP + " kg");
        System.out.println("Deadlift PR: " + Dl + " kg");

        // Determine and display strength levels
        System.out.println("\nStrength Levels:");
        System.out.println("Your Squat Strength Level: " + getStrengthLevel(Sq, BW));
        System.out.println("Your Bench Press Strength Level: " + getStrengthLevel(BP, BW));
        System.out.println("Your Deadlift Strength Level: " + getStrengthLevel(Dl, BW));

        double totalLifted = Sq + BP + Dl;
        System.out.println("\n📊 Metrics:");
        System.out.printf("Total Lifted: %.1f kg\n", totalLifted);
        System.out.printf("Squat Ratio: %.2f | Bench Ratio: %.2f | Deadlift Ratio: %.2f\n",
                Sq / BW, BP / BW, Dl / BW);
        System.out.printf("Lift Distribution (%%): Squat %.1f%%, Bench %.1f%%, Deadlift %.1f%%\n",
                (Sq / totalLifted) * 100, (BP / totalLifted) * 100, (Dl / totalLifted) * 100);
    }

    public static double getValidInput(Scanner sc, String prompt, double maxAllowed) {
        double value = -1;

        while (true) {
            try {
                System.out.println(prompt);
                String input = sc.next();
                value = Double.parseDouble(input);

                if (value <= 0) {
                    System.out.println("❌ Please enter a number greater than 0.");
                } else if (value > maxAllowed) {
                    System.out.println("❌ That value seems unrealistic. Please enter a value below " + maxAllowed + ".");
                } else {
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a numeric value.");
            }
        }

        return value;
    }

    public static String getStrengthLevel(double lift, double bodyWeight) {
        double ratio = lift / bodyWeight;

        if (ratio < 0.75) return "Beginner";
        else if (ratio < 1.0) return "Novice";
        else if (ratio < 1.5) return "Intermediate";
        else if (ratio < 2.0) return "Advanced";
        else return "Elite";
    }
}
