package LP;

import static COMUN.constantesActionCommand.BUTTON_CANCELAR;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JTextField;
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
	private JTable tabla;
	private DefaultTableModel modelo;
	int filaseleccionada;
	private  JButton btnEliminar;
	private String codigo;
	private boolean clicado;
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
		

		
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setActionCommand("ELIMINAR");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(900, 580, 118, 50);
		contentPane.add(btnEliminar);
		
		btnNewButtonCancelar = new JButton(" VOLVER ATRÁS");
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
		
		modelo= new DefaultTableModel();
		modelo.addColumn("Código");
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
		tabla.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				filaseleccionada=tabla.getSelectedRow();
				codigo = (String)tabla.getValueAt(filaseleccionada, 0);
				//clicado=true;
				
			}
		});
		
	}
		
	

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
		{
			
		case "ELIMINAR":EliminarProducto();
			
			break;
			case BUTTON_CANCELAR: this.dispose();
				
				break;
		} 
		
	}
	
	public void EliminarProducto()
	{
		gestorTrabajadores obj= new gestorTrabajadores();
		Statement state = BaseDatos.getStatement();
		modelo= (DefaultTableModel) tabla.getModel();
		modelo.removeRow(filaseleccionada);
		obj.EliminarProducto(state, codigo);

		
		
	}
	
}	
