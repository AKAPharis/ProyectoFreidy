package gui;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;

public class CheckboxEditor extends DefaultCellEditor {
    public CheckboxEditor() {
        super(new JCheckBox());
    }
}