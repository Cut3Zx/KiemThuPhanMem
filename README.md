# Bài tập Unit Test với JUnit 5 - Phân tích điểm học sinh

## 📋 Thông tin sinh viên
- **Họ và tên:** Vũ Việt Hòa
- **MSSV:** BIT230162
- **Lớp:** 23IT5

## 📝 Mô tả dự án
Dự án thực hành Unit Test sử dụng JUnit 5 để kiểm thử các hàm phân tích điểm học sinh. Mục tiêu là viết các test case bao quát (normal case, edge case, exception case) để đảm bảo tính đúng đắn của các hàm trong lớp `StudentAnalyzer`.

## 1. Chức năng chính
Lớp `StudentAnalyzer` cung cấp hai chức năng chính:

- **`countExcellentStudents(List<Double> scores)`**: Đếm số lượng học sinh có điểm >= 8.0
  - Xử lý các điểm không hợp lệ (null, < 0, > 10)
  - Trả về 0 nếu danh sách rỗng hoặc null

- **`calculateValidAverage(List<Double> scores)`**: Tính điểm trung bình của các điểm hợp lệ (0-10)
  - Chỉ tính trung bình các điểm trong khoảng [0, 10]
  - Bỏ qua các điểm null, âm hoặc vượt quá 10
  - Trả về 0.0 nếu không có điểm hợp lệ

## 2. Cấu trúc dự án
```
unit-test/
├── README.md
├── src/
│   └── StudentAnalyzer.java    (Lớp chính chứa logic)
├── test/
│   └── StudentAnalyzerTest.java (Các test case)
└── lib/                         (Thư viện JUnit 5)
```

## 3. Các Test Case được thực hiện

### Test 1: `testCountExcellentStudents()`
- **Input:** `[9.0, 8.5, 7.0, 11.0, -1.0]`
- **Expected:** `2` (9.0 và 8.5 >= 8.0, loại bỏ 11.0 và -1.0 vì ngoài phạm vi)
- **Kết quả:** ✅ Passed

### Test 2: `testCalculateValidAverage()`
- **Input:** `[9.0, 8.5, 7.0]`
- **Expected:** `8.16` (với sai số 0.01)
- **Tính toán:** (9.0 + 8.5 + 7.0) / 3 = 8.166...
- **Kết quả:** ✅ Passed

## 4. Hướng dẫn chạy Test
1. Mở dự án bằng **Visual Studio Code**
2. Đảm bảo đã cài đặt **Extension Pack for Java**
3. Nhấp vào tab **Testing** (biểu tượng bình thí nghiệm) ở thanh công cụ bên trái
4. Nhấn nút **Play** ▶️ để chạy toàn bộ kiểm thử
5. Hoặc chạy từng test bằng cách nhấp nút **Play** bên cạnh từng test case

## 5. Kết quả cuối cùng
✅ **Tất cả các ca kiểm thử đều Passed**
- Test coverage bao quát: Normal cases, Edge cases, Exception cases
- Không có lỗi hoặc cảnh báo