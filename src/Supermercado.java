public class Supermercado {
	
	private double totalFaturado;
	private double totalPerdido;
	private int totalClientesAtendidos;
	private int totalClientesPerdidos;
	private int numeroCaixasDisponiveis;
	private double menorCompra;
	private double maiorCompra;
	private int totalCaixas;
	
	public Caixa[] caixas;
	
	public Supermercado(int totalCaixas) {
		this.totalCaixas = totalCaixas;
		this.menorCompra = Double.MAX_VALUE;
		this.maiorCompra = Double.MIN_VALUE;
		caixas = new Caixa[totalCaixas];
		
		for(int i = 0; i < totalCaixas; i++) {
			caixas[i] = new Caixa((int)(Math.random()*10)+1);
			caixas[i].setIdCaixa(i);
		}
	}
	
	public boolean entradaCliente() {
		if(Math.random() > 0.6) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addClienteAtendido() {
		this.totalClientesAtendidos++;
	}
	
	public void addTotalFaturado(double totalFaturado) {
		this.totalFaturado += totalFaturado;
	}
	
	public void addTotalPerdido(double totalPerdido) {
		this.totalPerdido += totalPerdido;
	}
	
	public double getMaiorCompra() {
		return this.maiorCompra;
	}
	
	public void setMaiorCompra(double valorMaiorCompra) {
		this.maiorCompra = valorMaiorCompra;
	}
	
	public double getMenorCompra() {
		return this.menorCompra;
	}
	
	public void setMenorCompra(double menorCompra) {
		this.menorCompra = menorCompra;
	}
	
	public boolean todosCaixasLotados() {
		boolean caixasLotados = false;
		for(Caixa c : caixas) {
			if(c.caixaLotado()) {
				caixasLotados = true;
			} else {
				caixasLotados = false;
			}
		}
		return caixasLotados;
	}
	
	public boolean todosCaixaLiberados() {
		boolean caixasLiberados = false;
		
		for(Caixa c : caixas) {
			if(c.caixaSemCliente()) {
				caixasLiberados = true;
			} else {
				caixasLiberados = false;
			}
		}
		
		return caixasLiberados;
	}
	
}
