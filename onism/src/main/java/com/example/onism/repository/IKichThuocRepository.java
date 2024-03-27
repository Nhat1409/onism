package com.example.onism.repository;

import com.example.onism.entity.KichThuoc;
import com.example.onism.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IKichThuocRepository extends JpaRepository <KichThuoc, Long>{

    @Query("SELECT k FROM KichThuoc k WHERE k.tenSize LIKE %?1%")
    KichThuoc searchKichThuoc(String keyword);

}
