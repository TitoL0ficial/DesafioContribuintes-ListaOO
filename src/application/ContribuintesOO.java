package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class ContribuintesOO {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Quantos contribuintes voce vai digitar? ");
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			System.out.println();
			System.out.printf("Digite os dados do %do contribuinte:\n", i + 1);
			System.out.print("Renda anual com salario: ");
			double rendaAnual = sc.nextDouble();
			System.out.print("Renda anual com prestação de servico: ");
			double prestacaoServico = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double ganhoCapital = sc.nextDouble();
			System.out.print("Gastos medicos: ");
			double gastoMedicos = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double gastosEducacionais = sc.nextDouble();
			
			list.add(new TaxPayer(rendaAnual, prestacaoServico, ganhoCapital, gastoMedicos, gastosEducacionais));
		}
		
		System.out.println();
		int i = 0;		
		for(TaxPayer e : list) {
			i++;
			System.out.printf("Resumo do %do contribuinte: \n", i);
			System.out.printf("Imposto bruto total: %.2f%n", e.grossTax());
			System.out.printf("Abatimento: %.2f%n", e.taxRebate());
			System.out.printf("Imposto devido: %.2f%n", e.netTax());
			System.out.println();
		}
		
		
		
		sc.close();
	}

}
