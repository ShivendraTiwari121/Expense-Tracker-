import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RailwayBooking {
    public static void main(String[] args) {
        // Store the url, username and password in string object of database
        String url = "jdbc:mysql://localhost:3306/RailwayBookingSystem";
        String username = "root";
        String password = "";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("DB Connected");

            JFrame frame = new JFrame("Railway Booking System");

            JLabel personal_label = new JLabel("Personal Details");
            personal_label.setBounds(10, 10, 120, 30);
            frame.add(personal_label);

            JLabel ticket_details_label = new JLabel("Ticket Details");
            ticket_details_label.setBounds(310, 10, 120, 30);
            frame.add(ticket_details_label);

            JLabel username_label = new JLabel("Add Username");
            username_label.setBounds(10, 50, 120, 30);
            frame.add(username_label);

            JTextField username_field = new JTextField();
            username_field.setBounds(130, 50, 150, 30);
            frame.add(username_field);

            JLabel date_of_journey_label = new JLabel("Date Of Journey");
            date_of_journey_label.setBounds(310, 50, 120, 30);
            frame.add(date_of_journey_label);

            JTextField date_of_journey_field = new JTextField();
            date_of_journey_field.setBounds(430, 50, 150, 30);
            frame.add(date_of_journey_field);

            JLabel age_label = new JLabel("Add Age");
            age_label.setBounds(10, 90, 120, 30);
            frame.add(age_label);

            JTextField age_field = new JTextField();
            age_field.setBounds(130, 90, 150, 30);
            frame.add(age_field);

            JLabel source_label = new JLabel("Source");
            source_label.setBounds(310, 90, 120, 30);
            frame.add(source_label);

            JTextField source_field = new JTextField();
            source_field.setBounds(430, 90, 150, 30);
            frame.add(source_field);

            JLabel gender_label = new JLabel("Add Gender");
            gender_label.setBounds(10, 130, 120, 30);
            frame.add(gender_label);

            JTextField gender_field = new JTextField();
            gender_field.setBounds(130, 130, 150, 30);
            frame.add(gender_field);

            JLabel destination_label = new JLabel("Enter Destination");
            destination_label.setBounds(310, 130, 120, 30);
            frame.add(destination_label);

            JTextField destination_field = new JTextField();
            destination_field.setBounds(430, 130, 150, 30);
            frame.add(destination_field);

            JLabel email_label = new JLabel("Add Email:");
            email_label.setBounds(10, 170, 120, 30);
            frame.add(email_label);

            JTextField email_field = new JTextField();
            email_field.setBounds(130, 170, 150, 30);
            frame.add(email_field);

            JLabel ticket_price_label = new JLabel("Enter Ticket Price:");
            ticket_price_label.setBounds(310, 170, 120, 30);
            frame.add(ticket_price_label);

            JTextField ticket_price_field = new JTextField();
            ticket_price_field.setBounds(430, 170, 150, 30);
            frame.add(ticket_price_field);

            JLabel mobile_label = new JLabel("Add Mobile:");
            mobile_label.setBounds(10, 210, 120, 30);
            frame.add(mobile_label);

            JTextField mobile_field = new JTextField();
            mobile_field.setBounds(130, 210, 150, 30);
            frame.add(mobile_field);

            JLabel seat_label = new JLabel("Enter Seat Preference:");
            seat_label.setBounds(310, 210, 150, 30);
            frame.add(seat_label);

            JTextField seat_field = new JTextField();
            seat_field.setBounds(460, 210, 120, 30);
            frame.add(seat_field);

            JLabel bookingLabel = new JLabel("BookingID:");
            bookingLabel.setBounds(10, 250, 120, 30);
            frame.add(bookingLabel);

            JTextField bookingField = new JTextField();
            bookingField.setBounds(130, 250, 150, 30);
            frame.add(bookingField);

            JButton addButton = new JButton("Add");
            addButton.setBounds(80, 310, 80, 30);
            addButton.setBackground(Color.GREEN);
            addButton.setForeground(Color.WHITE);
            frame.add(addButton);

            JButton deleteButton = new JButton("Delete");
            deleteButton.setBounds(180, 310, 80, 30);
            deleteButton.setBackground(Color.RED);
            deleteButton.setForeground(Color.WHITE);
            frame.add(deleteButton);

            JButton updateButton = new JButton("Update");
            updateButton.setBounds(280, 310, 80, 30);
            updateButton.setBackground(Color.BLUE);
            updateButton.setForeground(Color.WHITE);
            frame.add(updateButton);

            JButton fetchButton = new JButton("Fetch");
            fetchButton.setBounds(380, 310, 80, 30);
            fetchButton.setBackground(Color.ORANGE);
            fetchButton.setForeground(Color.WHITE);
            frame.add(fetchButton);

            frame.setSize(600, 400);
            frame.setLayout(null);
            frame.setVisible(true);
            // frame.getContentPane().setBackground(Color.GRAY);

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String insertQuery = "INSERT INTO ticketBookingTB (username, age, gender, mobile, email, DOJ, Source, Destination, TicketPrice, Seat_Preference) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try {
                        PreparedStatement statement = conn.prepareStatement(insertQuery);
                        statement.setString(1, username_field.getText());
                        statement.setInt(2, Integer.parseInt(age_field.getText()));
                        statement.setString(3, gender_field.getText());
                        statement.setString(4, mobile_field.getText());
                        statement.setString(5, email_field.getText());
                        statement.setString(6, date_of_journey_field.getText());
                        statement.setString(7, source_field.getText());
                        statement.setString(8, destination_field.getText());
                        statement.setString(9, ticket_price_field.getText());
                        statement.setString(10, seat_field.getText());
                        statement.executeUpdate();
                        JOptionPane.showMessageDialog(frame, "Record added successfully!");
                        clearFields(username_field, age_field, gender_field, mobile_field, email_field, date_of_journey_field, source_field, destination_field, ticket_price_field, seat_field, bookingField);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(frame, "Error adding record: " + ex.getMessage());
                    }
                }
            });

            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String deleteQuery = "DELETE FROM ticketBookingTB WHERE username=?";
                    try {
                        PreparedStatement statement = conn.prepareStatement(deleteQuery);
                        statement.setString(1, username_field.getText());
                        statement.executeUpdate();
                        JOptionPane.showMessageDialog(frame, "Record deleted successfully!");
                        clearFields(username_field, age_field, gender_field, mobile_field, email_field, date_of_journey_field, source_field, destination_field, ticket_price_field, seat_field, bookingField);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(frame, "Error deleting record: " + ex.getMessage());
                    }
                }
            });

         updateButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder updateQuery = new StringBuilder("UPDATE ticketBookingTB SET ");
        List<Object> parameters = new ArrayList<>();
        
        if (!age_field.getText().isEmpty()) {
            updateQuery.append("age=?, ");
            parameters.add(Integer.parseInt(age_field.getText()));
        }
        if (!gender_field.getText().isEmpty()) {
            updateQuery.append("gender=?, ");
            parameters.add(gender_field.getText());
        }
        if (!mobile_field.getText().isEmpty()) {
            updateQuery.append("mobile=?, ");
            parameters.add(mobile_field.getText());
        }
        if (!email_field.getText().isEmpty()) {
            updateQuery.append("email=?, ");
            parameters.add(email_field.getText());
        }
        if (!date_of_journey_field.getText().isEmpty()) {
            updateQuery.append("DOJ=?, ");
            parameters.add(date_of_journey_field.getText());
        }
        if (!source_field.getText().isEmpty()) {
            updateQuery.append("Source=?, ");
            parameters.add(source_field.getText());
        }
        if (!destination_field.getText().isEmpty()) {
            updateQuery.append("Destination=?, ");
            parameters.add(destination_field.getText());
        }
        if (!ticket_price_field.getText().isEmpty()) {
            updateQuery.append("TicketPrice=?, ");
            parameters.add(ticket_price_field.getText());
        }
        if (!seat_field.getText().isEmpty()) {
            updateQuery.append("Seat_Preference=?, ");
            parameters.add(seat_field.getText());
        }
        if (parameters.size() > 0) {
            updateQuery.setLength(updateQuery.length() - 2);
        } else {
            JOptionPane.showMessageDialog(frame, "No fields to update.");
            return;
        }


        updateQuery.append(" WHERE BookingID=?");
        parameters.add(Integer.parseInt(bookingField.getText()));

        try {
            PreparedStatement statement = conn.prepareStatement(updateQuery.toString());

            // Set the parameters for the PreparedStatement
            for (int i = 0; i < parameters.size(); i++) {
                statement.setObject(i + 1, parameters.get(i));
            }

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(frame, "Record updated successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "No record found with the given BookingID.");
            }
            clearFields(username_field, age_field, gender_field, mobile_field, email_field, date_of_journey_field, source_field, destination_field, ticket_price_field, seat_field, bookingField);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Error updating record: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input: " + ex.getMessage());
        }
    }
});

            fetchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String fetchQuery = "SELECT * FROM ticketBookingTB WHERE bookingID=?";
                    try {
                        PreparedStatement statement = conn.prepareStatement(fetchQuery);
                        statement.setInt(1, Integer.parseInt(bookingField.getText()));
                        ResultSet resultSet = statement.executeQuery();
                        if (resultSet.next()) {
                            String details = "Username: " + resultSet.getString("username") + "\n" +
                                             "Age: " + resultSet.getInt("age") + "\n" +
                                             "Gender: " + resultSet.getString("gender") + "\n" +
                                             "Mobile: " + resultSet.getString("mobile") + "\n" +
                                             "Email: " + resultSet.getString("email") + "\n" +
                                             "Date of Journey: " + resultSet.getString("DOJ") + "\n" +
                                             "Source: " + resultSet.getString("Source") + "\n" +
                                             "Destination: " + resultSet.getString("Destination") + "\n" +
                                             "Ticket Price: " + resultSet.getString("TicketPrice") + "\n" +
                                             "Seat Preference: " + resultSet.getString("Seat_Preference");
                            JOptionPane.showMessageDialog(frame, details);
                        } else {
                            JOptionPane.showMessageDialog(frame, "No record found with Booking ID: " + bookingField.getText());
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(frame, "Error fetching record: " + ex.getMessage());
                    }
                }
            });

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection error: " + ex.getMessage());
        }
    }

    private static void clearFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }
}