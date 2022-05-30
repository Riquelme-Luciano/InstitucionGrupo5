package view;

import controller.AlumnoController;

public class AlumnoView extends javax.swing.JFrame {

    public AlumnoView() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        seccionDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        checkActivo = new javax.swing.JCheckBox();
        txtApellido = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        calendarFecha = new com.toedter.calendar.JDateChooser();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        seccionDatos.setBackground(new java.awt.Color(204, 255, 153));
        seccionDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Alumno");
        seccionDatos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 14, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Apellido:");
        seccionDatos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre:");
        seccionDatos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Activo:");
        seccionDatos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nacimiento:");
        seccionDatos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        checkActivo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        checkActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActivoActionPerformed(evt);
            }
        });
        seccionDatos.add(checkActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, 30));

        txtApellido.setBackground(new java.awt.Color(255, 255, 255));
        txtApellido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(0, 0, 0));
        seccionDatos.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 296, 41));

        btnEditar.setBackground(new java.awt.Color(255, 102, 0));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Actualizar");
        seccionDatos.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 120, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 0, 51));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        seccionDatos.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 120, -1));

        btnHome.setBackground(new java.awt.Color(153, 255, 255));
        btnHome.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnHome.setForeground(new java.awt.Color(0, 0, 0));
        btnHome.setText("Casa");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        seccionDatos.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        seccionDatos.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 296, 41));

        btnEliminar.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        seccionDatos.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 120, -1));

        txtID.setEditable(false);
        txtID.setBackground(new java.awt.Color(255, 255, 255));
        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtID.setForeground(new java.awt.Color(0, 0, 0));
        seccionDatos.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 30, -1));

        calendarFecha.setBackground(new java.awt.Color(255, 255, 255));
        calendarFecha.setForeground(new java.awt.Color(0, 0, 0));
        calendarFecha.setDateFormatString("dd,MM,yyyy");
        calendarFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        seccionDatos.add(calendarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 290, 40));

        btnGuardar.setBackground(new java.awt.Color(0, 204, 0));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        seccionDatos.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 120, -1));

        tablaAlumnos.setBackground(new java.awt.Color(255, 204, 153));
        tablaAlumnos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaAlumnos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tablaAlumnos.setForeground(new java.awt.Color(0, 0, 0));
        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "Nacimiento", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAlumnos.setGridColor(new java.awt.Color(102, 102, 102));
        tablaAlumnos.setSelectionBackground(new java.awt.Color(246, 192, 50));
        tablaAlumnos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tablaAlumnos);

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBuscar.setToolTipText("");
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnSeleccionar.setBackground(new java.awt.Color(255, 102, 51));
        btnSeleccionar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setText("Seleccionar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(seccionDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addComponent(seccionDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkActivoActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtID.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        calendarFecha.setDate(null);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        InicioView v = new InicioView();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnHome;
    public javax.swing.JButton btnSeleccionar;
    public com.toedter.calendar.JDateChooser calendarFecha;
    public javax.swing.JCheckBox checkActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel seccionDatos;
    public javax.swing.JTable tablaAlumnos;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
