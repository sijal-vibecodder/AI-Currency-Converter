package CurrencyConverter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;

public class CurrencyConverter2 extends JFrame implements ActionListener {

    private JTextField amountField;

    private JComboBox<String> fromCurrencyBox;
    private JComboBox<String> toCurrencyBox;

    private JButton convertButton;
    private JButton resetButton;
    private JButton swapButton;
    private JButton darkModeButton;
    private JButton saveHistoryButton;

    private JLabel resultLabel;
    private JLabel aiLabel;

    private JTextArea historyArea;

    private boolean darkMode = false;

    private final HashMap<String, Double> currencyRates =
            new HashMap<>();

    public CurrencyConverter2() {

        // ===== GRADIENT BACKGROUND =====

        setContentPane(new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                Graphics2D g2d =
                        (Graphics2D) g;

                g2d.setRenderingHint(
                        RenderingHints.KEY_RENDERING,
                        RenderingHints.VALUE_RENDER_QUALITY
                );

                int width = getWidth();
                int height = getHeight();

                Color color1 =
                        new Color(10, 25, 47);

                Color color2 =
                        new Color(0, 180, 216);

                Color color3 =
                        new Color(58, 12, 163);

                GradientPaint gradient =
                        new GradientPaint(
                                0,
                                0,
                                color1,
                                width,
                                height,
                                color2
                        );

                g2d.setPaint(gradient);

                g2d.fillRect(
                        0,
                        0,
                        width,
                        height
                );

                GradientPaint overlay =
                        new GradientPaint(
                                width,
                                0,
                                color3,
                                0,
                                height,
                                new Color(0,0,0,0)
                        );

                g2d.setPaint(overlay);

                g2d.fillRect(
                        0,
                        0,
                        width,
                        height
                );
            }
        });

        initializeRates();

        setTitle(
                "AI Advanced Currency Converter"
        );

        setSize(850, 700);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        // ===== TITLE =====

        JLabel title =
                new JLabel(
                        "AI Advanced Currency Converter"
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        title.setForeground(Color.WHITE);

        title.setBounds(
                150,
                20,
                600,
                40
        );

        add(title);

        // ===== AMOUNT =====

        JLabel amountLabel =
                new JLabel(
                        "Enter Amount:"
                );

        amountLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        amountLabel.setForeground(
                Color.WHITE
        );

        amountLabel.setBounds(
                60,
                100,
                200,
                30
        );

        add(amountLabel);

        amountField =
                new JTextField();

        amountField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        18
                )
        );

        amountField.setBounds(
                260,
                100,
                300,
                40
        );

        add(amountField);

        // ===== FROM LABEL =====

        JLabel fromLabel =
                new JLabel(
                        "From Currency:"
                );

        fromLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        fromLabel.setForeground(
                Color.WHITE
        );

        fromLabel.setBounds(
                60,
                180,
                200,
                30
        );

        add(fromLabel);

        // ===== TO LABEL =====

        JLabel toLabel =
                new JLabel(
                        "To Currency:"
                );

        toLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        toLabel.setForeground(
                Color.WHITE
        );

        toLabel.setBounds(
                60,
                260,
                200,
                30
        );

        add(toLabel);

        // ===== CURRENCIES =====

        String[] currencies = {

                "USD",
                "EUR",
                "GBP",
                "INR",
                "JPY",
                "AUD",
                "CAD",
                "CHF",
                "CNY",
                "AED",
                "SAR",
                "SGD",
                "BTC",
                "ETH"
        };

        fromCurrencyBox =
                new JComboBox<>(currencies);

        fromCurrencyBox.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        18
                )
        );

        fromCurrencyBox.setBounds(
                260,
                180,
                300,
                40
        );

        add(fromCurrencyBox);

        toCurrencyBox =
                new JComboBox<>(currencies);

        toCurrencyBox.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        18
                )
        );

        toCurrencyBox.setBounds(
                260,
                260,
                300,
                40
        );

        toCurrencyBox.setSelectedItem(
                "INR"
        );

        add(toCurrencyBox);

        // ===== BUTTONS =====

        convertButton =
                createStyledButton(
                        "Convert",
                        new Color(0, 200, 83)
                );

        convertButton.setBounds(
                60,
                350,
                140,
                45
        );

        convertButton.addActionListener(this);

        add(convertButton);

        resetButton =
                createStyledButton(
                        "Reset",
                        new Color(255, 61, 113)
                );

        resetButton.setBounds(
                220,
                350,
                140,
                45
        );

        resetButton.addActionListener(this);

        add(resetButton);

        swapButton =
                createStyledButton(
                        "Swap",
                        new Color(41, 121, 255)
                );

        swapButton.setBounds(
                380,
                350,
                140,
                45
        );

        swapButton.addActionListener(this);

        add(swapButton);

        darkModeButton =
                createStyledButton(
                        "Dark Mode",
                        new Color(171, 71, 188)
                );

        darkModeButton.setBounds(
                540,
                350,
                140,
                45
        );

        darkModeButton.addActionListener(this);

        add(darkModeButton);

        saveHistoryButton =
                createStyledButton(
                        "Save History",
                        new Color(255, 145, 0)
                );

        saveHistoryButton.setBounds(
                690,
                350,
                140,
                45
        );

        saveHistoryButton.addActionListener(this);

        add(saveHistoryButton);

        // ===== RESULT =====

        resultLabel =
                new JLabel(
                        "Converted amount will appear here"
                );

        resultLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        resultLabel.setForeground(
                Color.WHITE
        );

        resultLabel.setBounds(
                60,
                430,
                700,
                40
        );

        add(resultLabel);

        // ===== AI LABEL =====

        aiLabel =
                new JLabel(
                        "AI Assistant Ready..."
                );

        aiLabel.setFont(
                new Font(
                        "Arial",
                        Font.ITALIC,
                        16
                )
        );

        aiLabel.setForeground(
                Color.CYAN
        );

        aiLabel.setBounds(
                60,
                470,
                750,
                30
        );

        add(aiLabel);

        // ===== HISTORY =====

        JLabel historyLabel =
                new JLabel(
                        "Conversion History"
                );

        historyLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        historyLabel.setForeground(
                Color.WHITE
        );

        historyLabel.setBounds(
                60,
                510,
                250,
                30
        );

        add(historyLabel);

        historyArea =
                new JTextArea();

        historyArea.setEditable(false);

        historyArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        14
                )
        );

        historyArea.setBackground(
                new Color(20,20,20)
        );

        historyArea.setForeground(
                Color.GREEN
        );

        historyArea.setBorder(
                new EmptyBorder(
                        10,
                        10,
                        10,
                        10
                )
        );

        JScrollPane scrollPane =
                new JScrollPane(historyArea);

        scrollPane.setBounds(
                60,
                550,
                720,
                80
        );

        add(scrollPane);

        setVisible(true);
    }

    // ===== CUSTOM BUTTON =====

    private JButton createStyledButton(
            String text,
            Color color
    ) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        button.setBackground(color);

        button.setForeground(
                Color.WHITE
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createLineBorder(
                        Color.WHITE,
                        2
                )
        );

        return button;
    }

    // ===== INITIALIZE RATES =====

    private void initializeRates() {

        currencyRates.put("USD", 1.00);
        currencyRates.put("EUR", 0.92);
        currencyRates.put("GBP", 0.79);
        currencyRates.put("INR", 83.50);
        currencyRates.put("JPY", 149.50);
        currencyRates.put("AUD", 1.52);
        currencyRates.put("CAD", 1.36);
        currencyRates.put("CHF", 0.88);
        currencyRates.put("CNY", 7.23);
        currencyRates.put("AED", 3.67);
        currencyRates.put("SAR", 3.75);
        currencyRates.put("SGD", 1.34);
        currencyRates.put("BTC", 0.000015);
        currencyRates.put("ETH", 0.00031);
    }

    // ===== CONVERT =====

    private void convertCurrency() {

        try {

            double amount =
                    Double.parseDouble(
                            amountField.getText()
                    );

            String fromCurrency =
                    (String)
                            fromCurrencyBox
                                    .getSelectedItem();

            String toCurrency =
                    (String)
                            toCurrencyBox
                                    .getSelectedItem();

            double fromRate =
                    currencyRates.get(fromCurrency);

            double toRate =
                    currencyRates.get(toCurrency);

            double usdAmount =
                    amount / fromRate;

            double convertedAmount =
                    usdAmount * toRate;

            DecimalFormat df =
                    new DecimalFormat("#,##0.00");

            String result =

                    amount + " " +

                    fromCurrency +

                    " = " +

                    df.format(convertedAmount) +

                    " " +

                    toCurrency;

            resultLabel.setText(result);

            historyArea.append(result + "\n");

            generateAISuggestion(
                    fromCurrency,
                    toCurrency
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numeric value!",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // ===== AI ASSISTANT =====

    private void generateAISuggestion(
            String fromCurrency,
            String toCurrency
    ) {

        String message = "";

        if (fromCurrency.equals("USD")
                && toCurrency.equals("INR")) {

            message =
                    "AI Insight: USD is currently strong against INR.";

        } else if (fromCurrency.equals("BTC")) {

            message =
                    "AI Insight: Crypto markets are highly volatile today.";

        } else if (toCurrency.equals("EUR")) {

            message =
                    "AI Insight: EUR is widely used in international trade.";

        } else if (toCurrency.equals("JPY")) {

            message =
                    "AI Insight: Japanese Yen is considered stable globally.";

        } else {

            message =
                    "AI Insight: Diversified currency conversion improves flexibility.";
        }

        aiLabel.setText(message);
    }

    // ===== RESET =====

    private void resetFields() {

        amountField.setText("");

        resultLabel.setText(
                "Converted amount will appear here"
        );

        aiLabel.setText(
                "AI Assistant Ready..."
        );
    }

    // ===== SWAP =====

    private void swapCurrencies() {

        Object temp =
                fromCurrencyBox.getSelectedItem();

        fromCurrencyBox.setSelectedItem(
                toCurrencyBox.getSelectedItem()
        );

        toCurrencyBox.setSelectedItem(temp);
    }

    // ===== DARK MODE =====

    private void toggleDarkMode() {

        if (!darkMode) {

            historyArea.setBackground(
                    Color.BLACK
            );

            historyArea.setForeground(
                    Color.CYAN
            );

            darkMode = true;

        } else {

            historyArea.setBackground(
                    new Color(20,20,20)
            );

            historyArea.setForeground(
                    Color.GREEN
            );

            darkMode = false;
        }
    }

    // ===== SAVE HISTORY =====

    private void saveHistoryToFile() {

        try {

            FileWriter writer =
                    new FileWriter(
                            "conversion_history.txt"
                    );

            writer.write(
                    historyArea.getText()
            );

            writer.close();

            JOptionPane.showMessageDialog(
                    this,
                    "History Saved Successfully!"
            );

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error Saving File!"
            );
        }
    }

    // ===== BUTTON ACTIONS =====

    @Override
    public void actionPerformed(
            ActionEvent e
    ) {

        if (e.getSource() == convertButton) {

            convertCurrency();

        } else if (e.getSource() == resetButton) {

            resetFields();

        } else if (e.getSource() == swapButton) {

            swapCurrencies();

        } else if (e.getSource() == darkModeButton) {

            toggleDarkMode();

        } else if (e.getSource() == saveHistoryButton) {

            saveHistoryToFile();
        }
    }

    // ===== MAIN =====

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new CurrencyConverter2();
        });
    }
}