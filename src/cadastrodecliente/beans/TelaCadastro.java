/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cadastrodecliente.beans;

import javax.swing.JOptionPane;

/**
 *
 * @author carol
 */
public class TelaCadastro extends javax.swing.JFrame {
    
    MySQL conectar = new MySQL(); //acessar os métodos de conexao com o banco
    Cliente novoCliente = new Cliente(); //acessar os atributos da classe cliente
    
    /**
     * Creates new form TelaCadastro
     */
    
    public TelaCadastro() {
        initComponents();
      
        uf_cadastro_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RO", "AC", "AM", "RR", "PA", "AP", "TO", "MA", "PI", "CE", "RN", "PB", "PE", "AL", "SE", "BA", "MG", "ES", "RJ", "SP", "PR", "SC", "RS", "MS", "MT", "GO", "DF"  }));
    }
    
    private void cadastraCliente(Cliente novoCliente){
        this.conectar.conectaBanco(); 
        
        novoCliente.setNome(nome_cadastro.getText());
        novoCliente.setCpf(cpf_cadastro.getText());
        novoCliente.setUf((String) uf_cadastro_combobox.getSelectedItem());
        novoCliente.setEmail(email_cadastro.getText());
        novoCliente.setCidade(cidade_cadastro.getText());
        novoCliente.setTelefone((String) telefone_cadastro.getText());
    }
    
