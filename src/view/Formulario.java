package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import negocio.Avaliacao;

/**
 *
 * @author dreis
 */
class Formulario {

    private JFrame form;
    private JLabel lblPresenca, lblAula, lblVl1, lblVl2, lblVl3, lblSituacao;
    private JTextField txtPresenca, txtAula, txtVl1, txtVl2, txtVl3;
    private JButton btnSituacao;
    
    public Formulario() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        form = new JFrame("Calcular Media");
        form.setBounds(450, 200, 350, 280);

        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLayout(null);
        Container painel = form.getContentPane();
        
        lblPresenca = new JLabel("Presença");
        lblPresenca.setBounds(160, 20, 60, 25);
        painel.add(lblPresenca);
        
        txtPresenca = new JTextField();
        txtPresenca.setBounds(250, 20, 60, 25);
        txtPresenca.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                validarPreenchimentoNumerico(e, true);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                zerarResultado();
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        painel.add(txtPresenca);
        
        lblAula = new JLabel("Aulas Previstas");
        lblAula.setBounds(160,55, 120, 25);
        painel.add(lblAula);
        
        txtAula = new JTextField();
        txtAula.setBounds(250, 55, 60, 25);
        txtAula.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                validarPreenchimentoNumerico(e, false);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                zerarResultado();
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        painel.add(txtAula);
        
        lblVl1 = new JLabel("Valor P1");
        lblVl1.setBounds(10, 20, 60, 25);
        painel.add(lblVl1);
        
        txtVl1 = new JTextField();
        txtVl1.setBounds(80, 20, 60, 25);
        txtVl1.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                validarPreenchimentoNumerico(e, false);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                zerarResultado();
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        painel.add(txtVl1);
        
        lblVl2 = new JLabel("Valor P2");
        lblVl2.setBounds(10, 55 , 60, 25);
        painel.add(lblVl2);
        
        txtVl2 = new JTextField();
        txtVl2.setBounds(80, 55, 60, 25);
        txtVl2.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                validarPreenchimentoNumerico(e, false);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                zerarResultado();
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        painel.add(txtVl2);
        
        
        lblVl3 = new JLabel("Valor P3");
        lblVl3.setBounds(10, 90, 60, 25);
        painel.add(lblVl3);
        
        txtVl3 = new JTextField();
        txtVl3.setBounds(80, 90, 60, 25);
        txtVl3.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                validarPreenchimentoNumerico(e, false);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                zerarResultado();
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        painel.add(txtVl3);
                
        lblSituacao = new JLabel("Calcular Situação");
        lblSituacao.setForeground(Color.RED);
        lblSituacao.setBounds(10, 150, 200, 25);
        painel.add(lblSituacao);
        
        btnSituacao = new JButton("Calcular Situação");
        btnSituacao.setForeground(Color.RED);
        btnSituacao.setBounds(70, 205, 200, 20);
        btnSituacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Avaliacao ava = new Avaliacao();
                float p1 = Float.parseFloat(txtVl1.getText());
                float p2 = Float.parseFloat(txtVl2.getText());
                String txtP3 = txtVl3.getText();
                if (txtP3.isEmpty()){
                    ava.calcularMedia(p1, p2);

             } else{
                    float p3 = Float.parseFloat(txtP3);
                    ava.calcularMedia(p1, p2, p3);
                }
                float presenca = Float.parseFloat(txtPresenca.getText());
                float aulaPrevista = Float.parseFloat(txtAula.getText());
                ava.calcularPercentualPresenca(aulaPrevista, presenca);
               
                if(ava.getMediaFinal()>=6 && ava.getPercentualPresenca()>=75){
                   lblSituacao.setText("Resultado: Aprovado");
                }else{
                   lblSituacao.setText("Resultado: Reprovado"); 
                }
         }
       });
        painel.add(btnSituacao);
        
        form.setVisible(true);
    }
    
    private void zerarResultado(){
        lblSituacao.setText("");
    }
    
    private void validarPreenchimentoNumerico(KeyEvent e, boolean permitePontoDecimal) {
        if (!Character.isDigit(e.getKeyChar()) && (e.getKeyChar() != '.' || !permitePontoDecimal)){
            e.consume();
        }
    }    
}
