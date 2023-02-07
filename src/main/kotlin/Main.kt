//Exercise 8 continuation
import java.lang.Math.round
import java.math.RoundingMode
import java.text.DecimalFormat


const val firstName = "Joe"
const val lastName = "Soap"
const val gender = "M"
const val employeeId = 6143
const val grossSalary = 67543.21
const val payePercentage = 38.5
const val prsiPercentage = 5.2
const val annualBonus = 1450.50
const val cycleToWork = 54.33
const val monthlySalary = grossSalary/12
const val monthlyPrsi = monthlySalary*(prsiPercentage/100)


fun main(args: Array<String>) {

    //Call the getFullName function and outputs it to the main in the form of a println
    println(getFullName())

    //Calls the getPaySlip Method that is created and runs it and its contents in the Main
    print(getPayslip())
}
fun getFullName() = when (gender){
    "m", "M" -> "Mr. $firstName $lastName"
    "f", "F" -> "Ms. $firstName $lastName"
    else -> "$firstName $lastName"
}

fun getMonthlySalary() = grossSalary/12
fun getMonthlyPaye() = monthlySalary*(payePercentage/100)
fun getMonthlyPrsi() = monthlySalary*(prsiPercentage/100)
fun getGrossPaye() = monthlySalary+(annualBonus/12)
fun getTotalDeductions() = monthlyPrsi + cycleToWork


fun getPayslip() {

    println(
        """
                                      Monthly Payslip 
        |_____________________________________________________________________________
        |           ${getFullName().uppercase()}        ID Number: $employeeId                  
        |_____________________________________________________________________________    
        |           PAYMENT DETAILS: 
        |           
        |           Gross Pay: ${roundToTwoDecimals(getGrossPaye())}                                                                    
        |_____________________________________________________________________________
        |           Salary: ${roundToTwoDecimals(getMonthlySalary())}
        |           
        |           Bonus:  ${roundToTwoDecimals(annualBonus / 12)}            
        |_____________________________________________________________________________
        |           DEDUCTION DETAILS: 
        |           
        |           Total Deductions: ${roundToTwoDecimals(getTotalDeductions())}      
        |_____________________________________________________________________________
        |           PAYE: ${roundToTwoDecimals(getMonthlyPaye())}
        |                           
        |           PRSI: ${roundToTwoDecimals(getMonthlyPrsi())}  
        |           
        |           Cycle To Work: ${roundToTwoDecimals(cycleToWork)}         
        |______________________________________________________________________________
        |           NET PAY: ${roundToTwoDecimals(getGrossPaye() - getTotalDeductions())} 
        |______________________________________________________________________________"""
    )

}
//Function allows for rounding by two decimal places
fun roundToTwoDecimals(number: Double) = "%.2f".format(number).toDouble()




