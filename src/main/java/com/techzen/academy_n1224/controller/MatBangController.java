//package com.techzen.academy_n1224.controller;
//
//import com.techzen.academy_n1224.exception.ApiException;
//import com.techzen.academy_n1224.exception.ErrorCode;
//import com.techzen.academy_n1224.model.MatBang;
//
//import com.techzen.academy_n1224.service.IMatbangService;
//import com.techzen.academy_n1224.until.JsonRespone;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.*;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/matbangs")
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@AllArgsConstructor
//public class MatBangController {
//    IMatbangService matBangService;
//
//    @GetMapping()
//    private ResponseEntity<?> getAll() {
//        return JsonRespone.ok(matBangService.getAll());
//    }
//
//    @PostMapping("/add")
//    private ResponseEntity<?> add(@RequestBody MatBang matBang) {
//        return JsonRespone.created(matBangService.save(matBang));
//    }
//    @GetMapping("/{id}")
//    private ResponseEntity<?> findById(@PathVariable("id") int id) {
//        return JsonRespone.ok(matBangService.findById(id));
//    }
//    @DeleteMapping("/{id}")
//    private ResponseEntity<?> deleteById(@PathVariable("id") int id) {
//        matBangService.delete(id);
//        return JsonRespone.noContent();
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////    private final List<MatBang> matBangs = new ArrayList<>(
////            Arrays.asList(
////                    new MatBang(UUID.randomUUID(), "Ven song", "Đà Nẵng", "30m", "Tốt", 24121.12312, LocalDate.of(2025, 1, 10)),
////                    new MatBang(UUID.randomUUID(), "Ven biển", "Đà Nẵng", "40m", "Trung bình", 24121.12312, LocalDate.of(2025, 2, 10)),
////                    new MatBang(UUID.randomUUID(), "Ven hồ", "Đà Nẵng", "50m", "Tốt", 24121.12312, LocalDate.of(2025, 3, 10)),
////                    new MatBang(UUID.randomUUID(), "Ven núi", "Đà Nẵng", "60m", "XỊn", 24121.12312, LocalDate.of(2025, 4, 10))
////            )
////    );
////
////    @GetMapping
////    public ResponseEntity<List<MatBang>> getAll() {
////        return ResponseEntity.ok(matBangs);
////    }
////
////    @GetMapping("/{id}")
////    public ResponseEntity<MatBang> getMatBangById(@PathVariable("id") UUID id) {
////        return matBangs.stream()
////                .filter(e -> e.getMaMatBang().equals(id))
////                .findFirst()
////                .map(ResponseEntity::ok)
////                .orElse(ResponseEntity.notFound().build());
////    }
////
////    @GetMapping
////    public ResponseEntity<?> getAll(
////            @RequestParam(value = "tenMatBang ", required = false) String tenMatBang,
////            @RequestParam(value = "ngayChoThueFrom ", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate ngayChoThueFrom,
////            @RequestParam(value = "ngayChoThueTo ", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate ngayChoThueTo,
////            @RequestParam(value = "dienTich ", required = false) String dienTich,
////            @RequestParam(value = "giaThueRange ", required = false) String giaThue,
////            @RequestParam(value = "diaChi ", required = false) String diaChi,
////            @RequestParam(value = "loaiMatBang ", required = false) String loaiMatBang
////    ) {
////        List<MatBang> filteredEmployees = matBangs.stream()
////                .filter(e -> (tenMatBang == null || e.getTenMatBang().toLowerCase().contains(tenMatBang.toLowerCase())))
////                .filter(e -> (ngayChoThueFrom == null || !e.getNgayChoThue().isBefore(ngayChoThueFrom)))
////                .filter(e -> (ngayChoThueTo == null || !e.getNgayChoThue().isAfter(ngayChoThueTo)))
////                .filter(e -> (dienTich == null || e.getDienTich().toLowerCase().contains(dienTich.toLowerCase())))
////                .filter(e -> (diaChi == null || e.getDiaChi().toLowerCase().contains(diaChi.toLowerCase())))
////                .filter(e -> (loaiMatBang == null || Objects.equals(e.getLoaiMatBang(), loaiMatBang)))
////                .filter(e -> {
////                    if (giaThue == null) {
////                        return true;
////                    }
////                    return switch (giaThue) {
////                        case "duoi 2tr" -> e.getGiaThue() < 2000000;
////                        case "2 triệu đến dưới 5 triệu" -> e.getGiaThue() >= 2000000 && e.getGiaThue() < 5000000;
////                        case "5 triệu đến dưới 10 triệu" -> e.getGiaThue() >= 5000000 && e.getGiaThue() < 10000000;
////                        case "Trên 10 triệu" -> e.getGiaThue() > 10000000;
////                        default -> true;
////                    };
////                })
////                .collect(Collectors.toList());
////        return JsonRespone.ok(filteredEmployees);
////    }
////
////    @DeleteMapping("/{id}")
////    public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
////        return matBangs.stream()
////                .filter(e -> e.getMaMatBang().equals(id))
////                .findFirst()
////                .map(s -> {
////                    matBangs.remove(s);
////                    return JsonRespone.noContent();
////                })
////                .orElseThrow(() -> new ApiException(ErrorCode.MATBANG_NOT_EXIT));
////    }
//
//
//}
