# JaCoCo Code Coverage Setup

## Yêu cầu
- Java JDK 11 hoặc cao hơn
- Maven hoặc Gradle

## Cách 1: Sử dụng Maven (Được khuyến khích)

### 1. Cài đặt Java
```bash
# Kiểm tra Java đã được cài hay chưa
java -version
```

Nếu Java chưa được cài:
- Download từ: https://www.oracle.com/java/technologies/downloads/
- Hoặc sử dụng Chocolatey trên Windows: `choco install openjdk11`

### 2. Cài đặt Maven
```bash
# Nếu chưa cài Maven
choco install maven

# Hoặc download từ: https://maven.apache.org/download.cgi
```

### 3. Chạy coverage
```bash
cd c:\Users\Nhu Vu\OneDrive\Máy tính\unit-test
mvn clean test jacoco:report
```

### 4. Xem báo cáo
Mở file: `target/site/jacoco/index.html`

---

## Cách 2: Sử dụng Gradle

### 1. Cài đặt Gradle
```bash
choco install gradle

# Hoặc download từ: https://gradle.org/releases/
```

### 2. Chạy coverage
```bash
cd c:\Users\Nhu Vu\OneDrive\Máy tính\unit-test
gradle test jacocoTestReport
```

### 3. Xem báo cáo
Mở file: `build/reports/jacoco/test/html/index.html`

---

## Cấu hình JaCoCo đã được tạo

### pom.xml (Maven)
- Đã cấu hình JaCoCo plugin
- Sẽ tự động chạy trước/sau khi test
- Báo cáo HTML sẽ được tạo ở: `target/site/jacoco/`

### build.gradle (Gradle)
- Đã cấu hình JaCoCo plugin
- Báo cáo HTML sẽ được tạo ở: `build/reports/jacoco/test/html/`

---

## Giải thích các thành phần coverage

| Thành phần | Ý nghĩa |
|-----------|---------|
| **Line Coverage** | % số dòng code được thực thi |
| **Branch Coverage** | % các nhánh điều kiện (if/else) được kiểm tra |
| **Method Coverage** | % các phương thức được gọi |
| **Class Coverage** | % các class được sử dụng |

---

## Bài toán kiểm tra trong project

**StudentAnalyzer.java** có 2 method:
1. `countExcellentStudents()` - Đếm sinh viên có điểm >= 8
2. `calculateValidAverage()` - Tính trung bình điểm hợp lệ

**StudentAnalyzerTest.java** có các test cases kiểm tra các scenario khác nhau.

JaCoCo sẽ đo lường % code được bao phủ bởi các test này.

---

## Troubleshooting

### "mvn command not found"
→ Cần cài Maven và thêm vào PATH

### "Java command not found"
→ Cần cài Java JDK

### Report không được tạo
→ Đảm bảo test chạy thành công trước
→ Kiểm tra lại cấu hình pom.xml hoặc build.gradle
