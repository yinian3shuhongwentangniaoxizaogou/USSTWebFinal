package com.shang.canteenreviewsystemdemo.service;

import com.shang.canteenreviewsystemdemo.model.Canteen;
import com.shang.canteenreviewsystemdemo.model.Comment;
import com.shang.canteenreviewsystemdemo.model.Dto.CommentDto;

import java.util.List;

public interface CanteenService {
    public List<Canteen> getCanteenList();
}