package aero.mahan.view.custompanel;

import aero.mahan.view.interfaces.IGeneralNotifier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 926365 on 2/29/2016.
 */
public class CrudPanel extends JPanel implements ActionListener {

    ///// Properties
    private JButton addBtn, saveBtn, deleteBtn, editBtn;

    private CustomJPanel source;


    public void setiGeneralNotifier(IGeneralNotifier iGeneralNotifier) {
        this.iGeneralNotifier = iGeneralNotifier;
    }

    IGeneralNotifier iGeneralNotifier;


    ////// Constructor
    public CrudPanel(CustomJPanel source){

        this.source = source;


        setLayout(new FlowLayout());
        addBtn = new JButton();
        ImageIcon addImg = new ImageIcon("resources\\icons\\folder-plus.png");
        addBtn.setIcon(addImg);
        addBtn.addActionListener(this);
        this.add(addBtn);

        saveBtn = new JButton();
        ImageIcon saveImg = new ImageIcon("resources\\icons\\floppy-disk.png");
        saveBtn.setIcon(saveImg);
        saveBtn.addActionListener(this);
        this.add(saveBtn);


        deleteBtn = new JButton();
        ImageIcon deleteImg = new ImageIcon("resources\\icons\\folder-minus.png");
        deleteBtn.setIcon(deleteImg);
        deleteBtn.addActionListener(this);
        this.add(deleteBtn);

        editBtn = new JButton();
        ImageIcon editImg = new ImageIcon("resources\\icons\\pencil.png");
        editBtn.setIcon(editImg);
        editBtn.addActionListener(this);
        this.add(editBtn);

    }






    ////// Methods





    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.addBtn) {
            Object insertedObject = source.getInsertedData();
            if (iGeneralNotifier != null && insertedObject!=null) {
                iGeneralNotifier.addEventOccured(insertedObject);
            }
        }

        if (e.getSource() == this.editBtn) {
            Object editedObject = source.getEditedData();
            if (iGeneralNotifier != null && editedObject!=null ) {
                iGeneralNotifier.editEventOccured(editedObject);
            }
        }

        if (e.getSource()== this.deleteBtn){
            Object selectedObject=source.getSelectedData();
            if (iGeneralNotifier!=null && selectedObject!=null){
                iGeneralNotifier.deleteEventOccured(selectedObject);
            }

        }

        if (e.getSource()==this.saveBtn){
            iGeneralNotifier.saveEventOccured();
        }
    }
    public static void main(String[] args) {

    }
}
