package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Alumno;
import model.AlumnoData;
import model.Inscripcion;
import model.InscripcionData;
import model.Materia;
import view.NotasView;

public class NotasController implements ActionListener, ItemListener {

    Conexion con = new Conexion();
    AlumnoData alumnoData = new AlumnoData(con);
    InscripcionData data = new InscripcionData(con);

    NotasView vista = new NotasView();
    DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<Alumno> listaAlumno = new ArrayList();
   ArrayList<Inscripcion> inscripciones= new ArrayList();
    Alumno a = new Alumno();

    public NotasController(NotasView v) {
        vista = v;
        this.vista.btnSeleccionar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        this.vista.jcbAlumnos.addItemListener(this);
        llenarComboBox();
        llenarTabla(vista.jtNotas, (Alumno) vista.jcbAlumnos.getSelectedItem());
    }

    public void llenarComboBox() {
        Vector<Alumno> alumnosActivos = new Vector<Alumno>(data.listarAlumnosActivos());
        DefaultComboBoxModel modeloInscripcion = new DefaultComboBoxModel(alumnosActivos);
        vista.jcbAlumnos.setModel(modeloInscripcion);

    }

    public void llenarTabla(JTable tabla, Alumno alumno) {
        modelo.setRowCount(0);
        modelo = (DefaultTableModel) tabla.getModel();
        
        inscripciones = (ArrayList<Inscripcion>) data.inscripcionesDeAlumno(alumno);
        
        Object[] object = new Object[3];
        for (int i = 0; i < inscripciones.size(); i++) {
            object[0] = inscripciones.get(i).getIdInscripcion();
            object[1] = inscripciones.get(i).getMateria().getNombre();
            object[2] = inscripciones.get(i).getNota();
            modelo.addRow(object);
        }
        vista.jtNotas.setModel(modelo);
    }

    public int cargarNota() {
        double nota = Double.parseDouble(vista.txtNota.getText());
        int r = data.cargarNota(Integer.parseInt(vista.txtIDMateria.getText()), nota);
        if(r==1){
            return 1;
        }else{
            return 0;
        }
    }

    public void seleccionar() {
        int fila = vista.jtNotas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            int id = Integer.parseInt(vista.jtNotas.getValueAt(fila, 0).toString());
            String nombre = (String) vista.jtNotas.getValueAt(fila, 1);
            double nota = Double.parseDouble(vista.jtNotas.getValueAt(fila, 2).toString());

            vista.txtNota.setText("" + nota);
            vista.txtIDMateria.setText(""+id);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.btnSeleccionar) {
            seleccionar();
        }

          if (e.getSource() == vista.btnGuardar) {
            int r=cargarNota();
            if (r == 1) {
                llenarTabla(vista.jtNotas, a);
                JOptionPane.showMessageDialog(vista, "Nota registrada");
            }
        }

        if (e.getSource() == vista.btnCancelar) {
            vista.btnCancelar.setSelected(true);
            modelo.setRowCount(0);//Borras todas las filas
            vista.txtNota.setText("");
        }
         
    }

    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getStateChange() == ItemEvent.SELECTED) {
            this.a = (Alumno) vista.jcbAlumnos.getSelectedItem();
            System.out.println(a);
            llenarTabla(vista.jtNotas, a);
        }
    }

}
