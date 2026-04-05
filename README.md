# 💰 Finance Data Processing Backend

## 🚀 Overview
This project is a backend system for managing financial data with role-based access control. It allows different users to interact with financial records based on their roles and provides summary analytics for a dashboard.

---

## 🛠️ Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL / H2 Database
- Maven
- Postman (API Testing)

---

## 👤 User Roles

| Role     | Permissions |
|----------|------------|
| Viewer   | View data only |
| Analyst  | View + Dashboard insights |
| Admin    | Full access (CRUD + user management) |

---

## 📌 Features

### ✅ User Management
- Create users
- View users
- Assign roles (Admin, Analyst, Viewer)

### ✅ Financial Records
- Create, update, delete records
- View all records
- Filter by type and category

### ✅ Dashboard APIs
- Total Income
- Total Expenses
- Net Balance

### ✅ Access Control
- Role-based restrictions implemented using custom logic

### ✅ Validation & Error Handling
- Input validation
- Proper error responses
- Clean API behavior

---

## 🌐 API Endpoints

### 👤 Users
- `POST /users` → Create user
- `GET /users` → Get all users

---

### 💰 Records
- `POST /records` → Create record
- `GET /records` → Get all records
- `GET /records?type=INCOME` → Filter by type
- `GET /records?category=Salary` → Filter by category
- `PUT /records/{id}` → Update record
- `DELETE /records/{id}` → Delete record

---

### 📊 Dashboard
- `GET /dashboard/summary` → Get financial summary

---

## 🔐 Access Control Example

| API | Role Required |
|-----|-------------|
| Create User | ADMIN |
| Create Record | ADMIN |
| View Records | ANALYST / VIEWER |
| Dashboard | ANALYST |

---

## ▶️ How to Run

1. Clone the repository
```bash
git clone https://github.com/HemanthBikkina/finance-backend.git