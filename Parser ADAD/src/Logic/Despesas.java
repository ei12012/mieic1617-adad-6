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
		//System.out.println( "Separating file " + ficheiro );
		for(int index = 1; index < linhas.size(); index++)
		{
			String linha = linhas.elementAt(index);
			//System.out.println("Linha: " + linha);
			despesas.addElement(new Despesa(linha));
		}
	}
	
	public void Ver()
	{
		for(int index = 0; /*index < 10 &&*/ index < despesas.size(); index++)
		{
			despesas.elementAt(index).Ver();
		}
	}
	
	
}
