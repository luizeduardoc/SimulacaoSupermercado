import java.util.Scanner;

public class Sistema {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Informe a quantidade de caixas no supermercado: ");
		int totalCaixas = in.nextInt();
		in.nextLine();
		Supermercado supermercado = new Supermercado(totalCaixas);
		
		// Simula um dia de funcionamento do supermercado
		
		// <horas_funcionamento>*60 / <minutos_cada_interacao> = 56
		for(int i = 0; i < 56; i++) {
			
			// 10% de chance de um caixa ficar inativo
			for(Caixa caixa : supermercado.caixas) {
				if(Math.random()*10 <= 1) {
					caixa.setStatusCaixa(false);
				}
			}
			
			// Todos os caixa inativos voltam a atividade depois de 15 minutos
			for(Caixa caixa : supermercado.caixas) {
				if(!caixa.getStatusCaixa()) {
					caixa.setStatusCaixa(true);
				}
			}
			
			if(supermercado.entradaCliente()) {
				// Caso todos os caixas estiverem cheios
				if(supermercado.todosCaixasLotados()) {
					double valorPerdido = valorGastoCliente();
					supermercado.addTotalPerdido(valorPerdido);
				// Depois da entrada de um cliente, é verificado qual fila é a menor para o cliente poder entrar nela
				} else {
					int caixaComMenorFila = 0;
					for(int j = 0; j < supermercado.caixas.length; j++) {
						if(supermercado.caixas[j].getClientesNaFila() < supermercado.caixas[caixaComMenorFila].getClientesNaFila()) {
							if(supermercado.caixas[caixaComMenorFila].getStatusCaixa()) {
								caixaComMenorFila = j;	
							}
						}
					}
					
					supermercado.caixas[caixaComMenorFila].addClienteFila();
				}
			}
			
			// Simula a saída dos clientes de cada caixa
			// O cliente tem 50% de chance de sair de um caixa, adicionando o total ganho do supermercado baseado no
			//valor de suas compras
			for(int j = 0; j < totalCaixas; j++) {
				if(Math.random()*10 > 5) {
					double valorCompra = valorGastoCliente();
					supermercado.caixas[j].subClienteFila();
					supermercado.addClienteAtendido();
					supermercado.addTotalFaturado(valorCompra);
					
					// Verifica se a compra do cliente é a maior ou menor compra
					if(valorCompra > supermercado.getMaiorCompra()) {
						supermercado.setMaiorCompra(valorCompra);
					}
					
					if(valorCompra < supermercado.getMenorCompra()) {
						supermercado.setMenorCompra(valorCompra);
					}
				}
			}
		}
		
		while(supermercado.todosCaixaLiberados()) {
			for(Caixa caixa : supermercado.caixas) {
				if(!caixa.getStatusCaixa()) {
					caixa.setStatusCaixa(true);
				}
			}
		}
				
		int opcao = 0;
		while(opcao >= 0) {
			System.out.println("Operacoes do supermercado: ");
			System.out.println("  1 - Total faturamento");
			System.out.println("  2 - Total perdas");
			System.out.println("  3 - Total clientes não atendidos");
			System.out.println("  4 - Total clientes que entraram no supermercado");
			System.out.println("  5 - Valor da menor compra");
			System.out.println("  6 - Valor da maior compra");
			System.out.println("  7 - Número de caixas disponíveis");
			System.out.println("  8 - Número de caixas em funcionamento");
			System.out.println("  9 - Número de caixas parados");
			System.out.print("Escolha uma opção: ");
			opcao = in.nextInt();
			
			switch(opcao) {
				
			
			}
		}
		
		in.close();
	}
	
	private static double valorGastoCliente() {
		double valorCompra = Math.random()*5000;
		if(valorCompra < 500) {
			valorCompra = Math.random()*500;
		}
		return valorCompra;
	}
}
