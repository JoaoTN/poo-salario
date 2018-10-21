/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Drielle
 */
public class Funcionario {
    private String nome;
    private int maxDiarias;
    private int diarias;
    private double bonus;
	
    public Funcionario(String nome, int maxDiarias){
        this.nome = nome;
	this.maxDiarias = maxDiarias;
        this.bonus = 0;
    }
    public String getNome(){
	return this.nome;
    }
    public void setNome(String nome){
	this.nome = nome;
    }
    public double getBonus(){
        return this.bonus;
    }
    public void setBonus(double bonus){
    	this.bonus =  bonus; 
    }	
    public int getDiarias(){
	return this.diarias;
    }
    public void setDiarias(int diarias){
	this.diarias = diarias;
    }

    public boolean addDiaria(){
        if(this.diarias >= this.maxDiarias){
            return false;
        }
        else{
            this.diarias++;
            return true;
	}
    }
    public String toString(){
	String res = "";
        res += "Nome: " + this.nome + "\n" +
			"Diarias: " + this.diarias + "\n";
        return res;
    }
}