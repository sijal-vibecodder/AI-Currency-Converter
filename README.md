# 💱 AI Advanced Currency Converter

A professional desktop-based **Currency Converter application built with Java Swing**. The application provides a clean graphical interface for converting amounts between multiple international and cryptocurrency currencies, while also offering conversion history, currency swapping, dark mode, file saving, and basic rule-based currency insights.

> **Note:** The application's exchange rates are predefined in the source code. They are not fetched from a live exchange-rate API.


App dashboard Image:
<img width="1042" height="858" alt="Screenshot 2026-10-04 220844" src="https://github.com/user-attachments/assets/bf2952ad-6478-4456-bbc7-f212bb5db9c5" />
<img width="1032" height="842" alt="Screenshot 2026-10-04 220910" src="https://github.com/user-attachments/assets/9bf0acdd-edef-436e-a565-58307729bcab" />
<img width="1030" height="835" alt="Screenshot 2026-10-04 220928" src="https://github.com/user-attachments/assets/c7e42e48-455c-4581-9759-e3633b88af5b" />
<img width="1031" height="828" alt="Screenshot 2026-10-04 220952" src="https://github.com/user-attachments/assets/cecec124-3b13-415d-a8f1-426967941fa6" />

## ✨ Features

- 💱 Convert between multiple currencies
- 🔄 Swap source and target currencies instantly
- 🔁 Reset input and conversion results
- 🤖 Display basic rule-based currency insights
- 📝 Maintain conversion history during the session
- 💾 Save conversion history to `conversion_history.txt`
- 🌙 Toggle dark mode for the history section
- 🎨 Gradient-based graphical user interface
- ⚠️ Validate numeric input and display error messages
- 🖥️ Desktop application built with Java Swing

---

## 🌍 Supported Currencies

The application currently supports:

| Currency | Code |
|---|---|
| US Dollar | USD |
| Euro | EUR |
| British Pound | GBP |
| Indian Rupee | INR |
| Japanese Yen | JPY |
| Australian Dollar | AUD |
| Canadian Dollar | CAD |
| Swiss Franc | CHF |
| Chinese Yuan | CNY |
| UAE Dirham | AED |
| Saudi Riyal | SAR |
| Singapore Dollar | SGD |
| Bitcoin | BTC |
| Ethereum | ETH |

---

## 🛠️ Technologies Used

- **Java**
- **Java Swing**
- **AWT**
- **HashMap**
- **ActionListener / Event Handling**
- **File Handling**
- **Exception Handling**
- **Object-Oriented Programming (OOP)**

---

## 🔄 Application Workflow

```text
Enter Amount
      ↓
Select From Currency
      ↓
Select To Currency
      ↓
Click Convert
      ↓
Calculate Conversion
      ↓
Display Result
      ↓
Add Result to History
      ↓
Generate Basic Currency Insight
```

---

## 🧮 How Conversion Works

The application stores predefined currency rates relative to USD using a `HashMap`.

The conversion follows this general process:

```text
Amount in Source Currency
          ↓
Convert to USD
          ↓
Convert USD to Target Currency
          ↓
Display Final Amount
```

The application uses the following calculation approach:

```text
USD Amount = Input Amount ÷ Source Currency Rate

Converted Amount = USD Amount × Target Currency Rate
```

---

## 🤖 AI Assistant

The application contains an **AI Assistant** section that displays basic rule-based currency insights.

For example, depending on the selected currencies, it can display messages related to:

- USD and INR
- Cryptocurrency volatility
- EUR and international trade
- Japanese Yen
- General currency diversification

This is a **rule-based insight system**, not a machine-learning model or external AI API.

---

## 📁 Project Structure

```text
CurrencyConverter/
│
├── CurrencyConverter2.java
└── conversion_history.txt    # Created when history is saved
```

### Package

```java
package CurrencyConverter;
```

### Main Class

```java
CurrencyConverter2
```

---

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone <YOUR-REPOSITORY-URL>
```

### 2. Open the project

Open the project in an IDE such as:

- IntelliJ IDEA
- Eclipse
- NetBeans

### 3. Ensure Java is installed

Check your Java installation:

```bash
java -version
javac -version
```

### 4. Run the application

Run:

```text
CurrencyConverter2.java
```

The application window will open automatically.

---

## 🖥️ How to Use

1. Enter the amount you want to convert.
2. Select the **From Currency**.
3. Select the **To Currency**.
4. Click **Convert**.
5. View the converted amount.
6. Use **Swap** to exchange the selected currencies.
7. Use **Reset** to clear the current conversion.
8. Use **Dark Mode** to change the history display.
9. Use **Save History** to save your conversion records.

---

## 📸 Screenshots

Add your application screenshots here:

```text
screenshots/
├── main-interface.png
├── conversion-result.png
└── conversion-history.png
```

Example:

```markdown
![Main Interface](screenshots/main-interface.png)
```

---

## 🚀 Future Enhancements

The following features could be added in future versions:

- 🌐 Live exchange rates using a currency API
- 📊 Historical exchange-rate charts
- ☁️ Cloud-based conversion history
- 🔐 User authentication
- 📱 Mobile-friendly version
- 📈 Currency trend analysis
- 🤖 Integration with a real AI/ML service
- 🗃️ Database support for storing conversion history
- 🌎 Automatic currency-rate updates

---

## 🎯 Learning Outcomes

This project demonstrates practical use of:

- Java GUI development
- Object-oriented programming
- Event-driven programming
- Collections using `HashMap`
- File handling
- Exception handling
- User input validation
- Basic application-state management
- Desktop application design

---

## 📌 Project Highlights

**Application Type:** Desktop GUI Application  
**Language:** Java  
**GUI Framework:** Java Swing  
**Currency Support:** 14 currencies/assets  
**Data Storage:** In-memory `HashMap` + text file history  
**Exchange Rates:** Predefined values  
**AI Component:** Rule-based currency insights

---

## 👨‍💻 Author

Sijal Kumar Sahu

- GitHub: https://github.com/sijal-vibecodder 
- LinkedIn:  www.linkedin.com/in/sijal-kumar-sahu-0387b4411

---

## 📄 License

This project is available for educational and portfolio purposes.

when publishing the repository: https://github.com/sijal-vibecodder/AI-Currency-Converter
