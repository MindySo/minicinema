package com.minicine.minicinema.control;

import com.minicine.minicinema.dto.FavoriteDto;
import com.minicine.minicinema.dto.auth.MemberRequestDto;
import com.minicine.minicinema.dto.auth.TokenDto;
import com.minicine.minicinema.dto.member.MemberDto;
import com.minicine.minicinema.service.FavoriteService;
import com.minicine.minicinema.service.MovieService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/favorite")
@RequiredArgsConstructor
@Slf4j
public class FavoriteApiController {
    private final AttributeController attributeController;

    private final FavoriteService favoriteService;

    @PostMapping("/add")
    public ResponseEntity<String> addFavorite(
            @Valid @RequestBody FavoriteDto favoriteDto, HttpServletResponse response) throws IOException {
        try {
            favoriteService.insertFavorite(favoriteDto);
            return new ResponseEntity<>("updated", HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.toString());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeFavorite(
            @Valid @RequestBody FavoriteDto favoriteDto, HttpServletResponse response) throws IOException {
        try {
            favoriteService.deleteFavorite(favoriteDto);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.toString());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
