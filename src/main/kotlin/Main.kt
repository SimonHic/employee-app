package ie.setu

import ie.setu.EmployeeAPI

var employees = EmployeeAPI()

fun main(args: Array<String>) {
    start()
}

fun menu() : Int {
    print("""
     |Employee Menu
     |      1.) Add An Employee
     |      2.) List All Employees
     |      3.) Search Employees
     |      4.) Print Payslip for Employee
     |      -1.) Exit
     |
     |Enter Option: """.trimMargin())
    return readLine()!!.toInt()
}

fun start() {
    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> add()
            2 -> list()
            3 -> search()
            4 -> paySlip()
            -99 -> dummyData()
            -1 -> println("Exiting the Application")
        }
        println()
    } while (input != -1)
}

fun search() {
    val employee = getEmployeeById()
    if (employee == null)
        println("No employee found!")
    else
        println(employee)
}

internal fun getEmployeeById(): Employee? {
    print("Enter the employee id to search by: ")
    val employeeID = readLine()!!.toInt()
    return employees.findOne(employeeID)
}

fun paySlip() {
    val employee = getEmployeeById()
    if (employee != null)
        println(employee.getPayslip())
}

fun dummyData() {
    employees.create(Employee("Simon", "Hickey", 'm', 0, 80000.68, 32.0, 8.0, 1500.0, 22.5))
    employees.create(Employee("Alice", "Murphy", 'f', 0, 70000.89, 40.0, 7.0, 2000.0, 0.0))
    employees.create(Employee("Tom", "Johnston", 'm', 0, 85000.42, 31.0, 7.5, 5000.0, 50.5))
}

fun add(){
    print("Enter first name: ")
    val firstName = readLine().toString()
    print("Enter surname: ")
    val surname = readLine().toString()
    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]
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

    employees.create(Employee(firstName, surname, gender, 0, grossSalary, payePercentage, prsiPercentage, annualBonus, cycleToWorkMonthlyDeduction))
}

fun list() {
    employees.findAll()
        .forEach{println(it)}
}

//Function allows for rounding by two decimal places
fun roundToTwoDecimals(number: Double) = "%.2f".format(number).toDouble()







