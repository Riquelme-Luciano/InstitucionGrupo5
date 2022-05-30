package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Materia;
import model.MateriaData;
import view.MateriaView;

public class MateriaController implements ActionListener, KeyListener {

    Conexion con = new Conexion();
    MateriaData data = new MateriaData(con);
    Materia m = new Materia();
    MateriaView vista = new MateriaView();
    DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<Materia> lista = new ArrayList();
    ArrayList<Materia> listaFiltro = new ArrayList();

    public MateriaController(MateriaView v) {
        this.vista = v;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnSeleccionar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.txtBuscar.addKeyListener(this);
        listar(vista.tablaMaterias);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnSeleccionar) {
            seleccionar();
        }
        if (e.getSource() == vista.btnGuardar) {
            insertar();
            listar(vista.tablaMaterias);
        }
        if (e.getSource() == vista.btnEditar) {
            actualizar();
            limpiarContenido();
            listar(vista.tablaMaterias);
        }
        if (e.getSource() == vista.btnEliminar) {
            delete();
            listar(vista.tablaMaterias);
            limpiarContenido();
        }
    }

    public void seleccionar() {
        int fila = vista.tablaMaterias.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            int id = Integer.parseInt(vista.tablaMaterias.getValueAt(fila, 0).toString());
            String nombre = (String) vista.tablaMaterias.getValueAt(fila, 1);
            int anio = Integer.parseInt(vista.tablaMaterias.getValueAt(fila, 2).toString());
            boolean activo = (boolean) vista.tablaMaterias.getValueAt(fila, 3);

            vista.txtID.setText("" + id);
            vista.txtNombre.setText(nombre);
            vista.txtAnio.setText(String.valueOf(anio));
            vista.checkActivo.setSelected(activo);
        }
    }

    public void insertar() {
        String nombre = vista.txtNombre.getText();
        int anio = Integer.parseInt(vista.txtAnio.getText());
        boolean activo = vista.checkActivo.isSelected();

        m.setNombre(nombre);
        m.setYearMateria(anio);
        m.setActive(activo);

        int r = data.insertarMateria(m);

        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Materia agregada");
            limpiarContenido();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al ingresar nueva materia");
        }

    }

    public void listar(JTable tabla) {
        modelo.setRowCount(0);//Borras todas las filas
        modelo = (DefaultTableModel) tabla.getModel();
        lista = (ArrayList<Materia>) data.listar();
        Object[] object = new Object[4];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getIdMateria();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getYearMateria();
            object[3] = lista.get(i).isActive();
            modelo.addRow(object);
        }
        vista.tablaMaterias.setModel(modelo);
    }

    public void delete() {
        int fila = vista.tablaMaterias.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una materia");
        } else {
            int id = Integer.parseInt(vista.tablaMaterias.getValueAt(fila, 0).toString());
            data.eliminarMateria(id);
            JOptionPane.showMessageDialog(vista, "Materia eliminada");
        }
    }

    public void actualizar() {
        int id = Integer.parseInt(vista.txtID.getText());
        String nombre = vista.txtNombre.getText();
        int anio = Integer.parseInt(vista.txtAnio.getText());
        boolean activo = vista.checkActivo.isSelected();

        m.setIdMateria(id);
        m.setNombre(nombre);
        m.setYearMateria(anio);
        m.setActive(activo);

        int r = data.actualizarMateria(m);

        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Materia actualizada");
        } else {
            JOptionPane.showMessageDialog(vista, "Error al actualizar materia");
        }
    }

    //---
    public void limpiarContenido() {
        vista.txtID.setText("");
        vista.txtNombre.setText("");
        vista.txtAnio.setText("");
        vista.checkActivo.setSelected(false);
    }

    //--filtro, metodo sobrecargado
    public void listar(JTable tabla, ArrayList<Materia> l) {
        modelo.setRowCount(0);//Borras todas las filas
        modelo = (DefaultTableModel) tabla.getModel();
//        lista = dao.listar();
        Object[] object = new Object[5];

        for (int i = 0; i < l.size(); i++) {
            object[0] = l.get(i).getIdMateria();
            object[1] = l.get(i).getNombre();
            object[2] = l.get(i).getYearMateria();
            object[3] = l.get(i).isActive();
            modelo.addRow(object);
        }
        vista.tablaMaterias.setModel(modelo);
    }

    public void filtrar() {
        String filtro = vista.txtBuscar.getText();

        if (filtro.isEmpty()) {
            listar(vista.tablaMaterias);
        } else {
            this.listaFiltro.clear();
            for (Materia materia : this.lista) {
                if (materia.getNombre().toLowerCase().contains(filtro.toLowerCase())) {
                    this.listaFiltro.add(materia);
                }
            }

            listar(vista.tablaMaterias, listaFiltro);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       filtrar();
    }

    //---
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }
}
