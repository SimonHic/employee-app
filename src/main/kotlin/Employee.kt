package ie.setu

class Employee(
    val firstName: String = "Joe",
    val lastName: String = "Soap",
    val gender: Char = 'M',
    val employeeId: Int = 6143,
    val grossSalary: Double = 67543.21,
    val payePercentage: Double = 38.5,
    val prsiPercentage: Double = 5.2,
    val annualBonus: Double = 1450.50,
    val cycleToWork: Double = 54.33,
    val monthlySalary: Double = grossSalary/12,
    val monthlyPrsi: Double = monthlySalary*(prsiPercentage/100)
)