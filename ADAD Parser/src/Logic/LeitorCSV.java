package Logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

public class LeitorCSV
{
	public String ficheiro;
	public Vector<String> linhas;
	
	public LeitorCSV(String ficheiro)
	{
		linhas = new Vector<String>();
		this.ficheiro = ficheiro;
		
		LerFicheiro();
	}
	
	public void LerFicheiro()
	{
		try
		{
			InputStream inputstream = new FileInputStream(ficheiro);
			
			int data;
			String linha = "";
			
			data = inputstream.read();
			while (data != -1)
			{
				if (data == 10 || data == 13)
				{
					linhas.addElement(linha);
					linha = "";
				}
				else
				{
					linha += ((char)data);
				}
				data = inputstream.read();
			}
			linhas.addElement(linha);
			
			inputstream.close();
			
			int i = 0;
			while(i < linhas.size())
			{
				if (linhas.elementAt(i).length() == 0)
					linhas.removeElementAt(i);
				else
					i++;
			}
			
			i = 0;
			while(i < linhas.size())
			{
				if (linhas.elementAt(i).length() < 10)
					System.out.println("Line " + i + " has length: " + linhas.elementAt(i).length());
				
				i++;
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void VerFicheiro()
	{
		for(int index = 0; /*index < 10 &&*/ index < linhas.size(); index++)
		{
			System.out.println("[" + linhas.elementAt(index).length() + "]" + linhas.elementAt(index));
		}
	}
}
