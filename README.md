
> **"Error in user YAML: found character that cannot start any token"**

This is happening because you're using **YAML front matter (`---`)** at the top of the file in a `.md` file (probably in a GitHub repo where front matter isn’t needed) **without valid YAML content immediately after it**. YAML expects a key-value pair if you start with `---`.

---

### ✅ Fix

You can **remove the very first line (`---`)**, since it's not necessary in a regular README file:

```diff
- ---
```

### ✅ Cleaned-up Version

Here’s a corrected version of your `README.md`:

```markdown
# 🏋️ Strength Level Calculator (Java CLI App)

This is a beginner-friendly Java CLI (Command Line Interface) project that calculates and categorizes strength levels based on user inputs such as body weight and personal records (PRs) in Squat, Bench Press, and Deadlift.

---

## 🔧 Features

- Collects user input for:
  - Body Weight
  - Squat PR
  - Bench Press PR
  - Deadlift PR
- Validates and sanitizes input to prevent unrealistic or invalid entries
- Calculates strength-to-bodyweight ratios
- Categorizes performance into:
  - Beginner
  - Novice
  - Intermediate
  - Advanced
  - Elite
- Provides progression goals to reach the next level
- Includes a CLI menu for easy navigation
- Clean and readable console output

---

### 🖥️ Sample Output

```

\===== STRENGTH LEVEL CALCULATOR =====

1️⃣ Check Strength Level
2️⃣ View Progression Goals
3️⃣ Exit Program

Enter your choice: 1

Input your Body Weight (BW): 70
Input your Squat PR: 80
Input your Bench Press PR: 60
Input your Deadlift PR: 100

\--- RESULTS ---
Squat Strength Level: Novice
Bench Press Strength Level: Intermediate
Deadlift Strength Level: Advanced

````

---

## 📚 Concepts Used

- Java fundamentals (variables, data types)
- Scanner class for input handling
- Loops and conditional statements
- Methods and method overloading
- Input validation
- Error handling with try-catch
- CLI design with user-friendly prompts

---

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/apostleoffinance/StrengthLevelCalculator.git
````

2. Navigate into the folder:

   ```bash
   cd StrengthLevelCalculator
   ```

3. Compile and run the program:

   ```bash
   javac Main.java
   java Main
   ```

---

✅ **Future Improvements**

* Add unit tests
* Save/load user data to a file
* Support for lbs/kg toggle
* Graphical UI version

---

## 📝 License

This project is open-source and free to use under the [MIT License](LICENSE).

```
```
