
package view;

import controller.AlumnoController;


public class InicioView extends javax.swing.JFrame {


    public InicioView() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNotas = new javax.swing.JButton();
        btnAlumnos = new javax.swing.JButton();
        btnMaterias1 = new javax.swing.JButton();
        btnInscripciones1 = new javax.swing.JButton();
        btnConsultas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 51));

        btnNotas.setBackground(new java.awt.Color(0, 102, 0));
        btnNotas.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNotas.setForeground(new java.awt.Color(255, 255, 255));
        btnNotas.setText("Notas");

        btnAlumnos.setBackground(new java.awt.Color(0, 102, 0));
        btnAlumnos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        btnAlumnos.setText("Alumnos");
        btnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosActionPerformed(evt);
            }
        });

        btnMaterias1.setBackground(new java.awt.Color(0, 102, 0));
        btnMaterias1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnMaterias1.setForeground(new java.awt.Color(255, 255, 255));
        btnMaterias1.setText("Materias");

        btnInscripciones1.setBackground(new java.awt.Color(0, 102, 0));
        btnInscripciones1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnInscripciones1.setForeground(new java.awt.Color(255, 255, 255));
        btnInscripciones1.setText("Inscripciones");

        btnConsultas.setBackground(new java.awt.Color(0, 102, 0));
        btnConsultas.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnConsultas.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultas.setText("Consultas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMaterias1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInscripciones1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btnAlumnos)
                .addGap(32, 32, 32)
                .addComponent(btnMaterias1)
                .addGap(41, 41, 41)
                .addComponent(btnInscripciones1)
                .addGap(39, 39, 39)
                .addComponent(btnNotas)
                .addGap(34, 34, 34)
                .addComponent(btnConsultas)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosActionPerformed
        AlumnoView v = new AlumnoView();
        AlumnoController c = new AlumnoController(v);
        v.setVisible(true);
        v.setLocationRelativeTo(v);
        this.dispose();
    }//GEN-LAST:event_btnAlumnosActionPerformed

    public static void main(String args[]) {
        InicioView v = new InicioView();
        v.setVisible(true);
        v.setLocationRelativeTo(v);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlumnos;
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton btnInscripciones1;
    private javax.swing.JButton btnMaterias1;
    private javax.swing.JButton btnNotas;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
