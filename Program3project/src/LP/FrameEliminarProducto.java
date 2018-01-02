package LP;

import static COMUN.constantesActionCommand.BUTTON_CANCELAR;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import LD.BaseDatos;
import LN.gestorTrabajadores;

public class FrameEliminarProducto extends JFrame implements ActionListener {
	
	private String codProducto;
	private JButton btnNewButtonCancelar;
	private JPanel contentPane;
	private JScrollPane scroll;
	static Connection connection ;
	Connection con= BaseDatos.getConnection();
	private JTable tabla;
	private DefaultTableModel modelo;
	private JLabel IMAGEN;
	public FrameEliminarProducto() 
	{
		atributosVentana();
	} 

	
	
	
	
	private void atributosVentana()
	{
	
		setForeground(Color.BLACK);
		setTitle("PRODUCTOS DISPONIBLES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 549, 453);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(500, 500);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*tabla.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
			//	int row=tabla.getSelectedRow();
				int row = tabla.getSelectedRow();
				int column = tabla.getSelectedColumn();
				codProducto = tabla.getModel().getValueAt(row, column).toString();
			}
		});
		*/
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setActionCommand("ELIMINAR");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(900, 580, 118, 50);
		contentPane.add(btnEliminar);
		
		btnNewButtonCancelar = new JButton(" VOLVER ATR�S");
		btnNewButtonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonCancelar.setBounds(1180, 580, 198, 48);
		contentPane.add(btnNewButtonCancelar);
		btnNewButtonCancelar.setActionCommand(BUTTON_CANCELAR);
		btnNewButtonCancelar.addActionListener(this);
		
		
		construirTabla();
		
	}

	private void construirTabla()
	{
		tabla= new JTable();
		scroll= new JScrollPane();
		scroll.setBounds(10, 70, 1500, 400);
		getContentPane().add(scroll);
		scroll.setViewportView(tabla); 
		
		DefaultTableModel modelo= new DefaultTableModel();
		modelo.addColumn("C�digo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Categoria");
		modelo.addColumn("Precio");
		tabla.setModel(modelo);
		ArrayList<Object[]> datos= new ArrayList<Object[]>();
		gestorTrabajadores obj = new gestorTrabajadores();
		datos= obj.llenarTabla();
		
		for(int i=0;i<datos.size();i++)
		{
			modelo.addRow(datos.get(i));
			
		}
		modelo.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) 
			{
				if(e.getType()==TableModelEvent.UPDATE)
				{
					int columna=e.getColumn();
					int fila =e.getFirstRow();
				}
				
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
		{
			
		case "ELIMINAR":
			boolean aviso = false;
			if(codProducto!=null)
			{
				aviso = this.Aviso();
				if(aviso!=true)
				{
					this.EliminarProducto();
					this.dispose();
				}
			}else
			{
				JOptionPane.showMessageDialog(null, "Elija el producto que desea eliminar");
			}
			break;
			case BUTTON_CANCELAR: this.dispose();
				
				break;
		} 
		
	}
	
	public void EliminarProducto()
	{
		gestorTrabajadores  gesTra = new gestorTrabajadores();
		Statement state = BaseDatos.getStatement();

		String cod_vuelo = codProducto;
		
		gesTra.CancelarProducto(state, cod_vuelo);
	}
	
	private boolean Aviso() 
	{
		boolean aviso = false;
		 int respuesta = JOptionPane.showConfirmDialog(null, "�Seguro que desea eliminar?", "DeustoAmazonShop - Aviso",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    
	    if (respuesta == JOptionPane.NO_OPTION) 
	    {
	      aviso = true;
	    } 
	    else if (respuesta == JOptionPane.YES_OPTION) 
	    {
	      aviso = false;
	    } 
	    else if (respuesta == JOptionPane.CLOSED_OPTION) 
	    {
	      aviso = true;
	    }
	    
		return aviso;		
	}
	



}
