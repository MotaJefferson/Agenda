package agenda.view.gui;

import agenda.dao.ContatoDAO;
import agenda.interfaces.IContatoListener;
import agenda.model.Contato;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

public class FrameBuscar extends javax.swing.JFrame {

    private IContatoListener listener;
    
    public FrameBuscar(IContatoListener listener) {
        this.listener = listener;
        initComponents();
        
        jTabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTabela.getColumn(jTabela.getColumnName(0)).setPreferredWidth(90);  //id do Contrato
        jTabela.getColumn(jTabela.getColumnName(1)).setPreferredWidth(220); //Nome
        jTabela.getColumn(jTabela.getColumnName(2)).setPreferredWidth(120); //DtNascimento
        jTabela.getColumn(jTabela.getColumnName(3)).setPreferredWidth(150);  //Telefone
        jTabela.getColumn(jTabela.getColumnName(4)).setPreferredWidth(150);  //Email
        jTabela.getColumn(jTabela.getColumnName(5)).setPreferredWidth(200);  //Endereço
        jTabela.getColumn(jTabela.getColumnName(6)).setPreferredWidth(300);  //Observações
        jTabela.getColumn(jTabela.getColumnName(7)).setPreferredWidth(150);  //Criado Em
    }
    
    private FrameBuscar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void buscar(){
        
        ContatoDAO contatoDAO = new ContatoDAO();
        List<Contato> contatos = contatoDAO.buscarTodosContatos();
                
        String nomeFiltro = Txt_Nome.getText().trim();
        String telFiltro = Txt_Telefone.getText().trim();
        String email = Txt_Email.getText().trim();
        
        List<Contato> dadosFiltrados = contatos.stream()
                .filter(contato -> nomeFiltro.isEmpty() || contato.getNome().toLowerCase().contains(nomeFiltro.toLowerCase()))
                .filter(contato -> telFiltro.isEmpty() || contato.getTelefone().toLowerCase().contains(telFiltro.toLowerCase()))
                .filter(contato -> email.isEmpty() || contato.getEmail().toLowerCase().contains(email.toLowerCase()))
                .collect(Collectors.toList());
        
        atualizarTabela(dadosFiltrados);
        
    }
    
    public void atualizarTabela(List<Contato> contatos){
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DefaultTableModel modeloTabela = (DefaultTableModel) jTabela.getModel();        
        modeloTabela.setRowCount(0);
        
        for (Contato contato : contatos) {
            modeloTabela.addRow(new Object[]{contato.getContatoId(),
                contato.getNome(), contato.getDataNascimento(), contato.getTelefone(),
                contato.getEmail(), contato.getEndereco(), contato.getObservacoes(), contato.getCriadoEm().format(formatter)});
        }        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lbl_Nome = new javax.swing.JLabel();
        Txt_Nome = new javax.swing.JTextField();
        Lbl_Telefone = new javax.swing.JLabel();
        Txt_Telefone = new javax.swing.JTextField();
        Txt_Email = new javax.swing.JTextField();
        Lbl_Email = new javax.swing.JLabel();
        Lbl_Title = new javax.swing.JLabel();
        Btn_Buscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Lbl_Nome.setText("Nome");

        Lbl_Telefone.setText("Telefone");

        Lbl_Email.setText("E-mail");

        Lbl_Title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Lbl_Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Lbl_Title.setText("Buscar Contato");

        Btn_Buscar.setText("Buscar");
        Btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BuscarActionPerformed(evt);
            }
        });

        jTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID do Contato", "Nome", "Data de Nascimento", "Telefone", "E-mail", "Endereço", "Observações", "Criado Em"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Lbl_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(Lbl_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Lbl_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Txt_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(Btn_Buscar))
                    .addComponent(Txt_Nome)
                    .addComponent(jScrollPane3))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Lbl_Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lbl_Nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Txt_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_Telefone)
                    .addComponent(Lbl_Email))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Buscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BuscarActionPerformed

        buscar();
    }//GEN-LAST:event_Btn_BuscarActionPerformed

    private void jTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaMouseClicked

        ContatoDAO contatoDAO = new ContatoDAO();
                
        int linhaSelecionada = jTabela.getSelectedRow();

        if (linhaSelecionada != -1) {

            int id = Integer.parseInt(jTabela.getValueAt(linhaSelecionada, 0).toString());             
            Contato contatoFiltrado = contatoDAO.buscarContatoPorId(id);
            
            if (listener != null) {
                listener.contatoSelecionado(contatoFiltrado);
            }

            this.dispose();
        }

    }//GEN-LAST:event_jTabelaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameBuscar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Buscar;
    private javax.swing.JLabel Lbl_Email;
    private javax.swing.JLabel Lbl_Nome;
    private javax.swing.JLabel Lbl_Telefone;
    private javax.swing.JLabel Lbl_Title;
    private javax.swing.JTextField Txt_Email;
    private javax.swing.JTextField Txt_Nome;
    private javax.swing.JTextField Txt_Telefone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTabela;
    // End of variables declaration//GEN-END:variables
}
