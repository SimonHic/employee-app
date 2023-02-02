//Exercise 6 continuation
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
fun main(args: Array<String>) {
    ////println("Pay Slip Printer")

    println(getFullName())
    //Calls the printPaySlip Method that is created and runs it and its contents in the Main
    printPayslip()
}
fun getFullName() = when (gender){
    "m", "M" -> "Mr. $firstName $lastName"
    "f", "F" -> "Ms. $firstName $lastName"
    else -> "$firstName $lastName"
}

fun printPayslip() {

    val monthlySalary = grossSalary/12
    val monthlyPaye = monthlySalary*(payePercentage/100)
    val monthlyPrsi = monthlySalary*(prsiPercentage/100)
    val grossPaye = monthlySalary+(annualBonus/12)
    val totalDeduction = monthlyPrsi + cycleToWork

    println(
        """
                                      Monthly Payslip 
        _____________________________________________________________________________
                   ${getFullName().uppercase()}        ID: $employeeId                  
        _____________________________________________________________________________    
                   PAYMENT DETAILS (gross pay: ${roundToTwoDecimals(grossPaye)}                                                                    
        _____________________________________________________________________________
                   Salary: ${roundToTwoDecimals(monthlySalary)}
                   Bonus:  ${roundToTwoDecimals(annualBonus / 12)}            
        _____________________________________________________________________________
                   DEDUCTION DETAILS (total Deductions: ${roundToTwoDecimals(totalDeduction)}      
        _____________________________________________________________________________
                   PAYE: ${roundToTwoDecimals(monthlyPaye)}                
                   PRSI: ${roundToTwoDecimals(monthlyPrsi)}  
                   Cycle To Work: ${roundToTwoDecimals(cycleToWork)}         
        ______________________________________________________________________________
                   NET PAY: ${roundToTwoDecimals(grossPaye - totalDeduction)} 
        ______________________________________________________________________________"""
    )

}
//Function allows for rounding by two decimal places
fun roundToTwoDecimals(number: Double) = "%.2f".format(number).toDouble()




