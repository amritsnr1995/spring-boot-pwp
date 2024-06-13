package com.amritdev.webportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amritdev.webportal.entity.PostMessage;

public interface PostMessageRepository extends JpaRepository<PostMessage, Long> {

}
