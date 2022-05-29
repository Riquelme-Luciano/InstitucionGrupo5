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

public class NotasController implements ActionListener,ItemListener{
    Conexion con= new Conexion();
    AlumnoData alumnoData = new AlumnoData(con);
    InscripcionData data = new InscripcionData(con);
    
    NotasView vista = new NotasView();
    DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<Alumno> listaAlumno = new ArrayList();
    ArrayList<Inscripcion> listaInscripto = new ArrayList();
    Alumno a = new Alumno();
    
    public NotasController(NotasView v) {
       vista=v;
       this.vista.jcbAlumnos.addItemListener(this);
       llenarComboBox();
    }
     
    public void llenarComboBox() {
        Vector<Alumno> alumnosActivos= new Vector<Alumno>(data.listarAlumnosActivos());
        DefaultComboBoxModel modeloInscripcion = new DefaultComboBoxModel(alumnosActivos);
        vista.jcbAlumnos.setModel(modeloInscripcion);
        
    }
    
    public void llenarTabla(JTable tabla, Alumno alumno) {
        modelo.setRowCount(0);
        modelo= (DefaultTableModel)tabla.getModel();
        ArrayList<Inscripcion> inscripciones;
        inscripciones=(ArrayList<Inscripcion>)data.inscripcionesDeAlumno(alumno);
        
        Object[] object = new Object[3];
        for (int i = 0; i < inscripciones.size(); i++) {
            object[0] = inscripciones.get(i).getIdInscripcion();
            object[1] = inscripciones.get(i).getMateria().getNombre();
            object[2] = inscripciones.get(i).getNota();
            modelo.addRow(object);
        }
        vista.jtNotas.setModel(modelo);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        /*
          if (e.getSource() == vista.btnInscribir) {
            int r = inscribirAlumno();
            if (r == 1) {
                llenarTabla(vista.tablaMateriasInscripciones, (ArrayList) data.materiasNoInscriptasAlumno(a));
                JOptionPane.showMessageDialog(vista, "Alumno Inscripto");
            }
        }
        
        if(e.getSource() == vista.btnDesinscribir){
            int r = desinscribirAlumno();
            if(r==1){
                llenarTabla(vista.tablaMateriasInscripciones, (ArrayList) data.materiasDeAlumno(a));
                JOptionPane.showMessageDialog(vista, "Alumno Desinscripto");
            }
        }

        if (e.getSource() == vista.btnCancelar) {
            vista.rButtonInvisible.setSelected(true);
            modelo.setRowCount(0);//Borras todas las filas
        }
    */
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
                llenarTabla(vista.jtNotas,a);
        }
    }
    
}
