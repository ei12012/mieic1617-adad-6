package Logic;

public class Receita
{
	String ldk;
	String codigoPeriodo;
	int codigoine;
	String dscautarquia;
	double receitastotais;
	double transferenciasorcamentoestado;
	double financiamentouniaoeuropeia;
	double impostosmunicipais;
	double imi;
	double imt;
	double iuc;
	double derramairc;
	double taxasmultasoutrosimpostos;
	double vendabensservicos;
	double outrasreceitas;
	
	public Receita(String linha)
	{
		String[] colunas = linha.split(";");
		
		ldk = colunas[0];
		codigoPeriodo = colunas[1];
		codigoine = Integer.parseInt(colunas[2]);
		dscautarquia = colunas[3];
		
		receitastotais = Double.parseDouble(colunas[4]);
		transferenciasorcamentoestado = Double.parseDouble(colunas[5]);
		financiamentouniaoeuropeia = Double.parseDouble(colunas[6]);
		impostosmunicipais = Double.parseDouble(colunas[7]);
		imi = Double.parseDouble(colunas[8]);
		imt = Double.parseDouble(colunas[9]);
		iuc = Double.parseDouble(colunas[10]);
		derramairc = Double.parseDouble(colunas[11]);
		taxasmultasoutrosimpostos = Double.parseDouble(colunas[12]);
		vendabensservicos = Double.parseDouble(colunas[13]);
		outrasreceitas = Double.parseDouble(colunas[14]);
	}
	
	public void Ver()
	{
		System.out.println(
			ldk + " " +
			codigoPeriodo + " " +
			codigoine + " " +
			dscautarquia + " " +
			receitastotais + " " +
			transferenciasorcamentoestado + " " +
			financiamentouniaoeuropeia + " " +
			impostosmunicipais + " " +
			imi + " " +
			imt + " " +
			iuc + " " +
			derramairc + " " +
			taxasmultasoutrosimpostos + " " +
			vendabensservicos + " " +
			outrasreceitas
		);
	}
}
