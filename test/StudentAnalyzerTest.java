

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {
    StudentAnalyzer analyzer = new StudentAnalyzer();

    

    @Test
    @DisplayName("Trường hợp bình thường: Có cả điểm hợp lệ và không hợp lệ")
    void testCountExcellentNormal() {
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(2, analyzer.countExcellentStudents(scores), "Nên đếm đúng 2 điểm >= 8.0 và bỏ qua điểm sai");
    }

    @Test
    @DisplayName("Trường hợp biên: Danh sách trống")
    void testCountExcellentEmpty() {
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
        assertEquals(0, analyzer.countExcellentStudents(null));
    }

    @Test
    @DisplayName("Trường hợp biên: Điểm cực trị 0 và 10")
    void testCountExcellentBoundaries() {
        
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(0.0, 10.0)));
    }

    @Test
    @DisplayName("Trường hợp ngoại lệ: Tất cả điểm đều ngoài khoảng 0-10")
    void testCountExcellentAllInvalid() {
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(-5.0, 15.5, 20.0)));
    }

    

    @Test
    @DisplayName("Trường hợp bình thường: Danh sách toàn bộ hợp lệ")
    void testAverageAllValid() {
        
        assertEquals(8.0, analyzer.calculateValidAverage(Arrays.asList(9.0, 8.0, 7.0)), 0.001);
    }

    @Test
    @DisplayName("Trường hợp bình thường: Có điểm không hợp lệ xen kẽ")
    void testAverageMixed() {
        
        assertEquals(8.0, analyzer.calculateValidAverage(Arrays.asList(9.0, -1.0, 7.0, 11.0)), 0.001);
    }

    @Test
    @DisplayName("Trường hợp biên: Danh sách trống trả về 0")
    void testAverageEmpty() {
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()));
    }

    @Test
    @DisplayName("Trường hợp biên: Chỉ chứa giá trị 0 hoặc 10")
    void testAverageMinMax() {
        assertEquals(5.0, analyzer.calculateValidAverage(Arrays.asList(0.0, 10.0)), 0.001);
    }

    @Test
    @DisplayName("Trường hợp ngoại lệ: Có điểm < 0 hoặc > 10")
    void testAverageInvalidScores() {
        
        assertEquals(5.0, analyzer.calculateValidAverage(Arrays.asList(5.0, -10.0, 10.1)), 0.001);
    }
    @Test
    @DisplayName("Kiểm tra giá trị biên đúng 8.0")
    void testCountExcellentAtBoundary() {
    assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(8.0)), "Điểm 8.0 phải được tính là học sinh giỏi");
    }
    @Test
    @DisplayName("Black-box: Phân vùng tương đương - Điểm hợp lệ tầm trung")
    void testBlackBoxValidMiddle() {
    // Input nằm trong khoảng [0, 10]
    List<Double> scores = Arrays.asList(5.0, 6.5, 7.5);
    assertEquals(0, analyzer.countExcellentStudents(scores), "Không có điểm nào >= 8.0");
    assertEquals(6.333, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    @DisplayName("Black-box: Giá trị biên - Kiểm tra các ngưỡng 0, 8, 10")
    void testBlackBoxBoundaries() {
        // Đây là nơi bạn phát hiện ra lỗi > 8 hay >= 8
        List<Double> scores = Arrays.asList(0.0, 8.0, 10.0);
        assertEquals(2, analyzer.countExcellentStudents(scores), "Phải tính cả 8.0 và 10.0");
        assertEquals(6.0, analyzer.calculateValidAverage(scores), 0.001);
    }
    @Test
    @DisplayName("White-box: Kiểm tra luồng điều kiện (Decision Coverage)")
    void testWhiteBoxDecisionCoverage() {
        // Case 1: scores = null (Điểm đi vào nhánh if đầu tiên)
        assertEquals(0, analyzer.countExcellentStudents(null));
        
        // Case 2: scores contains null element (Kiểm tra điều kiện score != null bên trong vòng lặp)
        List<Double> mixedScores = Arrays.asList(9.0, null, -5.0);
        assertEquals(1, analyzer.countExcellentStudents(mixedScores), "Phải bỏ qua phần tử null");
    }

    @Test
    @DisplayName("White-box: Kiểm tra vòng lặp (Loop Testing)")
    void testWhiteBoxLoop() {
        // Vòng lặp chạy 0 lần
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
        
        // Vòng lặp chạy 1 lần
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(9.0)));
        
        // Vòng lặp chạy n lần
        assertEquals(2, analyzer.countExcellentStudents(Arrays.asList(8.5, 9.5, 7.0)));
    }
}