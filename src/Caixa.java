public class Caixa {
	
	private int id;
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
		System.out.printf("Pessoas na fila do caixa %d: %d\n", id, clientesNaFila);
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
	
	public void setId(int id) {
		this.id = id;
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
