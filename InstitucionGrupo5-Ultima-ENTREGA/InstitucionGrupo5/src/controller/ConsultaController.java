
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
    
    public void llenarTabla(JTable tabla) {
        modelo.setRowCount(0);
        modelo= (DefaultTableModel)tabla.getModel();
        ArrayList<Alumno> alumnos;
        alumnos=(ArrayList<Alumno>)data.alumnosEnMateria(m);
        
        Object[] object = new Object[3];
        for (int i = 0; i < alumnos.size(); i++) {
            object[0] = alumnos.get(i).getIdAlumno();
            object[1] = alumnos.get(i).getNombre();
            object[2] = alumnos.get(i).getFechaNac();
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
           this.m = (Materia)vista.jcbMaterias.getSelectedItem();
           llenarTabla(vista.jtAlumnos);
       }
    }
    
}
