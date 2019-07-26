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
			caixas[i] = new Caixa(5);
			caixas[i].setId(i);
		}
	}
	
	public boolean entradaCliente() {
		if(Math.random() >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public double getTotalFaturado() {
		return totalFaturado;
	}
	
	public void addClienteAtendido() {
		this.totalClientesAtendidos++;
	}
	
	public void addClientePerdido() {
		this.totalClientesPerdidos++;
	}
	
	public void addTotalFaturado(double totalFaturado) {
		this.totalFaturado += totalFaturado;
	}
	
	public void addTotalPerdido(double totalPerdido) {
		this.totalPerdido += totalPerdido;
	}
	
	public int getTotalClientesPerdidos() {
		return this.totalClientesPerdidos;
	}
	
	public int getTotalClientesAtendidos() {
		return this.totalClientesAtendidos;
	}
	
	public double getTotalPerdido() {
		return totalPerdido;
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