    private void buscarCliente(Cliente novoCliente){
        this.conectar.conectaBanco();
        
        String consultaCpf = this.cpf_buscar.getText();
                
        try {
            this.conectar.executarSQL(
                   "SELECT "
                    + "nome,"                    
                    + "email,"
                    + "telefone,"
                    + "cidade,"
                    + "uf"
                 + " FROM"
                     + " cadastroclientes"
                 + " WHERE"
                     + " cpf = '" + consultaCpf + "'"
                + ";"
            );
            
            while(this.conectar.getResultSet().next()){
                novoCliente.setNome(this.conectar.getResultSet().getString(1));
                novoCliente.setEmail(this.conectar.getResultSet().getString(2));
                novoCliente.setTelefone(this.conectar.getResultSet().getString(3));
                novoCliente.setCidade(this.conectar.getResultSet().getString(4));
                novoCliente.setUf(this.conectar.getResultSet().getString(5));
           }
            
           if (novoCliente.getNome().isEmpty()){
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
           }
           
        } catch (Exception e) {            
            System.out.println("Erro ao consultar cliente " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente");
            
        } finally{
            nome_atualizar_deletar.setText(novoCliente.getNome());
            email_atualizar_deletar.setText(novoCliente.getEmail());
            telefone_atualizar_deletar.setText(novoCliente.getTelefone());
            cidade_atualizar_deletar.setText(novoCliente.getCidade());
            uf_atualizar_deletar_combobox.setSelectedItem(novoCliente.getUf());
            this.conectar.fechaBanco();   
        }               
    }
    
      private void deletarCliente(Cliente novoCliente){
        this.conectar.conectaBanco();
        
        String consultaCpf = this.cpf_buscar.getText(); 
        
        try {            
            this.conectar.updateSQL(
                "DELETE FROM cadastroclientes "
                + " WHERE "
                    + "cpf = '" + consultaCpf + "'"
                + ";"            
            );
            
        } catch (Exception e) {
            System.out.println("Erro ao deletar cliente " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao deletar cliente");
        } finally{
            this.conectar.fechaBanco();
            limparCamposBusca();
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");            
        }     
        
    }
      
    public void atualizarCliente(Cliente novoCliente){
        this.conectar.conectaBanco();
        
        String consultaCpf = this.cpf_buscar.getText();
        
        try {
            this.conectar.updateSQL(
                "UPDATE cadastroclientes SET "                    
                    + "nome = '" + nome_atualizar_deletar.getText() + "',"
                    + "email = '" + email_atualizar_deletar.getText() + "',"
                    + "telefone = '" + telefone_atualizar_deletar.getText() + "',"
                    + "cidade = '" + cidade_atualizar_deletar.getText() + "',"                   
                    + "uf = '" + uf_atualizar_deletar_combobox.getSelectedItem() + "'"
                + " WHERE "
                    + "cpf = '" + consultaCpf + "'"
                + ";"
            );
        } catch(Exception e){
            System.out.println("Erro ao atualizar cliente " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente");
        } finally {
            this.conectar.fechaBanco();
            limparCamposBusca();
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        }
    }  
    
    private void limparCamposCadastro(){
        nome_cadastro.setText("");
        cpf_cadastro.setText("");
        uf_cadastro_combobox.setSelectedItem(0);
        email_cadastro.setText("");
        cidade_cadastro.setText("");
        telefone_cadastro.setText("");
    }
        
    private void limparCamposBusca(){
        nome_atualizar_deletar.setText("");
        cpf_buscar.setText("");
        uf_atualizar_deletar_combobox.setSelectedItem(0);
        email_atualizar_deletar.setText("");
        cidade_atualizar_deletar.setText("");
        telefone_atualizar_deletar.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botao_cadastrar = new javax.swing.JButton();
        botao_limpar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cpf_buscar = new javax.swing.JFormattedTextField();
        botao_limpar_busca = new javax.swing.JButton();
        botao_buscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Label_nome_cadastro = new javax.swing.JLabel();
        nome_cadastro = new javax.swing.JTextField();
        Label_email_cadastro = new javax.swing.JLabel();
        email_cadastro = new javax.swing.JTextField();
        Label_telefone_cadastro = new javax.swing.JLabel();
        telefone_cadastro = new javax.swing.JFormattedTextField();
        Label_cpf_cadastro = new javax.swing.JLabel();
        cpf_cadastro = new javax.swing.JFormattedTextField();
        Label_cidade_cadastro = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        uf_cadastro_combobox = new javax.swing.JComboBox<>();
        cidade_cadastro = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nome_atualizar_deletar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        email_atualizar_deletar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        uf_atualizar_deletar_combobox = new javax.swing.JComboBox<>();
        cidade_atualizar_deletar = new javax.swing.JTextField();
        telefone_atualizar_deletar = new javax.swing.JFormattedTextField();
        botao_atualizar = new javax.swing.JButton();
        botao_deletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        botao_cadastrar.setText("Cadastrar");
        botao_cadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botao_cadastrarMouseClicked(evt);
            }
        });
        botao_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_cadastrarActionPerformed(evt);
            }
        });

        botao_limpar.setText("Limpar");
        botao_limpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botao_limparMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(botao_cadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botao_limpar)
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_limpar)
                    .addComponent(botao_cadastrar))
                .addGap(14, 14, 14))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Busca de Clientes"));

        jLabel9.setText("CPF");

        cpf_buscar.setText("   .   .   -  ");

        botao_limpar_busca.setText("Limpar");

        botao_buscar.setText("Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botao_limpar_busca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botao_buscar)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cpf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_limpar_busca)
                    .addComponent(botao_buscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Cliente"));
        jPanel3.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        Label_nome_cadastro.setText("Nome");

        nome_cadastro.setText("Nome");
        nome_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_cadastroActionPerformed(evt);
            }
        });

        Label_email_cadastro.setText("e-mail");

        email_cadastro.setText("e-mail");

        Label_telefone_cadastro.setText("Telefone");

        telefone_cadastro.setText("(  )     -    ");
        telefone_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefone_cadastroActionPerformed(evt);
            }
        });

        Label_cpf_cadastro.setText("CPF");

        cpf_cadastro.setText("   .   .   -  ");

        Label_cidade_cadastro.setText("Cidade");

        jLabel7.setText("UF");

        uf_cadastro_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        uf_cadastro_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uf_cadastro_comboboxActionPerformed(evt);
            }
        });

        cidade_cadastro.setText("jTextField4");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nome_cadastro)
                    .addComponent(email_cadastro)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_nome_cadastro)
                            .addComponent(Label_email_cadastro)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cidade_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Label_cidade_cadastro, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(uf_cadastro_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(Label_telefone_cadastro)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(telefone_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Label_cpf_cadastro)
                                        .addComponent(cpf_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_nome_cadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_email_cadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_telefone_cadastro)
                    .addComponent(Label_cpf_cadastro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefone_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_cidade_cadastro)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uf_cadastro_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidade_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Atualizar informações ou Deletar Cliente"));

        jLabel1.setText("Nome");

        nome_atualizar_deletar.setText("jTextField3");

        jLabel8.setText("e-mail");

        email_atualizar_deletar.setText("jTextField5");

        jLabel10.setText("Telefone");

        jLabel11.setText("Cidade");

        jLabel12.setText("UF");

        uf_atualizar_deletar_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cidade_atualizar_deletar.setText("jTextField8");

        telefone_atualizar_deletar.setText("(  )     -    ");

        botao_atualizar.setText("Atualizar");
        botao_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_atualizarActionPerformed(evt);
            }
        });

        botao_deletar.setText("Deletar");
        botao_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_deletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(nome_atualizar_deletar)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(140, 140, 140))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(cidade_atualizar_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(uf_atualizar_deletar_combobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(email_atualizar_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telefone_atualizar_deletar)
                        .addContainerGap())))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(botao_atualizar)
                .addGap(18, 18, 18)
                .addComponent(botao_deletar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome_atualizar_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_atualizar_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefone_atualizar_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uf_atualizar_deletar_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidade_atualizar_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_atualizar)
                    .addComponent(botao_deletar))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uf_cadastro_comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uf_cadastro_comboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uf_cadastro_comboboxActionPerformed

    private void nome_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_cadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_cadastroActionPerformed

    private void botao_cadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botao_cadastrarMouseClicked

        this.conectar.conectaBanco(); 
        
        novoCliente.setNome(nome_cadastro.getText());
        novoCliente.setCpf(cpf_cadastro.getText());
        novoCliente.setTelefone(telefone_cadastro.getText());
        novoCliente.setUf((String)uf_cadastro_combobox.getSelectedItem());
        novoCliente.setCidade(cidade_cadastro.getText());
        novoCliente.setEmail(email_cadastro.getText());
        
        try {
                        
            this.conectar.insertSQL("INSERT INTO cadastroclientes ("
                    + "nome,"
                    + "cpf,"
                    + "email,"
                    + "telefone,"
                    + "cidade,"
                    + "uf"
                + ") VALUES ("
                    + "'" + novoCliente.getNome() + "',"
                    + "'" + novoCliente.getCpf() + "',"
                    + "'" + novoCliente.getEmail() + "',"
                    + "'" + novoCliente.getTelefone() + "',"
                    + "'" + novoCliente.getCidade() + "',"
                    + "'" + novoCliente.getUf() + "'"
                + ");");
            
        } catch (Exception e) {
            
            System.out.println("Erro ao cadastrar cliente " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente");
            
        } finally{            
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
            //novoCliente.limpaCliente();
            //limparCamposCadastro();
        }           
        
            // TODO add your handling code here:
    }//GEN-LAST:event_botao_cadastrarMouseClicked

    private void botao_limparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botao_limparMouseClicked
         limparCamposCadastro();
    }//GEN-LAST:event_botao_limparMouseClicked

    private void botao_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_atualizarActionPerformed
         atualizarCliente(novoCliente);
    }//GEN-LAST:event_botao_atualizarActionPerformed

    private void botao_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_deletarActionPerformed
        deletarCliente(novoCliente);
    }//GEN-LAST:event_botao_deletarActionPerformed

    private void telefone_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefone_cadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefone_cadastroActionPerformed

    private void botao_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_cadastrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botao_cadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_cidade_cadastro;
    private javax.swing.JLabel Label_cpf_cadastro;
    private javax.swing.JLabel Label_email_cadastro;
    private javax.swing.JLabel Label_nome_cadastro;
    private javax.swing.JLabel Label_telefone_cadastro;
    private javax.swing.JButton botao_atualizar;
    private javax.swing.JButton botao_buscar;
    private javax.swing.JButton botao_cadastrar;
    private javax.swing.JButton botao_deletar;
    private javax.swing.JButton botao_limpar;
    private javax.swing.JButton botao_limpar_busca;
    private javax.swing.JTextField cidade_atualizar_deletar;
    private javax.swing.JTextField cidade_cadastro;
    private javax.swing.JFormattedTextField cpf_buscar;
    private javax.swing.JFormattedTextField cpf_cadastro;
    private javax.swing.JTextField email_atualizar_deletar;
    private javax.swing.JTextField email_cadastro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField nome_atualizar_deletar;
    private javax.swing.JTextField nome_cadastro;
    private javax.swing.JFormattedTextField telefone_atualizar_deletar;
    private javax.swing.JFormattedTextField telefone_cadastro;
    private javax.swing.JComboBox<String> uf_atualizar_deletar_combobox;
    private javax.swing.JComboBox<String> uf_cadastro_combobox;
    // End of variables declaration//GEN-END:variables
}
