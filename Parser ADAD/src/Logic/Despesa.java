package Logic;

public class Despesa
{
	String ldk;
	String codigoPeriodo;
	int codigoine;
	String dscautarquia;
	double despesatotal;
	double despesacorrente;
	double despesacompessoal;
	double despesaaquisicaobens;
	double jurosencargos;
	double transferenciascorrentes;
	double investimentosoutrosinvestimentosbensdecapital;
	double terrenoshabitacoes;
	double edificios;
	double infraestruturasbasicas;
	double acessibilidades;
	double outrosinvestimentosbensdecapital;
	double transferenciasoutrasdespesascapital;
	
	public Despesa(String linha)
	{
		String[] colunas = linha.split(";");
		
		ldk = colunas[0];
		codigoPeriodo = colunas[1];
		codigoine = Integer.parseInt(colunas[2]);
		dscautarquia = colunas[3];
		despesatotal = Double.parseDouble(colunas[4]);
		despesacorrente = Double.parseDouble(colunas[5]);
		despesacompessoal = Double.parseDouble(colunas[6]);
		despesaaquisicaobens = Double.parseDouble(colunas[7]);
		jurosencargos = Double.parseDouble(colunas[8]);
		transferenciascorrentes = Double.parseDouble(colunas[9]);
		investimentosoutrosinvestimentosbensdecapital = Double.parseDouble(colunas[10]);
		terrenoshabitacoes = Double.parseDouble(colunas[11]);
		edificios = Double.parseDouble(colunas[12]);
		infraestruturasbasicas = Double.parseDouble(colunas[13]);
		acessibilidades = Double.parseDouble(colunas[14]);
		outrosinvestimentosbensdecapital = Double.parseDouble(colunas[15]);
		transferenciasoutrasdespesascapital = Double.parseDouble(colunas[16]);
	}
	
	public void Ver()
	{
		System.out.println(
			ldk + " " +
			codigoPeriodo + " " +
			codigoine + " " +
			dscautarquia + " " +
			despesatotal + " " +
			despesacorrente + " " +
			despesacompessoal + " " +
			despesaaquisicaobens + " " +
			jurosencargos + " " +
			transferenciascorrentes + " " +
			investimentosoutrosinvestimentosbensdecapital + " " +
			terrenoshabitacoes + " " +
			edificios + " " +
			infraestruturasbasicas + " " +
			acessibilidades + " " +
			outrosinvestimentosbensdecapital + " " +
			transferenciasoutrasdespesascapital
		);
	}
}
