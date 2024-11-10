package agenda.view.gui;

import agenda.dao.ContatoDAO;
import agenda.interfaces.IContatoListener;
import agenda.model.Contato;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class Gui extends javax.swing.JFrame implements IContatoListener {

    public Gui() {
        initComponents();        
        SetEditableFields(false);
    }
    
    private void SetEditableFields(boolean opcao){
        Txt_Nome.setEditable(opcao);
        Txt_DtNascimento.setEditable(opcao);
        Txt_Telefone.setEditable(opcao);
        Txt_Email.setEditable(opcao);
        Txt_Endereco.setEditable(opcao);
        Txt_Obs.setEditable(opcao);
    }
    
    private void ClearFields(){
        Txt_Id.setText("");
        Txt_CriadoEm.setText("");
        Txt_Nome.setText("");        
        Txt_DtNascimento.setText("");
        Txt_Telefone.setText("");
        Txt_Email.setText("");
        Txt_Endereco.setText("");
        Txt_Obs.setText("");
    }
    
    private boolean CamposObrigatorios(){
        
        if(Txt_Nome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Digite o nome");
            Txt_Nome.requestFocus();
            return false;
        
        } else if (Txt_DtNascimento.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Digite a data de nascimento");
            Txt_DtNascimento.requestFocus();
            return false;
            
        } else if (Txt_Telefone.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"Digite o telefone");
            Txt_Telefone.requestFocus();
            return false;
            
        } else if (Txt_Email.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Digite o e-mail");
            Txt_Email.requestFocus();
            return false;
        
        } else if (Txt_Endereco.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Digite o endereço completo");
            Txt_Endereco.requestFocus();
            return false;
        
        } else {
            return true;
        }
    }
        
    private boolean isEmailValido(String email) {
        String regex = "^[\\w-\\.]+@[\\w-]+(?:\\.[a-z]{2,})+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isDataValida(String data) {
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([12][0-9]{3})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    private LocalDate parseData(String data) {
        
         if (data == null || data.trim().isEmpty()) {
            return null; 
        }

        if (!data.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException("Formato de data inválido. Use dd/MM/yyyy.");
        }

        String[] partes = data.split("/");
        try {
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]);

            return LocalDate.of(ano, mes, dia);
        } catch (NumberFormatException | DateTimeParseException e) {
            throw new IllegalArgumentException("Data inválida: " + data, e);
        }
    }
    
    public void contatoSelecionado(Contato contato){
        
        DateTimeFormatter formatDayHours = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter formatDay = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Txt_Id.setText(String.valueOf(contato.getContatoId()));
        Txt_CriadoEm.setText(String.valueOf(contato.getCriadoEm().format(formatDayHours)));
        Txt_Nome.setText(contato.getNome());
        Txt_DtNascimento.setText(String.valueOf(contato.getDataNascimento().format(formatDay)));
        Txt_Telefone.setText(contato.getTelefone());
        Txt_Email.setText(contato.getEmail());
        Txt_Endereco.setText(contato.getEndereco());
        Txt_Obs.setText(contato.getObservacoes());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn_Buscar = new javax.swing.JButton();
        Btn_Apagar = new javax.swing.JButton();
        Btn_Salvar = new javax.swing.JButton();
        Btn_Editar = new javax.swing.JButton();
        Btn_Novo = new javax.swing.JButton();
        Lbl_ID = new javax.swing.JLabel();
        Lbl_Nome = new javax.swing.JLabel();
        Lbl_Telefone = new javax.swing.JLabel();
        Lbl_Email = new javax.swing.JLabel();
        Lbl_Endereco = new javax.swing.JLabel();
        Lbl_DtNascimento = new javax.swing.JLabel();
        Lbl_CriadoEm = new javax.swing.JLabel();
        Lbl_Obs = new javax.swing.JLabel();
        Txt_Id = new javax.swing.JTextField();
        Txt_CriadoEm = new javax.swing.JTextField();
        Txt_Nome = new javax.swing.JTextField();
        Txt_DtNascimento = new javax.swing.JTextField();
        Txt_Telefone = new javax.swing.JTextField();
        Txt_Email = new javax.swing.JTextField();
        Txt_Endereco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Txt_Obs = new javax.swing.JTextArea();
        Lbl_Title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda de Contatos");
        setResizable(false);

        Btn_Buscar.setText("Buscar");
        Btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BuscarActionPerformed(evt);
            }
        });

        Btn_Apagar.setText("Apagar");
        Btn_Apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ApagarActionPerformed(evt);
            }
        });

        Btn_Salvar.setText("Salvar");
        Btn_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SalvarActionPerformed(evt);
            }
        });

        Btn_Editar.setText("Editar");
        Btn_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EditarActionPerformed(evt);
            }
        });

        Btn_Novo.setText("Novo");
        Btn_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NovoActionPerformed(evt);
            }
        });

        Lbl_ID.setText("ID do Contato");

        Lbl_Nome.setText("Nome");

        Lbl_Telefone.setText("Telefone");

        Lbl_Email.setText("E-mail");

        Lbl_Endereco.setText("Endereço");

        Lbl_DtNascimento.setText("Data de Nascimento");

        Lbl_CriadoEm.setText("Criado em");

        Lbl_Obs.setText("Observações");

        Txt_Id.setEditable(false);
        Txt_Id.setFocusable(false);

        Txt_CriadoEm.setEditable(false);
        Txt_CriadoEm.setFocusable(false);

        Txt_Obs.setColumns(20);
        Txt_Obs.setRows(5);
        jScrollPane1.setViewportView(Txt_Obs);

        Lbl_Title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Lbl_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Title.setText("Agenda de Contatos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Lbl_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Lbl_DtNascimento)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Btn_Salvar)
                                .addGap(43, 43, 43)
                                .addComponent(Btn_Apagar)
                                .addGap(42, 42, 42)
                                .addComponent(Btn_Buscar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Lbl_Endereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Lbl_Obs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btn_Novo)
                        .addGap(37, 37, 37)
                        .addComponent(Btn_Editar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Lbl_Title, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Txt_Endereco, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Txt_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(Txt_DtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Lbl_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Txt_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Lbl_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Txt_Email))))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lbl_ID)
                            .addComponent(Txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lbl_CriadoEm)
                            .addComponent(Txt_CriadoEm, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Lbl_Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_ID)
                    .addComponent(Lbl_CriadoEm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_CriadoEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lbl_DtNascimento)
                    .addComponent(Lbl_Nome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_DtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_Email)
                    .addComponent(Lbl_Telefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Lbl_Endereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Txt_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Lbl_Obs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(Btn_Apagar)
                        .addComponent(Btn_Salvar)
                        .addComponent(Btn_Buscar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Btn_Novo)
                        .addComponent(Btn_Editar)))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BuscarActionPerformed

        FrameBuscar frmBuscar = new FrameBuscar(this);
        frmBuscar.setLocationRelativeTo(null);
        frmBuscar.setVisible(true);

    }//GEN-LAST:event_Btn_BuscarActionPerformed

    private void Btn_ApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ApagarActionPerformed

        Contato contato = new Contato();
        ContatoDAO contatoDAO = new ContatoDAO();

        if(Txt_Id.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione um contato para deletar", "Atenção", JOptionPane.INFORMATION_MESSAGE);

        } else {

            try{

                contato.setContatoId(Integer.parseInt(Txt_Id.getText()));

                int idContato = contatoDAO.deletarContato(contato);

                if(idContato > 0){
                    JOptionPane.showMessageDialog(null, "Contato "+ Txt_Nome.getText() +" apagado com sucesso!", "Editado", JOptionPane.INFORMATION_MESSAGE);

                    ClearFields();
                    SetEditableFields(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao apagar o contato", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            }catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_Btn_ApagarActionPerformed

    private void Btn_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SalvarActionPerformed

        Contato contato = new Contato();
        ContatoDAO contatoDAO = new ContatoDAO();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        boolean idLoaded = Txt_Id.getText().trim().isEmpty() ? false : true;

        if(CamposObrigatorios()){
            
            contato.setNome(Txt_Nome.getText());
            contato.setTelefone(Txt_Telefone.getText());
            contato.setEndereco(Txt_Endereco.getText());
                    
            String dataNascimento;
            dataNascimento = Txt_DtNascimento.getText();
            if (isDataValida(dataNascimento)) {
                contato.setDataNascimento(parseData(dataNascimento));

            } else {                        
                JOptionPane.showMessageDialog(null, "Insira uma data válida no formato DD/MM/AAAA.", "Erro - Data Inválida", JOptionPane.ERROR_MESSAGE);
            }        
                    
            String email;
            email = Txt_Email.getText();
            if (isEmailValido(email)) {
                contato.setEmail(email);

            } else {
                JOptionPane.showMessageDialog(null, "Insira um email válido (exemplo@dominio.com).", "Erro - E-mail Inválida", JOptionPane.ERROR_MESSAGE);
            }
     

            if(idLoaded != true){

                try{

                    int idContato = contatoDAO.adicionarContato(contato);
                    

                    if(idContato > 0){
                        JOptionPane.showMessageDialog(null, "Contato "+ Txt_Nome.getText() +" adicionado com sucesso!", "Adicionado", JOptionPane.INFORMATION_MESSAGE);

                        Txt_Id.setText(String.valueOf(idContato));
                        Txt_CriadoEm.setText(String.valueOf(contato.getCriadoEm().format(formatter)));
                        SetEditableFields(false);

                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao adicionar o contato", "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                }catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }

            } else {

                contato.setContatoId(Integer.parseInt(Txt_Id.getText()));

                try{

                    int idContato = contatoDAO.atualizarContato(contato);

                    if(idContato > 0){
                        JOptionPane.showMessageDialog(null, "Contato "+ Txt_Nome.getText() +" editado com sucesso!", "Editado", JOptionPane.INFORMATION_MESSAGE);

                        Txt_Id.setText(String.valueOf(idContato));
                        SetEditableFields(false);

                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao editar o contato", "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                }catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_Btn_SalvarActionPerformed

    private void Btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EditarActionPerformed

        if(Txt_Id.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione um contato para editar", "Atenção", JOptionPane.INFORMATION_MESSAGE);

        } else {
            SetEditableFields(true);
        }
    }//GEN-LAST:event_Btn_EditarActionPerformed

    private void Btn_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NovoActionPerformed

        ClearFields();
        SetEditableFields(true);
    }//GEN-LAST:event_Btn_NovoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Apagar;
    private javax.swing.JButton Btn_Buscar;
    private javax.swing.JButton Btn_Editar;
    private javax.swing.JButton Btn_Novo;
    private javax.swing.JButton Btn_Salvar;
    private javax.swing.JLabel Lbl_CriadoEm;
    private javax.swing.JLabel Lbl_DtNascimento;
    private javax.swing.JLabel Lbl_Email;
    private javax.swing.JLabel Lbl_Endereco;
    private javax.swing.JLabel Lbl_ID;
    private javax.swing.JLabel Lbl_Nome;
    private javax.swing.JLabel Lbl_Obs;
    private javax.swing.JLabel Lbl_Telefone;
    private javax.swing.JLabel Lbl_Title;
    private javax.swing.JTextField Txt_CriadoEm;
    private javax.swing.JTextField Txt_DtNascimento;
    private javax.swing.JTextField Txt_Email;
    private javax.swing.JTextField Txt_Endereco;
    private javax.swing.JTextField Txt_Id;
    private javax.swing.JTextField Txt_Nome;
    private javax.swing.JTextArea Txt_Obs;
    private javax.swing.JTextField Txt_Telefone;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
