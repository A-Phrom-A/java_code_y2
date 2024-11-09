import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class W9_7 extends JFrame {

    private JTextField idField, firstNameField, lastNameField, ageField, moneyField, rateField;
    private JComboBox<String> dayOpenBox, monthOpenBox, yearOpenBox;
    private JComboBox<String> dayBirthBox, monthBirthBox, yearBirthBox;
    private JButton saveButton, showButton;
    private JTable table;
    private DefaultTableModel tableModel;
    private Connection connection;

    public W9_7() {
        setTitle("Account Money");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeDatabase();

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ID Field
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        idField = new JTextField(10);
        panel.add(idField, gbc);

        // Money Field
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Money:"), gbc);
        gbc.gridx = 1;
        moneyField = new JTextField(10);
        panel.add(moneyField, gbc);

        // Annual Interest Rate
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Annual Interest Rate:"), gbc);
        gbc.gridx = 1;
        rateField = new JTextField(10);
        panel.add(rateField, gbc);

        // Day Open Account
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Day Open Account:"), gbc);
        gbc.gridx = 1;
        dayOpenBox = new JComboBox<>(getDays());
        monthOpenBox = new JComboBox<>(getMonths());
        yearOpenBox = new JComboBox<>(getYears(2024, 1900));
        JPanel openDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        openDatePanel.add(dayOpenBox);
        openDatePanel.add(monthOpenBox);
        openDatePanel.add(yearOpenBox);
        panel.add(openDatePanel, gbc);

        // First Name Field
        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(new JLabel("First Name:"), gbc);
        gbc.gridx = 1;
        firstNameField = new JTextField(10);
        panel.add(firstNameField, gbc);

        // Last Name Field
        gbc.gridx = 0; gbc.gridy = 5;
        panel.add(new JLabel("Last Name:"), gbc);
        gbc.gridx = 1;
        lastNameField = new JTextField(10);
        panel.add(lastNameField, gbc);

        // Birth Date
        gbc.gridx = 0; gbc.gridy = 6;
        panel.add(new JLabel("Birth Date:"), gbc);
        gbc.gridx = 1;
        dayBirthBox = new JComboBox<>(getDays());
        monthBirthBox = new JComboBox<>(getMonths());
        yearBirthBox = new JComboBox<>(getYears(2024, 1900));
        JPanel birthDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        birthDatePanel.add(dayBirthBox);
        birthDatePanel.add(monthBirthBox);
        birthDatePanel.add(yearBirthBox);
        panel.add(birthDatePanel, gbc);

        // Age Field
        gbc.gridx = 0; gbc.gridy = 7;
        panel.add(new JLabel("Age:"), gbc);
        gbc.gridx = 1;
        ageField = new JTextField(10);
        panel.add(ageField, gbc);

        // Save Button
        gbc.gridx = 0; gbc.gridy = 8;
        saveButton = new JButton("SAVE");
        panel.add(saveButton, gbc);

        // Show Button
        gbc.gridx = 1;
        showButton = new JButton("SHOW");
        panel.add(showButton, gbc);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDataToDatabase();
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTableData();
            }
        });

        tableModel = new DefaultTableModel(new String[]{"ID", "First Name", "Last Name", "Age", "Money", "Rate", "Open Date", "Birth Date"}, 0);
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);

        add(panel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void initializeDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:account.db");
            createTable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createTable() {
        if (connection == null) return;
        String sql = "CREATE TABLE IF NOT EXISTS account (" +
                "id TEXT PRIMARY KEY, " +
                "firstName TEXT, " +
                "lastName TEXT, " +
                "age INTEGER, " +
                "money REAL, " +
                "rate REAL, " +
                "openDate TEXT, " +
                "birthDate TEXT)";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveDataToDatabase() {
        if (connection == null) {
            JOptionPane.showMessageDialog(this, "No database connection.");
            return;
        }

        String id = idField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        int age = Integer.parseInt(ageField.getText());
        double money = Double.parseDouble(moneyField.getText());
        double rate = Double.parseDouble(rateField.getText());
        String openDate = yearOpenBox.getSelectedItem() + "-" + monthOpenBox.getSelectedItem() + "-" + dayOpenBox.getSelectedItem();
        String birthDate = yearBirthBox.getSelectedItem() + "-" + monthBirthBox.getSelectedItem() + "-" + dayBirthBox.getSelectedItem();

        String sql = "INSERT INTO account (id, firstName, lastName, age, money, rate, openDate, birthDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setInt(4, age);
            pstmt.setDouble(5, money);
            pstmt.setDouble(6, rate);
            pstmt.setString(7, openDate);
            pstmt.setString(8, birthDate);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadTableData() {
        if (connection == null) {
            JOptionPane.showMessageDialog(this, "No database connection.");
            return;
        }

        String sql = "SELECT * FROM account";
        tableModel.setRowCount(0);

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String id = rs.getString("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int age = rs.getInt("age");
                double money = rs.getDouble("money");
                double rate = rs.getDouble("rate");
                String openDate = rs.getString("openDate");
                String birthDate = rs.getString("birthDate");
                tableModel.addRow(new Object[]{id, firstName, lastName, age, money, rate, openDate, birthDate});
            }
            JOptionPane.showMessageDialog(this, "Table data loaded!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String[] getDays() {
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = String.valueOf(i);
        }
        return days;
    }

    private String[] getMonths() {
        return new String[]{"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
    }

    private String[] getYears(int startYear, int endYear) {
        int size = startYear - endYear + 1;
        String[] years = new String[size];
        for (int i = 0; i < size; i++) {
            years[i] = String.valueOf(startYear - i);
        }
        return years;
    }

    public static void main(String[] args) {
        new W9_7();
    }
}
