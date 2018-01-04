package LP;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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

import static COMUN.constantesActionCommand.*;


public class FrameModificarProducto extends JFrame implements ActionListener 
{
	private JLabel lblNewLabel;
	private JLabel lblNewLabel1;
	private JLabel lblNewLabel2;
	private JLabel lblNewLabel3;
	private JLabel lblNewLabel4;
	private JLabel lblNewLabel5;
	private JLabel lblNewLabel6;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JButton btnNewButtonCancelar;
	private JButton btnNewButtonVerProductosActualizados;
	private JPanel contentPane;
	private JScrollPane scroll;
	private JLabel etiqueta;
	private JLabel etiqueta2;
	static Connection connection ;
	Connection con= BaseDatos.getConnection();
	private JTable tabla;
	private int filaseleccionada;
	private String codigo;
	private String nombre;
	private String Descripcion;
	private String categoria;
	private double precio;
	private JButton btnModificar;
	private DefaultTableModel modelo;
	
	
	

	public FrameModificarProducto() 
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
		
		etiqueta = new JLabel("Seleccione el producto que desea modificar");
		etiqueta.setBounds(1050, 420, 900, 60);
		etiqueta.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		etiqueta.setForeground(Color.blue);
		contentPane.add(etiqueta);
		
	

		

		lblNewLabel = new JLabel("Nombre del producto");
		lblNewLabel.setBounds(100, 420, 500, 60);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(100, 490, 400, 60);
		contentPane.add(textField);
		textField.setColumns(10);
		
	
		
		lblNewLabel1 = new JLabel("Descripción");
		lblNewLabel1.setBounds(100, 560, 400, 60);
		lblNewLabel1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel1);
		
		textField1 = new JTextField();
		textField1.setBounds(100, 630, 400, 200);
		contentPane.add(textField1);
		textField1.setColumns(10);
		

		lblNewLabel2 = new JLabel("Categoria");
		lblNewLabel2.setBounds(100, 830, 400, 60);
		lblNewLabel2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel2);
		
		textField2 = new JTextField();
		textField2.setBounds(100, 900, 400, 60);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		
		lblNewLabel3 = new JLabel("Código");
		lblNewLabel3.setBounds(600, 420, 400, 60);
		lblNewLabel3.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel3);
		
		textField3 = new JTextField();
		textField3.setBounds(600, 490, 400, 60);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		
		
		lblNewLabel4 = new JLabel("Precio");
		lblNewLabel4.setBounds(600, 560, 500, 60);
		lblNewLabel4.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel4);
		
		
		textField4 = new JTextField();
		textField4.setBounds(600,630, 100, 60);
		contentPane.add(textField4);
		textField4.setColumns(10);
		
		

		btnModificar = new JButton("Modificar producto");
		btnModificar.setForeground(Color.DARK_GRAY);
		btnModificar.setBackground(Color.GREEN);
		btnModificar.setActionCommand(BUTTON_MODIFICARPRODUCTOS);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(900, 580, 418, 50);
		contentPane.add(btnModificar);
		
		btnNewButtonCancelar = new JButton(" VOLVER ATRÁS");
		btnNewButtonCancelar.setForeground(Color.DARK_GRAY);
		btnNewButtonCancelar.setBackground(Color.RED);
		btnNewButtonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonCancelar.setBounds(1380, 580, 198, 48);
		contentPane.add(btnNewButtonCancelar);
		btnNewButtonCancelar.setActionCommand(BUTTON_CANCELAR);
		btnNewButtonCancelar.addActionListener(this);
	//modificar producto
		btnNewButtonVerProductosActualizados = new JButton("ACTUALIZAR TABLA");
		btnNewButtonVerProductosActualizados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonVerProductosActualizados.setBounds(1580, 580, 280, 48);
		contentPane.add(btnNewButtonVerProductosActualizados);
		btnNewButtonVerProductosActualizados.setActionCommand(BUTTON_VERPRODUCTOSACTUALIZADOS);
		btnNewButtonVerProductosActualizados.addActionListener(this);
		
		
		construirTabla();
		
	}

	private void construirTabla()
	{
		tabla= new JTable();
		scroll= new JScrollPane();
		scroll.setBounds(0, 0, 1930, 400);
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
		
		modelo.fireTableDataChanged();
		
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
				nombre=(String)tabla.getValueAt(filaseleccionada, 1);
				Descripcion=(String)tabla.getValueAt(filaseleccionada, 2);
				categoria=(String)tabla.getValueAt(filaseleccionada, 3);
				precio=(Double)tabla.getValueAt(filaseleccionada, 4);
				
				String stringPrecio=String.valueOf(precio);
				textField.setText(nombre);
				textField1.setText(Descripcion);
				textField2.setText(categoria);
				textField3.setText(codigo);
				textField3.setEnabled(false);
				textField4.setText(stringPrecio);
				//clicado=true;
				
			}
		});
		
	}

	private void ModificarProducto()
	{
		//falta validar que las tablas no esten vacias
		gestorTrabajadores obj= new gestorTrabajadores();
		Statement state = BaseDatos.getStatement();
		if(textField1.getText().isEmpty()||textField.getText().isEmpty()||textField2.getText().isEmpty()||textField3.getText().isEmpty()||textField4.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "DEBES RELLENAR TODOS LOS CAMPOS");
		}else
		{
			String PRECIO;
			double precio;
			PRECIO=textField4.getText();
			precio= Double.valueOf(PRECIO).doubleValue();
			obj.modificar(state, codigo, textField.getText(),textField1.getText(),textField2.getText(), precio);
		
			textField.setText("");
			textField1.setText("");
			textField2.setText("");
			textField3.setText("");
			textField4.setText("");
			
			
		}	
		
	}
	
	private void actualizartabla()
	{
		
		modelo.fireTableDataChanged();
		
		construirTabla();
	}



	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
		{
		case BUTTON_MODIFICARPRODUCTOS: 
		ModificarProducto();break;
		
		case BUTTON_CANCELAR:
		this.dispose();break;
		
		case BUTTON_VERPRODUCTOSACTUALIZADOS: actualizartabla(); 
		break;
			
		
				
		} 
		
	}
	

	

}
