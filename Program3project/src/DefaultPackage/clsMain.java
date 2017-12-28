package DefaultPackage;
import javax.swing.UIManager;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.theme.DesertBlue;

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
		/*  try{
			 
	            UIManager.setLookAndFeel("com.jtattoon.plaf.acryl.AcrylLookAndFeel");

	        }catch(Exception ex){
	        }*/
    }
	}


