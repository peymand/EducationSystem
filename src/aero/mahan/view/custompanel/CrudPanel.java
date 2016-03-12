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
        this.add(saveBtn);

        deleteBtn = new JButton();
        ImageIcon deleteImg = new ImageIcon("resources\\icons\\folder-minus.png");
        deleteBtn.setIcon(deleteImg);
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
            if (iGeneralNotifier != null) {
                iGeneralNotifier.addEventOccured(insertedObject);
            }
        }

        if (e.getSource() == this.editBtn) {
            Object insertedObject = source.getInsertedData();
            if (iGeneralNotifier != null) {
                iGeneralNotifier.editEventOccured(insertedObject);
            }
        }
    }
    public static void main(String[] args) {

    }
}
