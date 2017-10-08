package DefaultPackage;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import LD.BaseDatos;
import LP.PaginaPrincipal;


public class clsMain {

	public static void main(String[] args) 
	{
		BaseDatos.initBD("AmazonShopBD");
		
		try 
		{
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
		    {
		        if ("Nimbus".equals(info.getName())) 
		        {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e)
		{
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}	
		PaginaPrincipal obj = new PaginaPrincipal();
		obj.setVisible(true);
	}

}
