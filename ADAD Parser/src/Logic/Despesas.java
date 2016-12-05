package Logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

public class Despesas extends LeitorCSV
{
	public Vector<Despesa> despesas;
	
	public Despesas(String ficheiro)
	{
		super(ficheiro);
		
		despesas = new Vector<Despesa>();
		SeparateData();
	}
		
	public void SeparateData() // primeira linha - informacao das colunas
	{
		for(int index = 1; index < linhas.size(); index++)
		{
			String linha = linhas.elementAt(index);
			despesas.addElement(new Despesa(linha));
		}
	}
	
	public void Ver()
	{
		for(int index = 1; /*index < 10 &&*/ index < despesas.size(); index++)
		{
			despesas.elementAt(index).Ver();
		}
	}
}
