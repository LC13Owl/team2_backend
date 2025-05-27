package com.example.test.repository;


import com.example.test.entity.BoardEntity;
import com.example.test.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

}
