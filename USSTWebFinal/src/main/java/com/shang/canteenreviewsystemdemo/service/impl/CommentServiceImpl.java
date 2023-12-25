package com.shang.canteenreviewsystemdemo.service.impl;

import com.shang.canteenreviewsystemdemo.model.Comment;
import com.shang.canteenreviewsystemdemo.model.Dto.CommentDto;
import com.shang.canteenreviewsystemdemo.repository.CanteenRepository;
import com.shang.canteenreviewsystemdemo.repository.CommentRepository;
import com.shang.canteenreviewsystemdemo.repository.UserRepository;
import com.shang.canteenreviewsystemdemo.service.CanteenService;
import com.shang.canteenreviewsystemdemo.service.CommentService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentRepository commentRepository;

    @Resource
    private CanteenRepository canteenRepository;

    @Resource
    private UserRepository userRepository;

    @Override
    public List<Comment> getCommentList() {
        return commentRepository.findAll(Sort.by("commentTime").descending());
    }

    @Override
    public List<Comment> search(Integer canteen, String foodName) {
        return commentRepository.searchByCanteenAndFood(canteen, foodName);
    }

    @Override
    public void add(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void add(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setCreatedBy(userRepository.findByUsername(commentDto.getCreatedBy()));
        comment.setCanteen(canteenRepository.getOne(commentDto.getCanteen()));
        comment.setWhichWindow(commentDto.getWhichWindow());
        comment.setFoodName(commentDto.getFoodName());
        comment.setApprovals(0);
        comment.setScoreForTaste(commentDto.getScoreForTaste());
        comment.setScoreForPrice(commentDto.getScoreForPrice());
        comment.setTitle(commentDto.getTitle());
        comment.setContent(commentDto.getContent());

        commentRepository.save(comment);
    }

    @Override
    public void edit(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
