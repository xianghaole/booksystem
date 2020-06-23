package com.xjl.springboot.controller;

import com.xjl.springboot.domain.Book;
import com.xjl.springboot.domain.ResponseEntity;
import com.xjl.springboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/findAll/{currentPage}/{pageSize}")
    public ResponseEntity findAll(@PathVariable("currentPage") Integer currentPage,@PathVariable("pageSize") Integer pageSize){
        PageRequest pageRequest = PageRequest.of(currentPage,pageSize);
        Page<Book> page = bookRepository.findAll(pageRequest);
        return ResponseEntity.ok(page);
    }
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result!=null){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.errorMsg("添加失败");
        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity findById(@PathVariable("id") Integer id){
        Book book = bookRepository.findById(id).get();
        return ResponseEntity.ok(book);
    }
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result!=null){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.errorMsg("修改失败");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
        return ResponseEntity.ok();
    }
}
