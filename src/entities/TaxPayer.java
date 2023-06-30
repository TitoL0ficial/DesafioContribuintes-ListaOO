package entities;

public class TaxPayer {

	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;

	public TaxPayer() {
	}

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public double salaryTax() {	
		double monthSalary = 0;
		monthSalary = salaryIncome / 12;
		if (monthSalary < 5000.00) {
			return salaryIncome * 0.1;
		}
		else {
			return salaryIncome * 0.2;
		}
	}

	public double servicesTax() {
		if (servicesIncome > 0.00) {
			return servicesIncome * 0.15;
		}
		return servicesIncome;
	}

	public double capitalTax() {
		if(capitalIncome > 0.00) {
			return capitalIncome * 0.2;
		}
		return capitalIncome;
	}
	
	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public double taxRebate() {
		double rebate, deductibleExpense, deductibleMax;
		
		deductibleExpense = healthSpending + educationSpending;
		deductibleMax = grossTax() * 0.3;
		
		if (deductibleExpense > deductibleMax) {
			rebate = deductibleMax;
		}
		else {
			rebate = deductibleExpense;
		}
		return rebate;
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}
}
