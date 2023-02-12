package ie.setu.models

import ie.setu.roundToTwoDecimals


class Employee(
    val firstName: String = "Joe",
    private val lastName: String = "Soap",
    private val gender: Char = 'M',
    var employeeId: Int = 6143,
    private val grossSalary: Double = 67543.21,
    private val payePercentage: Double = 38.5,
    private val prsiPercentage: Double = 5.2,
    private val annualBonus: Double = 1450.50,
    private val cycleToWork: Double = 54.33,
) {
    private fun getFullName() = when (gender) {
        'm', 'M' -> "Mr. $firstName $lastName"
        'f', 'F' -> "Ms.  $firstName $lastName"
        else -> "$firstName $lastName"
    }

    private fun getMonthlySalary() = grossSalary / 12
    private fun getMonthlyPaye() = getMonthlySalary() * (payePercentage / 100)
    private fun getMonthlyPrsi() = getMonthlySalary() * (prsiPercentage / 100)
    private fun getGrossPaye() = getMonthlySalary() + (annualBonus / 12)
    private fun getTotalDeductions() = getMonthlyPrsi() + cycleToWork
    private fun getNetPay() = getGrossPaye() - getTotalDeductions()


    fun getPayslip() {

        println(
            """
                                      Monthly Payslip 
        |_____________________________________________________________________________
        |           ${getFullName().uppercase()}        ID Number: ${employeeId}                  
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
        |           NET PAY: ${roundToTwoDecimals(getNetPay())} 
        |______________________________________________________________________________"""
        )

    }

    override fun toString(): String {
        return "Employee(firstName='$firstName', surname='$lastName', gender=$gender, employeeID=$employeeId, grossSalary=$grossSalary, payePercentage=$payePercentage, prsiPercentage=$prsiPercentage, annualBonus=$annualBonus, cycleToWorkMonthlyDeduction=$cycleToWork)"
    }

}