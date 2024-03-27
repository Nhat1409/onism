package com.example.onism.services;

import com.example.onism.entity.KichThuoc;
import com.example.onism.entity.Loai;
import com.example.onism.entity.SanPham;
import com.example.onism.repository.IKichThuocRepository;
import com.example.onism.repository.ILoaiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KichThuocService {

    @Autowired
    private final IKichThuocRepository kichThuocRepository;

    public List<KichThuoc> getAllKichThuoc(){
        return kichThuocRepository.findAll();
    }

    public KichThuoc getKichThuocById(Long id){
        return kichThuocRepository.findById(id).orElse(null);
    }

    public void addKichThuoc(KichThuoc kichThuoc){
        kichThuocRepository.save(kichThuoc);
    }

    public void updateKichThuoc(KichThuoc kichThuoc){
        kichThuocRepository.save(kichThuoc);
    }

    public void deleteKichThuoc(Long id){
        kichThuocRepository.deleteById(id);
    }
}
