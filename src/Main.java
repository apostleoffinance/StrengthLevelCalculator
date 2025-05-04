import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        printBanner("Welcome to the Strength Level Calculator 💪");

        double BW = getValidInput(sc, "👉 Enter your Body Weight (kg):", 500);
        double Sq = getValidInput(sc, "👉 Enter your Squat PR (kg):", 1500);
        double BP = getValidInput(sc, "👉 Enter your Bench Press PR (kg):", 800);
        double Dl = getValidInput(sc, "👉 Enter your Deadlift PR (kg):", 1500);

        int choice;
        do {
            printMenu();
            System.out.print("Select an option (1-3): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    printBanner("💪 Your Strength Levels");
                    System.out.printf("Squat:        %-12s%n", getStrengthLevel(Sq, BW));
                    System.out.printf("Bench Press:  %-12s%n", getStrengthLevel(BP, BW));
                    System.out.printf("Deadlift:     %-12s%n", getStrengthLevel(Dl, BW));
                    break;

                case 2:
                    printBanner("🎯 Progression Goals");
                    printProgressionGoal("Squat", Sq, BW);
                    printProgressionGoal("Bench Press", BP, BW);
                    printProgressionGoal("Deadlift", Dl, BW);
                    break;

                case 3:
                    printBanner("👋 Exiting Program. Stay Strong!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please enter 1, 2, or 3.");
            }

        } while (choice != 3);
    }

    public static void printMenu() {
        System.out.println("\n==================== MENU ====================");
        System.out.println("1️⃣  Check Strength Level");
        System.out.println("2️⃣  View Progression Goals");
        System.out.println("3️⃣  Exit Program");
        System.out.println("==============================================");
    }

    public static void printBanner(String message) {
        System.out.println("\n==================================================");
        System.out.println(message);
        System.out.println("==================================================\n");
    }

    public static double getValidInput(Scanner sc, String prompt, double maxAllowed) {
        double value = -1;
        while (true) {
            try {
                System.out.print(prompt);
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

    public static void printProgressionGoal(String liftName, double lift, double bodyWeight) {
        double ratio = lift / bodyWeight;
        String currentLevel = getStrengthLevel(lift, bodyWeight);
        double nextRatio = 0.0;

        switch (currentLevel) {
            case "Beginner":
                nextRatio = 0.75;
                break;
            case "Novice":
                nextRatio = 1.0;
                break;
            case "Intermediate":
                nextRatio = 1.5;
                break;
            case "Advanced":
                nextRatio = 2.0;
                break;
            default:
                System.out.printf("🎉 You are already at the Elite level in %s!%n", liftName);
                return;
        }

        double targetLift = nextRatio * bodyWeight;
        double kgToImprove = targetLift - lift;

        System.out.printf("👉 To reach the next level in %-12s, increase by: %.1f kg%n", liftName, kgToImprove);
    }
}
