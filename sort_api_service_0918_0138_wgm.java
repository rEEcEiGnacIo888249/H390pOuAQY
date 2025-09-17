// 代码生成时间: 2025-09-18 01:38:24
package com.example.sortapi.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
# NOTE: 重要实现细节
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
# NOTE: 重要实现细节
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/sort")
public class SortApiService {
# FIXME: 处理边界情况

    @GetMapping
    public ResponseEntity<List<Integer>> sortNumbers(@RequestParam List<Integer> numbers) {
        try {
            if (numbers == null || numbers.isEmpty()) {
                throw new IllegalArgumentException("Numbers list cannot be empty");
            }
            List<Integer> sortedNumbers = sort(numbers);
            return ResponseEntity.ok(sortedNumbers);
# 改进用户体验
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
# FIXME: 处理边界情况
    }

    private List<Integer> sort(List<Integer> numbers) {
        return Arrays.stream(numbers).sorted().toList();
    }
}