//package com.techzen.academy_n1224.repository.impl;
//
//
//import com.techzen.academy_n1224.dto.employee.EmployeeSearchRequest;
//import com.techzen.academy_n1224.dto.employee.MatBangSearchRequest;
//import com.techzen.academy_n1224.model.Employee;
//import com.techzen.academy_n1224.model.MatBang;
//import com.techzen.academy_n1224.repository.IMatBangRepository;
//import lombok.AccessLevel;
//import lombok.experimental.FieldDefaults;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Repository;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.time.LocalDate;
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Repository
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//public class MatBangRepository implements IMatBangRepository {
////    private final List<MatBang> matBangs = new ArrayList<>(
////            Arrays.asList(
////                    new MatBang(UUID.randomUUID(), "Ven song", "Đà Nẵng", "30m", "Tốt", 24121.12312, LocalDate.of(2025, 1, 10)),
////                    new MatBang(UUID.randomUUID(), "Ven biển", "Đà Nẵng", "40m", "Trung bình", 24121.12312, LocalDate.of(2025, 2, 10)),
////                    new MatBang(UUID.randomUUID(), "Ven hồ", "Đà Nẵng", "50m", "Tốt", 24121.12312, LocalDate.of(2025, 3, 10)),
////                    new MatBang(UUID.randomUUID(), "Ven núi", "Đà Nẵng", "60m", "XỊn", 24121.12312, LocalDate.of(2025, 4, 10))
////            )
////    );
////
////    @Override
////    public List<MatBang> findByAttributes(MatBangSearchRequest matBangSearchRequest) {
////        return matBangs.stream()
////                .filter(e -> (matBangSearchRequest.getTenMatBang() == null
////                        || matBangSearchRequest.getTenMatBang().toLowerCase().contains(matBangSearchRequest.getTenMatBang().toLowerCase())))
////                .collect(Collectors.toList());
////    }
////    @Override
////    public Optional<Employee> findById(UUID id) {
////        return matBangs.stream()
////                .filter(e -> e.getMaMatBang().equals(id))
////                .findFirst();
////    }
////
////    @Override
////    public void delete(UUID id) {
////        findById(id).ifPresent(matBangs::remove);
////    }
//public MatBang findById(int id) {
//    try {
//        PreparedStatement ps = BaseRepository.getConnection().prepareStatement("SELECT * FROM MatBang WHERE maMatBang = ?");
//        ps.setInt(1, id);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            return MatBang.builder()
//                    .maMatBang(rs.getInt("maMatBang"))
//                    .tenMatBang(rs.getString("tenMatBang"))
//                    .diaChi(rs.getString("diaChi"))
//                    .dienTich(rs.getString("dienTich"))
//                    .giaThue(rs.getDouble("giaThue"))
//                    .ngayChoThue(rs.getDate("ngayBatDau"))
//                    .loaiMatBang(rs.getString("loaiMatBangId"))
//                    .build();
//        }
//    } catch (SQLException e) {
//        throw new RuntimeException(e);
//    }
//    return null;
//}
//
//    public List<?> getAll() {
//        List<MatBang> matBang = new ArrayList<>();
//        try {
//            PreparedStatement ps = BaseRepository.getConnection().prepareStatement("select mb.maMatBang,mb.tenMatBang,mb.diaChi,mb.dienTich,l.tenLoaiMatBang,mb.giaThue,mb.ngayBatDau, mb.loaiMatBangId, l.id from MatBang mb join LoaiMatBang l on l.id = mb.loaiMatBangId");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                matBang.add(MatBang.builder()
//                        .maMatBang(rs.getInt("maMatBang"))
//                        .tenMatBang(rs.getString("tenMatBang"))
//                        .diaChi(rs.getString("diaChi"))
//                        .dienTich(rs.getString("dienTich"))
//                        .giaThue(rs.getDouble("giaThue"))
//                        .ngayChoThue(rs.getDate("ngayBatDau"))
//                        .loaiMatBang(rs.getString("loaiMatBangId"))
//                        .build());
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return matBang;
//    }
//
//
//    public MatBang save(MatBang matBang) {
//        try {
//            PreparedStatement ps = BaseRepository.getConnection().prepareStatement("INSERT INTO MatBang (tenMatBang,diaChi,dienTich,giaThue,ngayBatDau,loaiMatBangId) values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, matBang.getTenMatBang());
//            ps.setString(2, matBang.getDiaChi());
//            ps.setString(3, matBang.getDienTich());
//            ps.setDouble(4, matBang.getGiaThue());
//            ps.setNull(5, java.sql.Types.DATE);
//            ps.setString(6, matBang.getLoaiMatBang());
//            ps.executeUpdate();
//            ResultSet rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                matBang.setMaMatBang(rs.getInt(1));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }
//
//    public MatBang delete(int id) {
//        MatBang matBang = findById(id);
//        if (matBang != null) {
//            try {
//                PreparedStatement ps = BaseRepository.getConnection().prepareStatement("delete from matbang where id_matbang = ?");
//                ps.setInt(1, id);
//                ps.executeUpdate();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            return matBang;
//        }
//        return null;
//    }
//
//}
