package Console;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Vector;

import Logic.*;

public class Main
{
	static void GerarDespesasSQL(Vector<Despesas> LD)
	{
		for(Despesas ds : LD)
		{
			for(Despesa d: ds.despesas)
			{
				String insert = "INSERT INTO Orcamento(municipioID, trimestreID, partidoID, presidenteID, rubricaID, tipo, valor)\nValues(";
				insert += ","; // municipioID
				insert += ","; // trimestreID
				insert += ","; // partidoID
				insert += ","; // presidenteID
				insert += ","; // rubricaID
				insert += ","; // tipo
				insert += ","; // valor
				
				insert += ")";
			}
		}
	}
	
	static String GetRandomString(int maxLength) // 0 ; maxLength - 1
	{
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < maxLength; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		return output;
	}
	
	public static void main(String[] argv)
	{
		Vector<Despesas> listaDespesas = new Vector<Despesas>();
		Vector<Receitas> listaReceitas = new Vector<Receitas>();
		
		Autarquica aut = new Autarquica("csv/autarquicas2009");
		Autarquica aut2 = new Autarquica("csv/autarquicas2013");
		
		Vector<String> pD = new Vector<String>(); // partidos diferentes
		for(String p : aut.partidosDistintos)
		{
			if(!pD.contains(p))
			{
				pD.addElement(p);
			}
		}
		
		for(String p : aut2.partidosDistintos)
		{
			if(!pD.contains(p))
			{
				pD.addElement(p);
			}
		}
		
		for(String p : pD)
		{
			System.out.println(p);
		}
		
		System.out.println("----------------------------------");
		
		Vector<String> prD = new Vector<String>(); // presidentes diferentes
		for(String p : aut.presidentes)
		{
			if(!prD.contains(p))
			{
				prD.addElement(p);
			}
		}
		
		for(String p : aut2.presidentes)
		{
			if(!prD.contains(p))
			{
				prD.addElement(p);
			}
		}
		
		System.out.println("Existem " + prD.size() + " diferentes. A soma independente e " + (aut.presidentes.size() + aut2.presidentes.size()) );
		
		// create sql inserts dos partidos
		File fout = new File("insertPartidos.sql");
		FileOutputStream fos;
//		try
//		{
//			fos = new FileOutputStream(fout);
//			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
//			 
//			for(int index = 0; index < pD.size(); index++)
//			{
//				String partido = pD.elementAt(index);
//				
//				bw.write("INSERT INTO Partido(partidoID,partidoSigla, partidoNome)");
//				bw.newLine();
//				
//				String s = "VALUES(";
//				s += Integer.toString(index+1);
//				s += ",";
//				
//				s += "'";
//				s += partido;
//				s += "'";
//				s += ",";
//				
//				s += "'";
//				s += "";
//				s += "'";
//				
//				s += ");";
//				
//				bw.write(s);
//				bw.newLine();
//			}
//			
//			//bw.newLine();
//			
//			bw.close();
//			
//		}
//		catch (FileNotFoundException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		catch (IOException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	 
		// create sql inserts dos presidentes
		fout = new File("insertPresidentes.sql");
		
		try
		{
			fos = new FileOutputStream(fout);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
			 
			for(int index = 0; index < prD.size(); index++)
			{
				String presidente = prD.elementAt(index);
				
				bw.write("INSERT INTO Presidente(presidenteID,presidenteCodigo,presidenteNome)");
				bw.newLine();
				
				String s = "VALUES(";
				s += Integer.toString(index+1);
				s += ",";
				
				s += "'";
				s += GetRandomString(12);
				s += "'";
				s += ",";
				
				s += "'";
				s += presidente;
				s += "'";
				
				s += ");";
				
				bw.write(s);
				bw.newLine();
			}
			
			//bw.newLine();
			
			bw.close();
			
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		// autarquias
		
		for(int i = 2010; i < 2016; i++) // 0 - 2010, 5- 2015
		{
			String s = Integer.toString(i) + ".csv";
			
			Despesas d = new Despesas("csv/despesas" + s);
			Receitas r = new Receitas("csv/receitas" + s);
			
			listaDespesas.addElement(d);
			listaReceitas.addElement(r);
		}
		
		//listaDespesas.elementAt(0).Ver();	
	}
}
