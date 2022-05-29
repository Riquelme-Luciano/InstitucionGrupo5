package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Alumno;
import model.AlumnoData;
import model.Inscripcion;
import view.NotasView;

public class NotasController implements ActionListener,KeyListener{
    Conexion con= new Conexion();
    AlumnoData alumnoData = new AlumnoData(con);
    
    NotasView notasView = new NotasView();
    DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<Alumno> listaAlumno = new ArrayList();
    ArrayList<Inscripcion> listaInscripto = new ArrayList();
    
    public NotasController(NotasView v) {
       notasView=v;
       
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
