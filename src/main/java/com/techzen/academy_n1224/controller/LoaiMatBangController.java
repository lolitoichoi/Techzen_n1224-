//package com.techzen.academy_n1224.controller;
//
//import com.techzen.academy_n1224.model.Department;
//import com.techzen.academy_n1224.model.LoaiMatBang;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/loaimatbangs")
//public class LoaiMatBangController {
//    private final List<LoaiMatBang> loaiMatBangs = new ArrayList<>(
//            Arrays.asList(
//                    new LoaiMatBang(1, "Văn phòng"),
//                    new LoaiMatBang(2, "Nhà ở"),
//                    new LoaiMatBang(3, "Cửa hàng")
//            )
//    );
//
//    @GetMapping
//    public ResponseEntity<?> getAllLoaiMatBang() {
//        return ResponseEntity.ok(loaiMatBangs);
//    }
//}