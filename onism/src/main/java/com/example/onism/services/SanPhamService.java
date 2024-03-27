package com.example.onism.services;

import com.example.onism.entity.SanPham;
import com.example.onism.repository.ISanPhamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SanPhamService {
    @Autowired
    private final ISanPhamRepository sanPhamRepository;
    public List<SanPham> getAllSanPham(){
        return sanPhamRepository.findAll();
    }

    public List<SanPham> searchBook(String keyword) {
        return sanPhamRepository.searchBook(keyword);
    }

    public SanPham getSanPhamById(Long id){
        return sanPhamRepository.findById(id).orElse(null);
    }


    public SanPham getByTenSP(String tenSP){
        return sanPhamRepository.findSPByName(tenSP);
    }

    public void addSanPham(SanPham sp){
        sanPhamRepository.save(sp);
    }

    public void updateSanPham(SanPham sp){
        sanPhamRepository.save(sp);
    }

    public void deleteSanPham(Long id){
        sanPhamRepository.deleteById(id);
    }
}
