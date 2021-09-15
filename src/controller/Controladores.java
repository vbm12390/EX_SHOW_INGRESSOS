package controller;

import java.util.concurrent.Semaphore;

public class Controladores extends Thread {
	private int usuario;
	private int ingressos;
	private Semaphore semaphore;
	

	public Controladores(int usuario, int ingressos, Semaphore semaphore) {
		this.usuario = usuario;
		this.ingressos = ingressos;
		this.semaphore = semaphore;
	}
	

	public void run() {
		
		usuario = logar(usuario);
		usuario = comprar(usuario);
	}

	private int logar(int usuario) {
		
		int tempo = (int)((Math.random() * 2000) + 50);
		System.out.println(tempo);
		int aux = 0;
		try {
			sleep(tempo);
			if (tempo>3000) {
				System.err.println(usuario + " ==>Timeout");
			}else {
				aux = usuario;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return aux;
	}
	
	private int comprar(int usuario) {
		int tempo = (int)((Math.random() * 3000) + 1000);
		int aux = 0;
		System.out.println(tempo);
		try {
			sleep(tempo);
			if (tempo>5500) {
				System.err.println(usuario + " ==>Timeout");
			}else {
				aux = usuario;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return aux;
	}
	
	private void validacompra(int usuario, int ingressos) {
		int total = 100;
		if(total!=0) {
			total = ingressos - total;
			System.err.println("Usuário "+usuario+" Comprou "+ingressos);
			System.out.println("Quantidade vendida "+"Quantidade Disponível "+total );
		}
	}

}
