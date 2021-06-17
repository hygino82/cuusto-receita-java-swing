import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entities.Product;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class Teste {

	private List<Product> lista = new ArrayList<>();
	private Integer contador = 0;
	private Double custoTotal = 0.0;
//	private String[] tipo = { "SÓLIDO", "LÍQUIDO" };
//	private String[] unidadesVolume = { "L", "mL" };
//    private String[] unidadesPeso = { "Kg", "g" };

	private JFrame frmGeradorDeCustos;
	private JTextField txtNome;
	private JTextField txtQuantidadeComprada;
	private JTextField txtValorComprado;
	private JTextField txtQuantidadeUsada;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste window = new Teste();
					window.frmGeradorDeCustos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Teste() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeradorDeCustos = new JFrame();
		frmGeradorDeCustos.setTitle("Gerador de custos");
		frmGeradorDeCustos.setBounds(100, 100, 598, 522);
		frmGeradorDeCustos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeradorDeCustos.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 33, 46, 14);
		frmGeradorDeCustos.getContentPane().add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtNome.setBounds(10, 48, 86, 20);
		frmGeradorDeCustos.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JComboBox<String> cbUnidadeComprada = new JComboBox<String>();
		cbUnidadeComprada.setModel(new DefaultComboBoxModel<String>(new String[] { "Kg", "g" }));
		cbUnidadeComprada.setBounds(209, 30, 78, 20);
		frmGeradorDeCustos.getContentPane().add(cbUnidadeComprada);

		JComboBox<String> cbUnidadeUsada = new JComboBox<String>();
		cbUnidadeUsada.setModel(new DefaultComboBoxModel<String>(new String[] { "Kg", "g" }));
		cbUnidadeUsada.setBounds(397, 30, 78, 20);
		frmGeradorDeCustos.getContentPane().add(cbUnidadeUsada);

//escolha do tipo de unidade
		JComboBox<String> cbTipo = new JComboBox<String>();
		cbTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbTipo.getSelectedItem().equals("SÓLIDO")) {
					cbUnidadeComprada.setModel(new DefaultComboBoxModel<String>(new String[] { "Kg", "g" }));
					cbUnidadeUsada.setModel(new DefaultComboBoxModel<String>(new String[] { "Kg", "g" }));
				} else {
					cbUnidadeComprada.setModel(new DefaultComboBoxModel<String>(new String[] { "L", "mL" }));
					cbUnidadeUsada.setModel(new DefaultComboBoxModel<String>(new String[] { "L", "mL" }));
				}

			}
		});
		cbTipo.setModel(new DefaultComboBoxModel<String>(new String[] { "S\u00D3LIDO", "L\u00CDQUIDO" }));

		cbTipo.setBounds(106, 47, 91, 22);
		frmGeradorDeCustos.getContentPane().add(cbTipo);

		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setBounds(106, 33, 46, 14);
		frmGeradorDeCustos.getContentPane().add(lblNewLabel_1);

		txtQuantidadeComprada = new JTextField();
		txtQuantidadeComprada.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtQuantidadeComprada.setBounds(209, 48, 78, 20);
		frmGeradorDeCustos.getContentPane().add(txtQuantidadeComprada);
		txtQuantidadeComprada.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Pre\u00E7o");
		lblNewLabel_2.setBounds(301, 33, 46, 14);
		frmGeradorDeCustos.getContentPane().add(lblNewLabel_2);

		txtValorComprado = new JTextField();
		txtValorComprado.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtValorComprado.setBounds(299, 48, 86, 20);
		frmGeradorDeCustos.getContentPane().add(txtValorComprado);
		txtValorComprado.setColumns(10);

		txtQuantidadeUsada = new JTextField();
		txtQuantidadeUsada.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtQuantidadeUsada.setColumns(10);
		txtQuantidadeUsada.setBounds(397, 48, 78, 20);
		frmGeradorDeCustos.getContentPane().add(txtQuantidadeUsada);

		JLabel lbContador = new JLabel("0");
		lbContador.setHorizontalAlignment(SwingConstants.CENTER);
		lbContador.setBounds(497, 130, 72, 16);
		frmGeradorDeCustos.getContentPane().add(lbContador);

		JLabel lbCustoTotal = new JLabel("R$ 0,00");
		lbCustoTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lbCustoTotal.setBounds(497, 186, 75, 16);
		frmGeradorDeCustos.getContentPane().add(lbCustoTotal);

		JButton btAdiciona = new JButton("Adiciona");
		btAdiciona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String nome = txtNome.getText().toUpperCase();//deixa o nome em maiúscula
					String tipoUnidade = cbTipo.getSelectedItem().toString();
					String tipoComprado = cbUnidadeComprada.getSelectedItem().toString();
					double quantidadeComprada = Double.parseDouble(txtQuantidadeComprada.getText().replace(",", "."));
					double valorComprado = Double.parseDouble(txtValorComprado.getText().replace(",", "."));
					String tipoUsado = cbUnidadeUsada.getSelectedItem().toString();
					double quantidadeUsada = Double.parseDouble(txtQuantidadeUsada.getText().replace(",", "."));

					Product product = new Product(nome, tipoUnidade, tipoComprado, quantidadeComprada, valorComprado,
							tipoUsado, quantidadeUsada);

					lista.add(product);
					contador++;
					lbContador.setText(contador.toString());
					custoTotal += product.geraCusto();
					lbCustoTotal.setText("R$" + String.format("%.2f", custoTotal));
				} catch (NumberFormatException exception) {
					System.out.println("Formato numérico inválido");
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		btAdiciona.setBounds(487, 29, 89, 23);
		frmGeradorDeCustos.getContentPane().add(btAdiciona);

		JTextArea txtLista = new JTextArea();
		txtLista.setFont(new Font("SansSerif", Font.PLAIN, 16));
		txtLista.setBounds(10, 108, 465, 358);
		frmGeradorDeCustos.getContentPane().add(txtLista);

		JButton btLimpa = new JButton("Limpa");
		btLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText(null);
				txtQuantidadeComprada.setText(null);
				txtValorComprado.setText(null);
				txtQuantidadeUsada.setText(null);
			}
		});
		btLimpa.setBounds(487, 57, 89, 23);
		frmGeradorDeCustos.getContentPane().add(btLimpa);

		JButton btLista = new JButton("Listar");
		btLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista.size() > 0) {
					double somaTotal = 0.0;

					for (Product p : lista) {
						somaTotal += p.geraCusto();
						txtLista.append(p.toString());
						txtLista.append("------------------------------------------\n");
					}
					txtLista.append("O custo total foi de R$" + String.format("%.2f", somaTotal));
				}
			}
		});
		btLista.setBounds(487, 81, 89, 23);
		frmGeradorDeCustos.getContentPane().add(btLista);

		JLabel lblNewLabel_3 = new JLabel("Ingredientes");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(487, 114, 89, 16);
		frmGeradorDeCustos.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Custo");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(507, 158, 55, 16);
		frmGeradorDeCustos.getContentPane().add(lblNewLabel_4);

	}

	private class SwingAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
