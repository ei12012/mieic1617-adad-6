package Logic;

import java.util.Collections;
import java.util.Vector;

public class Autarquica extends LeitorCSV
{
	public Vector<String> concelhos;
	public Vector<String> presidentes;
	public Vector<String> partidos;
	
	public Vector<String> partidosDistintos;
	
	public Autarquica(String ficheiro) 
	{
		super(ficheiro);
		
		concelhos = new Vector<String>();
		presidentes = new Vector<String>();
		partidos = new Vector<String>();
		partidosDistintos = new Vector<String>();
		
		for(String s: linhas)
		{
			String[] dados = s.split(",");
			
			concelhos.addElement(dados[0]);
			presidentes.addElement(dados[1]);
			partidos.addElement(dados[2]);
			
			if(!partidosDistintos.contains(dados[2]))
			{
				partidosDistintos.addElement(dados[2]);
			}
		}
		
		Collections.sort(partidosDistintos);
	}
	
	public void VerPartidosDistintos()
	{
		for(String partido: partidosDistintos)
		{
			System.out.println(partido);
		}
	}
	
	public void GerarSQL()
	{
		for (int index = 0; index < partidosDistintos.size(); index++)
		{
			String partido = partidosDistintos.elementAt(index);
			
			String insert = "INSERT INTO Partido(partidoID, partidoSigla, partidoNome)\nValues(";
			
			insert += index + ", ";
			insert += "'" + partido + "'" + ", ";
			insert += "'" + "'";
			
			insert += ")";
			
			System.out.println(insert);
		}
	}
}
