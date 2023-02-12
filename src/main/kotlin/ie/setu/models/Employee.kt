package ie.setu.models

import ie.setu.roundToTwoDecimals

//import ie.setu.Main.roundToTwoDecimals

class Employee(
    val firstName: String = "Joe",
    val lastName: String = "Soap",
    val gender: Char = 'M',
    var employeeId: Int = 6143,
    val grossSalary: Double = 67543.21,
    val payePercentage: Double = 38.5,
    val prsiPercentage: Double = 5.2,
    val annualBonus: Double = 1450.50,
    val cycleToWork: Double = 54.33,
    //var monthlySalary: Double = grossSalary/12,
    //val monthlyPrsi: Double = monthlySalary*(prsiPercentage/100)
){
    fun getFullName() = when (gender){
        'm', 'M' -> "Mr. ${firstName} ${lastName}"
        'f', 'F' -> "Ms.  ${firstName} ${lastName}"
        else ->  "${firstName} ${lastName}"
    }

    fun getMonthlySalary() = grossSalary/12
    fun getMonthlyPaye() = getMonthlySalary()*(payePercentage/100)
    fun getMonthlyPrsi() = getMonthlySalary()*(prsiPercentage/100)
    fun getGrossPaye() = getMonthlySalary()+(annualBonus/12)
    fun getTotalDeductions() = getMonthlyPrsi() + cycleToWork
    fun getNetPay() = getGrossPaye() - getTotalDeductions()



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