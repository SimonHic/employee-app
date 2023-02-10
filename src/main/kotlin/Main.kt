//At the end of exercise 2 with getFullName() recently updated
package ie.setu


var employee =  Employee("Joe", "Soap", 'm', 6143, 67543.21, 38.5, 5.2, 1450.50, 54.33)





fun main(args: Array<String>) {

    /*
    Call the getFullName function and outputs it to the main in the form of a print
    println(getFullName())
    */

    //Calls the add() function which allows the user to add a new employee
    add()

    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> println("Monthly Salary: ${roundToTwoDecimals(getMonthlySalary())}")
            2 -> println("Monthly PRSI: ${roundToTwoDecimals(getMonthlyPrsi())}")
            3 -> println("Monthly PAYE: ${roundToTwoDecimals(getMonthlyPaye())}")
            4 -> println("Monthly Gross Pay: ${roundToTwoDecimals(getGrossPaye())}")
            5 -> println("Monthly Total Deductions: ${roundToTwoDecimals(getTotalDeductions())}")
            6 -> println("Monthly Net Pay: ${roundToTwoDecimals(getNetPay())}")
            7 -> println(getPayslip())
            0 -> println("Exiting Application")
            else -> println("Invalid option, please select a value between 0 and 7 :)")
        }
        println()
    } while (input != 0)
}

fun menu() : Int {
    print("""
        Employee Menu for ${getFullName()}
        1.)  Monthly Salary
        2.)  Monthly PRSI
        3.)  Monthly PAYE
        4.)  Monthly Gross PAYE
        5.)  Monthly Total Deductions
        6.)  Monthly Net Pay
        7.)  Full Payslip
        
        0.)  Exit
        
      Enter  Option : """)
      return readLine()!!.toInt()
}

fun add(){
    print("Enter first name: ")
    val firstName = readLine().toString()
    print("Enter surname: ")
    val surname = readLine().toString()
    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]
    print("Enter employee ID: ")
    val employeeID = readLine()!!.toInt()
    print("Enter gross salary: ")
    val grossSalary = readLine()!!.toDouble()
    print("Enter PAYE %: ")
    val payePercentage = readLine()!!.toDouble()
    print("Enter PRSI %: ")
    val prsiPercentage = readLine()!!.toDouble()
    print("Enter Annual Bonus: ")
    val annualBonus= readLine()!!.toDouble()
    print("Enter Cycle to Work Deduction: ")
    val cycleToWorkMonthlyDeduction= readLine()!!.toDouble()

    employee = Employee(firstName, surname, gender, employeeID, grossSalary, payePercentage, prsiPercentage, annualBonus, cycleToWorkMonthlyDeduction)
}


fun getFullName() = when (employee.gender){
    'm', 'M' -> "Mr. ${employee.firstName} ${employee.lastName}"
    'f', 'F' -> "Ms.  ${employee.firstName} ${employee.lastName}"
    else ->  "${employee.firstName} ${employee.lastName}"
}


fun getMonthlySalary() = employee.grossSalary/12
fun getMonthlyPaye() = employee.monthlySalary*(employee.payePercentage/100)
fun getMonthlyPrsi() = employee.monthlySalary*(employee.prsiPercentage/100)
fun getGrossPaye() = employee.monthlySalary+(employee.annualBonus/12)
fun getTotalDeductions() = employee.monthlyPrsi + employee.cycleToWork

fun getNetPay() = getGrossPaye() - getTotalDeductions()



fun getPayslip() {

    println(
        """
                                      Monthly Payslip 
        |_____________________________________________________________________________
        |           ${getFullName().uppercase()}        ID Number: ${employee.employeeId}                  
        |_____________________________________________________________________________    
        |           PAYMENT DETAILS: 
        |           
        |           Gross Pay: ${roundToTwoDecimals(getGrossPaye())}                                                                    
        |_____________________________________________________________________________
        |           Salary: ${roundToTwoDecimals(getMonthlySalary())}
        |           
        |           Bonus:  ${roundToTwoDecimals(employee.annualBonus / 12)}            
        |_____________________________________________________________________________
        |           DEDUCTION DETAILS: 
        |           
        |           Total Deductions: ${roundToTwoDecimals(getTotalDeductions())}      
        |_____________________________________________________________________________
        |           PAYE: ${roundToTwoDecimals(getMonthlyPaye())}
        |                           
        |           PRSI: ${roundToTwoDecimals(getMonthlyPrsi())}  
        |           
        |           Cycle To Work: ${roundToTwoDecimals(employee.cycleToWork)}         
        |______________________________________________________________________________
        |           NET PAY: ${roundToTwoDecimals(getNetPay())} 
        |______________________________________________________________________________"""
    )

}
//Function allows for rounding by two decimal places
fun roundToTwoDecimals(number: Double) = "%.2f".format(number).toDouble()




