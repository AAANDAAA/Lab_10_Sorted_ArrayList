import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortedListGUI extends JFrame {
    private SortedList sortedList = new SortedList();
    private JTextArea displayArea;
    private JTextField inputField;
    private JButton addButton, searchButton;

    public SortedListGUI() {
        setTitle("Sorted List Manager");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputField = new JTextField();
        addButton = new JButton("Add");
        searchButton = new JButton("Search");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);

        inputPanel.add(buttonPanel, BorderLayout.EAST);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(new AddListener());
        searchButton.addActionListener(new SearchListener());
    }

    private class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = inputField.getText().trim();
            if (!text.isEmpty()) {
                sortedList.add(text);
                displayArea.setText("Added: " + text + "\n\nCurrent List:\n" + sortedList.getListString());
                inputField.setText("");
            }
        }
    }

    private class SearchListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = inputField.getText().trim();
            if (!text.isEmpty()) {
                String result = sortedList.search(text);
                displayArea.setText(result + "\n\nCurrent List:\n" + sortedList.getListString());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SortedListGUI().setVisible(true);
        });
    }
}