package com.example.onism.controller;

import com.example.onism.entity.Item;
import com.example.onism.entity.KichThuoc;
import com.example.onism.entity.SanPham;
import com.example.onism.services.CartService;
import com.example.onism.services.KichThuocService;
import com.example.onism.services.LoaiService;
import com.example.onism.services.SanPhamService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sanPhams")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private CartService cartService;


    @Autowired
    private LoaiService loaiService;

    @Autowired
    private KichThuocService kichThuocService;

    @GetMapping
    public String showAll(Model model){
        List<SanPham> sanphams = sanPhamService.getAllSanPham();
        model.addAttribute("sanphams", sanphams);
        return "sanpham/list";
    }

    @GetMapping("/add")
    public String addSanPhamsForm(Model model){
        model.addAttribute("sanpham", new SanPham());
        model.addAttribute("loais", loaiService.getAllLoai());
        model.addAttribute("kichThuocs", kichThuocService.getAllKichThuoc());
        return "sanpham/add";
    }

    @PostMapping("/add")
    public String addSanPhams(@Valid @ModelAttribute("sanpham")SanPham sanPham, BindingResult result){
        if(result.hasErrors()) {
            return "sanpham/add";
        }
        sanPhamService.addSanPham(sanPham);
        return "redirect:/sanPhams";
    }

    @GetMapping("/edit/{id}")
    public String editSanPham(@PathVariable("id") Long id, Model model){
        SanPham a = sanPhamService.getSanPhamById(id);
        if(a != null){
            model.addAttribute("sanpham", a);
            model.addAttribute("loai", loaiService.getLoaiById(a.getLoai().getId()));
            model.addAttribute("loais", loaiService.getAllLoai());
            model.addAttribute("kichThuoc", kichThuocService.getKichThuocById(a.getKichThuoc().getId()));
            model.addAttribute("kichThuocs", kichThuocService.getAllKichThuoc());

            return "sanpham/edit";
        }
        else{
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editSanPham(@Valid @ModelAttribute("sanpham") SanPham update, BindingResult result){
        SanPham a = sanPhamService.getSanPhamById(update.getId());
        if(result.hasErrors()){
            return "sanpham/edit";
        }
        sanPhamService.updateSanPham(update);
        return "redirect:/sanPhams";
    }


    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        SanPham a = sanPhamService.getSanPhamById(id);
        sanPhamService.deleteSanPham(a.getId());
        return "redirect:/sanPhams";
    }

    @GetMapping("/search")
    public String searchBook(
            @NotNull Model model,
            @RequestParam String keyword ){
        model.addAttribute("sanphams", sanPhamService.searchBook(keyword));
        model.addAttribute("loais",
                loaiService.getAllLoai());
        return "sanpham/list";
    }
    @PostMapping("/add-to-cart")
    public String addToCart(HttpSession session,
                            @RequestParam long id,
                            @RequestParam String tenSP,
                            @RequestParam double giaTien,
                            @RequestParam(defaultValue = "1") int quantity,
                            @RequestParam String kichThuoc)
    {
        var cart = cartService.getCart(session);
        cart.addItems(new Item(id, tenSP, giaTien, quantity, kichThuoc));
        cartService.updateCart(session, cart);
        return "redirect:/sanPhams";
    }

    @GetMapping("/chitiet/{tenSP}")
    public String chiTietSanPham(@PathVariable("tenSP") String tenSP, Model model){
        SanPham a = sanPhamService.getByTenSP(tenSP);
        if(a != null){
            model.addAttribute("sanpham", a);
            model.addAttribute("loai", loaiService.getLoaiById(a.getLoai().getId()));
            model.addAttribute("kichThuocs", kichThuocService.getAllKichThuoc());

            return "sanpham/chitiet";
        }
        else{
            return "not-found";
        }
    }
}
