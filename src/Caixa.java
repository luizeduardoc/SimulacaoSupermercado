public class Caixa {
	
	private int clientesNaFila;
	private boolean statusCaixa;
	private int capacidadeCaixa;
	
	public Caixa(int capacidadeCaixa) {
		this.capacidadeCaixa = capacidadeCaixa;
		this.clientesNaFila = 0;
	}
	
	public int getClientesNaFila() {
		return clientesNaFila;
	}
	
	public void addClienteFila() {
		clientesNaFila++;
	}
	
	public void subClienteFila() {
		clientesNaFila--;
	}
	
	public boolean caixaLotado() {
		if(clientesNaFila == capacidadeCaixa) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean getStatusCaixa() {
		return statusCaixa;
	}
	
	public void setStatusCaixa(boolean status) {
		this.statusCaixa = status;
	}
	
	public int getCapacidadeCaixa() {
		return capacidadeCaixa;
	}
	
	public void avancaFila() {
		clientesNaFila--;
	}
	
	public boolean caixaSemCliente() {
		if(clientesNaFila == 0) {
			return true;
		} else {
			return false;
		}
	}
}
