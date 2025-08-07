
#### 📄 Report Configuration
- Use **ExtentReports** with **Spark HTML reporter**
- Apply **DARK theme** for visual styling
- Generate report in a designated folder (e.g., `/test-output/ExtentReport/`)

---

#### 🧩 Feature & Scenario Structure
- Group all **Scenarios under a single Feature node**
- Clicking the Feature node should **expand child nodes** for each Scenario
- Each Scenario node should display:
    - All **step logs**
    - **Base64 screenshots** attached to each step

---

#### 🖼️ Screenshot Handling
- Capture screenshots on failure or after each step
- Convert screenshots to **Base64 format**
- Attach Base64 images to **Scenario lines** in the report

---

#### 🧭 Report Sections
- Include **three main tabs**:
    - **Tests**
    - **Dashboard**
    - **Bugs/Defects**

---

#### ✨ Styling & Highlights
- Make **header text bold**
- Use **visual highlights** for:
    - Failed steps
    - Scenario names
    - Defect entries


