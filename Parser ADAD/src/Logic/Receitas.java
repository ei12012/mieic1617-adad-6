package Logic;

import java.util.Vector;

public class Receitas extends LeitorCSV
{
	public Vector<Receita> receitas;
	
	public Receitas(String ficheiro)
	{
		super(ficheiro);
		
		receitas = new Vector<Receita>();
		SeparateData();
	}
		
	public void SeparateData() // primeira linha - informacao das colunas
	{
		for(int index = 1; index < linhas.size(); index++)
		{
			String linha = linhas.elementAt(index);
			receitas.addElement(new Receita(linha));
		}
	}
	
	public void Ver()
	{
		for(int index = 1; /*index < 10 &&*/ index < receitas.size(); index++)
		{
			receitas.elementAt(index).Ver();
		}
	}
}
