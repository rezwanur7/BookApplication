 BookApplication – NIT3213 Final Assignment

 📖 Overview
This project is an Android application developed as part of the **NIT3213 Android Application Development** final assignment.  
It demonstrates proficiency in:
- API integration  
- User interface design  
- Dependency injection (Hilt)  
- Clean architecture principles  
- Unit testing  

The application interacts with the provided API (`vu-nit3213-api`) to authenticate users and retrieve data.

---

🚀 Features
 1. Login Screen
- Username: rezwanur  
- Password: 8145611  
- Authenticates via API and navigates to the dashboard on success  
- Displays error messages on failed login  


---

 2. Dashboard Screen
- Fetches data from the API using the `keypass` from login  
- Displays entities in a RecyclerView
- Each item shows a summary   
- Click on an item → navigates to Details Screen

---

3. Details Screen
- Shows full information for the selected entity  
- Includes detailed description
- Designed with a clean, user-friendly layout  


---

🛠️ Technical Details
- Language: Kotlin  
- Architecture MVVM + Clean Architecture  
- Dependency Injection Hilt  
- Networking Retrofit + Coroutines  
- UI RecyclerView, ViewBinding  
- Testing JUnit & Mockito for unit tests  

---

 🔗 API Details
Base URL: `https://nit3213api.onrender.com/`

- Login Endpoint  
  - `POST /{location}/auth`  
  - Request body:  
    ```json
    {
      "username": "rezwanur",
      "password": "8145611"
    }
    ```
  - Response:  
    ```json
    {
      "keypass": "MobileApplication"
    }
    ```

- Dashboard Endpoint  
  - `GET /dashboard/{keypass}`  
  - Response contains list of entities with properties and description.  

---

 ⚙️ Installation & Setup
1. Clone this repository:
   ```bash
   git clone https://github.com/rezwanur7/BookApplication.git
   ```
2. Open the project in Android Studio  
3. Let Gradle sync and download dependencies.  
4. Connect an emulator or device.  
5. Run the app (`Shift + F10` or ▶ button).  

---

 🧪 Testing
- Run unit tests:
  ```bash
  ./gradlew test
  ```

---

 📂 Project Structure
```
app/
 ├── data/          # API services, repositories
 ├── di/            # Hilt modules
 ├── ui/            # Activities, Fragments, ViewModels
 ├── model/         # Data models
 └── utils/         # Helper classes
```

---

 📜 Assessment Criteria Mapping
- ✅ Project Completion – Login, Dashboard, Details fully implemented  
- ✅ Clean Code & Organization – MVVM + Clean architecture applied  
- ✅ Dependency Injection – Implemented using Hilt  
- ✅ Unit Testing – Added for ViewModels & repositories  
- ✅ Git Usage – Clear commit history with meaningful messages  
- ✅ README – Provides instructions for building and running  

---

👤 Author
- Name: [Ali Mohammad Rezwanur Rahman]  
- Student ID: [s8145611]  
- Course: NIT3213 Android Application Development  

---
