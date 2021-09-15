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
		logar(usuario);
		comprar(usuario, ingressos);
	}

	private void logar(int usuario) {
		int tempo = (int)((Math.random() * 2000) + 50);
		System.out.println(tempo);
		try {
			sleep(tempo);
			if (tempo>3000) {
				System.err.println(usuario + " ==>Timeout");
			}else {
				comprar(usuario, ingressos);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void comprar(int usuario, int ingressos) {
		int tempo = (int)((Math.random() * 3000) + 1000);
		System.out.println(tempo);
		try {
			sleep(tempo);
			if (tempo>5500) {
				System.err.println(usuario + " ==>Timeout");
			}else {
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
