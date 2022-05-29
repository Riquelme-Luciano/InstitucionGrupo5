
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Alumno;
import model.Inscripcion;
import model.InscripcionData;
import model.Materia;
import model.MateriaData;
import view.ConsultaView;

public class ConsultaController implements ActionListener, ItemListener{
    ConsultaView vista = new ConsultaView();
    Conexion con = new Conexion();
    MateriaData md = new MateriaData(con);
    InscripcionData data = new InscripcionData(con);
    Materia m = new Materia();
    Inscripcion ins = new Inscripcion();
    DefaultTableModel modelo= new DefaultTableModel();

    public ConsultaController(ConsultaView v) {
        vista=v;
        this.vista.jcbMaterias.addItemListener(this);
        llenarComboBox();
    }
    
    public void llenarComboBox() {
        Vector<Materia> materiasActivas= new Vector<Materia>(data.listarMateriasActivas());
        DefaultComboBoxModel alumnos = new DefaultComboBoxModel(materiasActivas);
        vista.jcbMaterias.setModel(alumnos);
        
    }
    
    public void llenarTabla(JTable tabla,ArrayList inscripcion) {
        modelo.setRowCount(0);
        modelo= (DefaultTableModel)tabla.getModel();
        ArrayList<Inscripcion> inscripciones;
        inscripciones=(ArrayList<Inscripcion>)inscripcion;
        
        Object[] object = new Object[3];
        for (int i = 0; i < inscripciones.size(); i++) {
            object[0] = inscripciones.get(i).getMateria().getIdMateria();
            object[1] = inscripciones.get(i).getAlumno().getNombre();
            object[2] = inscripciones.get(i).getNota();
            modelo.addRow(object);
        }
        vista.jtAlumnos.setModel(modelo);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
       if(ie.getStateChange()== ItemEvent.SELECTED) {
           
       }
    }
    
}
