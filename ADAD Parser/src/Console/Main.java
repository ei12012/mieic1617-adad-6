package Console;

import Logic.*;

public class Main
{
	
	public static void main(String[] argv)
	{
		Despesas d2010 = new Despesas("csv/despesas2010csv.csv");
		d2010.Ver();
		
		/*Receitas r2010 = new Receitas("csv/receitas2010csv.csv");
		r2010.Ver();*/
	}
}
