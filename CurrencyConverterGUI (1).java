import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CurrencyConverterGUI extends JFrame {
    private JTextField amountField;
    private JComboBox<String> fromCurrencyBox;
    private JComboBox<String> toCurrencyBox;
    private JLabel resultLabel;
    private CurrencyConverter converter;

    public CurrencyConverterGUI() {
        setTitle("Currency Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        ExchangeRateProvider provider = new ExchangeRateProvider();
        converter = new CurrencyConverter(provider);

        amountField = new JTextField(10);
        String[] currencies = {"USD", "EUR", "GBP", "INR", "JPY", "AUD"};
        fromCurrencyBox = new JComboBox<>(currencies);
        toCurrencyBox = new JComboBox<>(currencies);
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("Converted Amount: ");

        // Layout setup
        setLayout(new GridLayout(5, 2));
        add(new JLabel("   Amount:"));
        add(amountField);
        add(new JLabel("   From:"));
        add(fromCurrencyBox);
        add(new JLabel("   To:"));
        add(toCurrencyBox);
        add(convertButton);
        add(resultLabel);

        // Add action listener for the convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String fromCurrency = fromCurrencyBox.getSelectedItem().toString();
            String toCurrency = toCurrencyBox.getSelectedItem().toString();

            double result = converter.convert(fromCurrency, toCurrency, amount);
            resultLabel.setText(String.format("Converted Amount: %.2f %s", result, toCurrency));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CurrencyConverterGUI converterGUI = new CurrencyConverterGUI();
            converterGUI.setVisible(true);
        });
    }
}
