package vistas;

import datos.ArchivosDAO;
import datos.JDBCDAO;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.Policia;

public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    java.util.Calendar calendario;
    int dia, mes, año, hora, minutos, segundos;
    String horaf = "";
    JDBCDAO jd = new JDBCDAO();
    ArchivosDAO ad = new ArchivosDAO();
    Policia pSelected;

    public Principal() {
        initComponents();
        //Cargar Tabla Policia
        cargaTablaPolicias("idPolicia");
        PoliciaTabla.setAutoCreateRowSorter(true);

        //Titulo
        this.setTitle("Centro de Administracion Policial");

        //Posicionamiento y Tamaño
        this.setSize(1200, 628);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //Cambiar Icono de ventana
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono_ventana_policia.png")).getImage());

        //Poner Imagen de fondo en JFrame
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon MyImgCustom = new ImageIcon(this.getClass().getResource("/imagenes/fondo_poli.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(MyImgCustom);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, MyImgCustom.getIconWidth(), MyImgCustom.getIconHeight());

        //Reloj
        reloj();
    }

    private void reloj() {

        calendario = new java.util.GregorianCalendar();
        javax.swing.Timer timer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                java.util.Date actual = new java.util.Date();
                calendario.setTime(actual);
                dia = calendario.get(Calendar.DAY_OF_MONTH);
                mes = (calendario.get(Calendar.MONTH) + 1);
                año = calendario.get(Calendar.YEAR);
                hora = calendario.get(Calendar.HOUR_OF_DAY);
                minutos = calendario.get(Calendar.MINUTE);
                segundos = calendario.get(Calendar.SECOND);
                String hour = String.format("%02d : %02d : %02d", hora, minutos, segundos);
                String date = String.format("%02d / %02d / %02d", dia, mes, año);
                horaf = ("<html><center>" + hour + "<br>" + date);
                reloj.setText(horaf);

            }
        });
        timer.start();
    }

    private void cargaTablaPolicias(String ordenacion) {
        String[] titulos = {"idPolicia", "Nombre", "Nº Placa", "Edad", "Departamento"};
        String[] fila = new String[6];
        List<Policia> listaPolicias;
        listaPolicias = jd.MostrarPolicias("idPolicia");
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        for (Policia p : listaPolicias) {
            fila[0] = p.getIdPolicia().toString();
            fila[1] = p.getNombre();
            fila[2] = p.getNumPlaca();
            fila[3] = p.getEdad().toString();
            fila[4] = p.getDepartamento();
            fila[5] = p.getFoto();
            model.addRow(fila);
        }
        this.PoliciaTabla.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        btt_multas = new javax.swing.JButton();
        btt_policias = new javax.swing.JButton();
        btt_lista = new javax.swing.JButton();
        reloj = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        PoliciaTabla = new javax.swing.JTable();
        BotonCargarPolicias = new javax.swing.JButton();
        BotonBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btt_multas.setText("Multas");
        btt_multas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btt_multas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_multasActionPerformed(evt);
            }
        });

        btt_policias.setText("Policias");
        btt_policias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btt_policias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_policiasActionPerformed(evt);
            }
        });

        btt_lista.setText("Lista Multas");
        btt_lista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btt_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_listaActionPerformed(evt);
            }
        });

        reloj.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        PoliciaTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idPolicia", "Nombre", "Nº Placa", "Edad", "Departamento"
            }
        ));
        PoliciaTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PoliciaTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(PoliciaTabla);

        BotonCargarPolicias.setText("Cargar Policias");
        BotonCargarPolicias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCargarPoliciasActionPerformed(evt);
            }
        });

        BotonBorrar.setText("Borrar Policia");
        BotonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btt_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btt_multas, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 491, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reloj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BotonBorrar)
                                .addGap(87, 87, 87)
                                .addComponent(BotonCargarPolicias, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btt_policias, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btt_multas, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotonCargarPolicias)
                        .addComponent(BotonBorrar))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addComponent(btt_policias, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reloj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(btt_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btt_multasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_multasActionPerformed

        MultasIntroducir multas_ventana = new MultasIntroducir(this, true, jd);
        multas_ventana.setVisible(true);
    }//GEN-LAST:event_btt_multasActionPerformed

    private void btt_policiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_policiasActionPerformed
        PoliciasMantenimiento policias_ventana = new PoliciasMantenimiento(this, true, jd, pSelected);
        policias_ventana.setVisible(true);
    }//GEN-LAST:event_btt_policiasActionPerformed

    private void btt_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_listaActionPerformed
        MultasListado listado_ventana = new MultasListado(this, true, jd);
        listado_ventana.setVisible(true);
    }//GEN-LAST:event_btt_listaActionPerformed

    private void PoliciaTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PoliciaTablaMouseClicked
        // TODO add your handling code here:
        int row = PoliciaTabla.getSelectedRow();
        if (row == -1) {
            pSelected = null;
        }
        int col = PoliciaTabla.getColumnCount();
        Integer idPolicia, edad;
        String nombre, numPlaca, departamento, foto = "";

        idPolicia = Integer.parseInt((String) PoliciaTabla.getValueAt(row, 0));
        nombre = (String) PoliciaTabla.getValueAt(row, 1);
        numPlaca = (String) PoliciaTabla.getValueAt(row, 2);
        edad = Integer.parseInt((String) PoliciaTabla.getValueAt(row, 3));
        departamento = (String) PoliciaTabla.getValueAt(row, 4);
        //foto = (String) jTable1.getValueAt(row, 5);

        pSelected = new Policia(idPolicia, nombre, numPlaca, edad, departamento, foto);

        //Abrir ventana
//        PoliciasMantenimiento policias_ventana = new PoliciasMantenimiento(this, true, jd, pSelected);
//        policias_ventana.setVisible(true);

    }//GEN-LAST:event_PoliciaTablaMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void BotonCargarPoliciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCargarPoliciasActionPerformed
//         Cargar un archivo txt para introducirlo en la base de datos y posterior carga en la tabla de la pantalla principal
        JFileChooser fc = new JFileChooser("C:\\Users\\Gerard\\Documents\\NetBeansProjects\\Comisaria\\Proyecto_Comisaria");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        String mensaje;
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            mensaje = ad.cargarPolicias(file);
            JOptionPane.showMessageDialog(this, mensaje, "Mensaje:", JOptionPane.INFORMATION_MESSAGE);
        }
        cargaTablaPolicias("idPolicia");
        PoliciaTabla.setAutoCreateRowSorter(true);
    }//GEN-LAST:event_BotonCargarPoliciasActionPerformed

    private void BotonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBorrarActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres borrarlo?", "Warning", dialogButton);

        if (dialogButton == dialogResult) {
            boolean borrado = jd.BorrarPolicia(pSelected.getIdPolicia());
            if (borrado == false) {
                JOptionPane.showMessageDialog(this, "No se puede borrar, tiene multas asociadas", "Imposible borrar", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        cargaTablaPolicias("idPolicia");
        PoliciaTabla.setAutoCreateRowSorter(true);
    }//GEN-LAST:event_BotonBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBorrar;
    private javax.swing.JButton BotonCargarPolicias;
    private javax.swing.JTable PoliciaTabla;
    private javax.swing.JButton btt_lista;
    private javax.swing.JButton btt_multas;
    private javax.swing.JButton btt_policias;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel reloj;
    // End of variables declaration//GEN-END:variables
}
