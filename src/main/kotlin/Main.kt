import java.math.RoundingMode
import java.text.DecimalFormat

fun main(args: Array<String>) {
    println("Pay Slip Printer")

    //Calls the userDetails Method that is created and runs it in the main
    userDetails()
}

fun userDetails() {
    val firstName = "Joe"
    val lastName = "Soap"
    val gender = "M"
    val employeeId = 6143
    val grossSalary = 67543.21
    val payePercentage = 38.5
    val prsiPercentage = 5.2
    val annualBonus = 1450.50
    val cycleToWork = 54.33

    val monthlySalary = grossSalary/12
    val monthlyPaye = monthlySalary*(payePercentage/100)
    val monthlyPrsi = monthlySalary*(prsiPercentage/100)
    val grossPaye = monthlySalary+(annualBonus/12)
    val totalDeduction = monthlyPrsi + cycleToWork

    //Rounds by 2 decimal places
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    println("---------------------------------------------------------")
    println("|                  Monthly Payslip                      |")
    println("|-------------------------------------------------------|")
    println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t|")
    println("|  Employee Name: ${firstName.uppercase()} ${lastName.uppercase()}($gender)       Employee ID: $employeeId   |")
    println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t|")
    println("|-------------------------------------------------------|")
    println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t|")

    println("|   PAYMENT DETAILS   "+ "           " + "DEDUCTION DETAILS      |")
    println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t|")
    println("|-------------------------------------------------------|")
    println("|   Salary: " + df.format(monthlySalary) + "\t\t\t\t\t " + "PAYE: " + df.format(monthlyPaye) + "      |")
    println("|   Bonus: " + df.format(annualBonus/12) + " \t\t\t\t\t  " + "PRSI: " + df.format(monthlyPrsi)+"      |")
    println("|\t\t\t\t\t\t\t   Cycle To Work: $cycleToWork     |")
    println("|-------------------------------------------------------|")
    println("|   Gross: " + df.format(grossPaye) + "       " + "Total Deductions: " + df.format(totalDeduction)+"       |")
    println("|-------------------------------------------------------|")
    println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t|")
    println("|\t\t\t\t   NET PAY: " + df.format(monthlySalary-totalDeduction) +"\t\t\t\t\t\t|")
    println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t|")
    println("|-------------------------------------------------------|")
}