package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Alumno;
import model.AlumnoData;
import view.AlumnoView;

public class AlumnoController implements ActionListener, KeyListener {

    Conexion con = new Conexion();

    AlumnoData dao = new AlumnoData(con);
    Alumno a = new Alumno();
    AlumnoView vista = new AlumnoView();
    DefaultTableModel modelo = new DefaultTableModel();

    ArrayList<Alumno> lista = new ArrayList();
    ;
    ArrayList<Alumno> listaFiltro = new ArrayList();

    ;

    public AlumnoController(AlumnoView v) {
        this.vista = v;
//        this.vista.btnListar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnSeleccionar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.txtBuscar.addKeyListener(this);
        listar(vista.tablaAlumnos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            insertar();
            listar(vista.tablaAlumnos);
        }
        if (e.getSource() == vista.btnSeleccionar) {
            seleccionar();
        }
        if (e.getSource() == vista.btnEditar) {
            actualizar();
            limpiarContenido();
            listar(vista.tablaAlumnos);
        }
        if (e.getSource() == vista.btnEliminar) {
            delete();
            listar(vista.tablaAlumnos);
            limpiarContenido();
        }
    }
    
    public void seleccionar(){
        int fila = vista.tablaAlumnos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
            } else {
                int id = Integer.parseInt(vista.tablaAlumnos.getValueAt(fila, 0).toString());
                String nombre = (String) vista.tablaAlumnos.getValueAt(fila, 1);
                String apellido = (String) vista.tablaAlumnos.getValueAt(fila, 2);
                Date nacimiento = (Date) vista.tablaAlumnos.getValueAt(fila, 3);
                boolean activo = (boolean) vista.tablaAlumnos.getValueAt(fila, 4);

                vista.txtID.setText("" + id);
                vista.txtNombre.setText(nombre);
                vista.txtApellido.setText(apellido);
                vista.checkActivo.setSelected(activo);
                //para ingresar la fecha al jcalendar
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd,MM,yyyy");
                Date fechaNac;
                try {
                    fechaNac = formatoFecha.parse(formatoFecha.format(nacimiento));
                    vista.calendarFecha.setDate(fechaNac);
                } catch (ParseException ex) {
                    System.out.println("Error al parsear el dato de la tabla fecha al textField");
                }
            }
    }
    
    public void delete() {
        int fila = vista.tablaAlumnos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un alumno");
        } else {
            int id = Integer.parseInt(vista.tablaAlumnos.getValueAt(fila, 0).toString());
            dao.eliminarAlumno(id);
            JOptionPane.showMessageDialog(vista, "Usuario eliminado");
        }
    }

    public void actualizar() {
        int id = Integer.parseInt(vista.txtID.getText());
        String nombre = vista.txtNombre.getText();
        String apellido = vista.txtApellido.getText();
        Date date = vista.calendarFecha.getDate();
        boolean activo = vista.checkActivo.isSelected();

        a.setIdAlumno(id);
        a.setNombre(nombre);
        a.setApellido(apellido);
        a.setFechaNac(date);
        a.setActive(activo);

        int r = dao.actualizarAlumno(a);

        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Usuario actualizado");
        } else {
            JOptionPane.showMessageDialog(vista, "Error al actualizar");
        }
    }

    public void insertar() {
        String nombre = vista.txtNombre.getText();
        String apellido = vista.txtApellido.getText();
        Date date = vista.calendarFecha.getDate();
        boolean activo = vista.checkActivo.isSelected();

        a.setNombre(nombre);
        a.setApellido(apellido);
        a.setFechaNac(date);
        a.setActive(activo);

        int r = dao.insertarAlumno(a);

        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Alumno agregado");
            limpiarContenido();
        } else {
            JOptionPane.showMessageDialog(vista, "Error");
        }

    }

    public void listar(JTable tabla) {
        modelo.setRowCount(0);//Borras todas las filas
        modelo = (DefaultTableModel) tabla.getModel();
        lista = (ArrayList<Alumno>) dao.listar();
        Object[] object = new Object[5];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getIdAlumno();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getApellido();
            object[3] = lista.get(i).getFechaNac();
            object[4] = lista.get(i).isActive();
            modelo.addRow(object);
        }
        vista.tablaAlumnos.setModel(modelo);
    }

    public void listar(JTable tabla, ArrayList<Alumno> l) {
        modelo.setRowCount(0);//Borras todas las filas
        modelo = (DefaultTableModel) tabla.getModel();
//        lista = dao.listar();
        Object[] object = new Object[5];

        for (int i = 0; i < l.size(); i++) {
            object[0] = l.get(i).getIdAlumno();
            object[1] = l.get(i).getNombre();
            object[2] = l.get(i).getApellido();
            object[3] = l.get(i).getFechaNac();
            object[4] = l.get(i).isActive();
            modelo.addRow(object);
        }
        vista.tablaAlumnos.setModel(modelo);
    }

    public void limpiarContenido() {
        vista.txtID.setText("");
        vista.txtNombre.setText("");
        vista.txtApellido.setText("");
        vista.calendarFecha.setDate(null);
    }

    public void filtrar() {
        String filtro = vista.txtBuscar.getText();
        System.out.println(filtro);

        if (filtro.isEmpty()) {
            listar(vista.tablaAlumnos);
            System.out.println(listaFiltro);

        } else {
            this.listaFiltro.clear();

            for (Alumno al : this.lista) {
                if (al.getNombre().toLowerCase().contains(filtro.toLowerCase())) {
                    this.listaFiltro.add(al);
                }
            }

            listar(vista.tablaAlumnos, listaFiltro);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        filtrar();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

//    public void limpiarTabla(JTable tabla) {
//        try {
//            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
//            int filas = tabla.getRowCount();
//            for (int i = 0; filas > i; i++) {
//                modelo.removeRow(0);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
//        }
//    }
}
