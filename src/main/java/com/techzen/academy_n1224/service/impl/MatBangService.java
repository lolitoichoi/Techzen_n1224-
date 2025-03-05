//package com.techzen.academy_n1224.service.impl;
//
//import com.techzen.academy_n1224.dto.employee.EmployeeSearchRequest;
//import com.techzen.academy_n1224.dto.employee.MatBangSearchRequest;
//import com.techzen.academy_n1224.model.Employee;
//import com.techzen.academy_n1224.model.MatBang;
//import com.techzen.academy_n1224.repository.IEmployeeRepository;
//import com.techzen.academy_n1224.repository.IMatBangRepository;
//import com.techzen.academy_n1224.service.IMatbangService;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//@Service
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//public class MatBangService implements IMatbangService {
//    IMatBangRepository matBangRepository;
//    public List<?> getAll(){
//        return matBangRepository.getAll();
//    }
//    public MatBang save(MatBang matBang){
//        return matBangRepository.save(matBang);
//    }
//    public MatBang findById(int id){
//        return matBangRepository.findById(id);
//    }
//    public MatBang delete(int id){
//        return matBangRepository.delete(id);
//    }
//}
