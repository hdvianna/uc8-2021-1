package gui.jtable;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class CharactersTableModel implements TableModel {

    private String[] columnNames = {"", "Character", "Actor", "In"};
    private List<Character> characters;
    private List<Boolean> checkBoxes;
    private List<TableModelListener> listeners;

    public CharactersTableModel() {
        initializeData();
        listeners = new ArrayList<>();
    }

    private void initializeData() {
        characters = new ArrayList<>();
        characters.add(new Character("David Mitzie", "Michael Palin", "It's the Arts"));
        characters.add(new Character("Mr Pither", "Michael Palin", "The Cycling Tour"));
        characters.add(new Character("Mr Bruce Foster of Guildford", "Graham Chapman", "It's Wolfgang Amadeus Mozart"));
        characters.add(new Character("Ken Shabby", "Michael Palin", "The Naked Ant"));
        characters.add(new Character("Arthur 'Two Sheds' Jackson", "Terry Jones", "It's the Arts"));
        characters.add(new Character("Vicky", "Eric Idle", "It's the Arts"));
        characters.add(new Character("D.P. Gumby", "Michael Palin", "Gumby Flower Arranging"));
        characters.add(new Character("Giuseppe", "Michael Palin", "Italian lesson"));
        characters.add(new Character("Conrad Poohs", "Terry Gilliam", "How Not to Be Seen"));
        characters.add(new Character("Raymond Luxury-Yacht", "Graham Chapman", "Raymond Luxury-Yacht Interview"));
        characters.add(new Character("Mariolini", "John Cleese", "Italian lesson"));
        characters.add(new Character("Baxter", "Michael Palin", "Picasso/Cycling Race"));
        characters.add(new Character("Cardinal Ximinez", "Michael Palin", "The Spanish Inquisition"));
        characters.add(new Character("Mr Creosote", "Terry Jones", "Monty Python's The Meaning of Life"));
        characters.add(new Character("Tim the Enchanter", "John Cleese", "Monty Python and the Holy Grail"));
        characters.add(new Character("Tom", "John Cleese", "It's the Arts"));

        checkBoxes = new ArrayList<>();
        checkBoxes.add(false);
        checkBoxes.add(false);
        checkBoxes.add(false);
        checkBoxes.add(false);
        checkBoxes.add(false);
        checkBoxes.add(false);
        checkBoxes.add(false);
        checkBoxes.add(false);
        checkBoxes.add(false);
        checkBoxes.add(false);
        checkBoxes.add(false);
        checkBoxes.add(false);
        checkBoxes.add(false);
        checkBoxes.add(false);
        checkBoxes.add(false);
        checkBoxes.add(false);
    }

    @Override
    public int getRowCount() {
        return characters.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Boolean.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Character character = characters.get(rowIndex);
        Object[] values = {checkBoxes.get(rowIndex), character.getName(), character.getActor(), character.getIn()};
        return values[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            checkBoxes.set(rowIndex, (boolean) aValue);
        }
    }

    @Override
    public void addTableModelListener(TableModelListener tableModelListener) {
        listeners.add(tableModelListener);
    }

    @Override
    public void removeTableModelListener(TableModelListener tableModelListener) {
        listeners.remove(tableModelListener);
    }
}
