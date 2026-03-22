<div align="center">

# 🛒 SOLID E-Commerce — Java Order Processing System

**A clean, modular e-commerce order processing engine built to demonstrate mastery of SOLID design principles in Java.**

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Architecture](https://img.shields.io/badge/Architecture-SOLID-blue?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)
![No Dependencies](https://img.shields.io/badge/Dependencies-None-lightgrey?style=for-the-badge)

</div>

---

## 📌 About

This project is a **pure Java** implementation of an e-commerce order processing pipeline, designed from the ground up around the five SOLID principles. Every class, interface, and interaction demonstrates how clean architecture leads to code that is easy to extend, test, and maintain — without relying on any external libraries or frameworks.

---

## 🏗️ Architecture

```
solid-ecommerce-java/
│
├── src/
│   ├── model/
│   │   ├── Product.java              # Product entity (SRP)
│   │   └── Order.java                # Order entity with product aggregation
│   │
│   ├── service/
│   │   ├── pricing/
│   │   │   ├── PricingStrategy.java   # Strategy interface (OCP)
│   │   │   ├── RegularPricing.java    # Full-price implementation
│   │   │   └── DiscountPricing.java   # Discounted pricing logic
│   │   │
│   │   ├── payment/
│   │   │   ├── PaymentMethod.java     # Payment abstraction (ISP)
│   │   │   ├── CreditCardPayment.java # Credit card processor
│   │   │   └── PayPalPayment.java     # PayPal processor
│   │   │
│   │   └── notification/
│   │       ├── NotificationService.java  # Notification abstraction (ISP)
│   │       ├── EmailNotification.java    # Email sender
│   │       └── SMSNotification.java      # SMS sender
│   │
│   └── controller/
│       └── OrderProcessor.java        # Orchestrator — depends only on abstractions (DIP)
│
└── Main.java                          # Entry point & demo
```

---

## 🧠 SOLID Principles in Action

| Principle | Where It's Applied | How |
|---|---|---|
| **Single Responsibility** | `Product`, `Order`, each service class | Every class owns exactly one job — data, pricing, payment, or notification |
| **Open / Closed** | `PricingStrategy`, `PaymentMethod` | New strategies and payment methods plug in without touching existing code |
| **Liskov Substitution** | All interface implementations | `DiscountPricing` swaps seamlessly for `RegularPricing`; `PayPalPayment` for `CreditCardPayment` |
| **Interface Segregation** | `PaymentMethod`, `NotificationService` | Small, focused contracts — no class is forced to implement methods it doesn't need |
| **Dependency Inversion** | `OrderProcessor` | The orchestrator depends on abstractions (`PricingStrategy`, `PaymentMethod`, `NotificationService`), never on concrete classes |

---

## ⚙️ How It Works

```
 ┌──────────┐     ┌──────────────┐     ┌───────────────┐     ┌──────────────┐
 │ Products │ ──▶ │ Apply Pricing│ ──▶ │Process Payment│ ──▶ │   Notify     │
 │  + Order │     │  (Strategy)  │     │   (Method)    │     │  (Service)   │
 └──────────┘     └──────────────┘     └───────────────┘     └──────────────┘
```

1. **Create** products with name and price
2. **Build** an order containing those products
3. **Apply** a pricing strategy (regular, discount, or your own)
4. **Process** payment through any supported method
5. **Send** a notification via email, SMS, or a custom channel

---

## ▶️ Quick Start

**Prerequisites:** Java 17+

```bash
# Clone
git clone https://github.com/Mazen-Naji/solid-ecommerce-java.git
cd solid-ecommerce-java

# Compile
javac -d bin src/**/*.java Main.java

# Run
java -cp bin Main
```

**Example usage:**

```java
// Compose the pipeline with any combination of strategies
OrderProcessor processor = new OrderProcessor(
    new DiscountPricing(),
    new PayPalPayment(),
    new EmailNotification()
);

// Create products & order
Product laptop = new Product("Laptop", 900.0);
Product mouse  = new Product("Mouse", 50.0);

Order order = new Order();
order.addProduct(laptop);
order.addProduct(mouse);

// Execute
processor.process(order);
```

**Output:**

```
Paid 945.0 using PayPal
Email: Order processed successfully!
```

---

## 🔌 Extensibility

Adding a new capability requires **zero changes** to existing code — just implement the relevant interface:

```java
// New payment method — drop in and go
public class CryptoPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Crypto Wallet");
    }
}

// Use it immediately
OrderProcessor processor = new OrderProcessor(
    new RegularPricing(),
    new CryptoPayment(),       // ← new, no existing code touched
    new SMSNotification()
);
```

---

## 🗺️ Roadmap

- [ ] Add Stripe / Crypto payment integrations
- [ ] Persist orders to MySQL database
- [ ] Convert to Spring Boot REST API
- [ ] Add JUnit 5 test suite
- [ ] Implement logging with SLF4J

---

## 🛠️ Tech Stack

| | |
|---|---|
| **Language** | Java 17+ |
| **Paradigm** | Object-Oriented Programming |
| **Patterns** | Strategy, Dependency Injection |
| **Dependencies** | None — pure Java |

---

## 🤝 Contributing

Contributions are welcome! Feel free to fork and submit a pull request.

1. Fork the repository
2. Create your feature branch — `git checkout -b feature/new-payment`
3. Commit your changes — `git commit -m "Add crypto payment method"`
4. Push to the branch — `git push origin feature/new-payment`
5. Open a Pull Request

---

## 📜 License

This project is open-source under the [MIT License](LICENSE).

---

<div align="center">

**Built by [Mazen Naji](https://github.com/Mazennaji)**

⭐ If you found this useful, a star goes a long way!

</div>
