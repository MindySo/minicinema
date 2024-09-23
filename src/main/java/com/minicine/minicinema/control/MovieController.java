package com.minicine.minicinema.control;

import com.minicine.minicinema.dto.*;
import com.minicine.minicinema.dto.member.MemberDto;
import com.minicine.minicinema.service.ActorService;
import com.minicine.minicinema.service.FavoriteService;
import com.minicine.minicinema.service.GenreService;
import com.minicine.minicinema.service.MovieServiceImple;
import com.minicine.minicinema.service.comment.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
@Slf4j
public class MovieController {
    private final AttributeController attributeController;
    private final MovieServiceImple movieService;
    private final ActorService actorService;
    private final GenreService genreService;
    private final FavoriteService favoriteService;
    private final CommentService commentService;

    @ModelAttribute
    public void addAttributes(HttpServletRequest request, final Model model) {
        attributeController.addAttributes(request, model);
    }

    @GetMapping("/detailMovie/{movieId}")
    public String detailMovie(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model, @PathVariable Long movieId) {

        MovieDto movie = movieService.selectOneByMovieId(movieId);
        List<ActorDto> actorList= actorService.selectAllByMovieId(movieId);
        List<GenreDto> genreList= genreService.selectAllByMovieId(movieId);

        boolean favoriteBool = false;
        if(loginInfo != null) {
            FavoriteDto favoriteDto = new FavoriteDto(null, movieId, loginInfo.getId());
            favoriteBool = favoriteService.ifFavorite(favoriteDto);
        }

        List<MovieDto> recommendList = movieService.selectByGenre(genreList);
        recommendList = recommendList.stream()
                .filter(m -> !m.getMovieId().equals(movie.getMovieId()))
                .limit(30)
                .collect(Collectors.toList());

        List<CommentDto> commentList = commentService.selectAllByMovieId(movieId);

        model.addAttribute("movie", movie);
        model.addAttribute("actorList", actorList);
        model.addAttribute("genreList", genreList);
        model.addAttribute("favoriteBool", favoriteBool);
        model.addAttribute("recommendList", recommendList);
        model.addAttribute("loginInfo", loginInfo);
        model.addAttribute("commentList", commentList);
        return "/detail/detailMovie";
    }

    @GetMapping("/searchMovie")
    public String searchMovie(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model,
                              @RequestParam String category, @RequestParam String keyword) {
        String likeKeyword = '%' + keyword + '%';

        List<MovieDto> movieList = null;
        if(category.equals("whole")) {
            movieList = movieService.selectByKeyword(likeKeyword);
        }else if(category.equals("title")){
            movieList = movieService.selectByTitle(likeKeyword);
        }else if(category.equals("director")){
            movieList = movieService.selectByDirector(likeKeyword);
        }else if(category.equals("actor")){
            movieList = movieService.selectByActor(likeKeyword);
        };
        model.addAttribute("category", category);
        model.addAttribute("keyword", keyword);
        model.addAttribute("MovieList", movieList);
        model.addAttribute("loginInfo", loginInfo);
        model.addAttribute("showSearch", "yes");

        return "/main/main";
    }

    @GetMapping("/myMovie")
    public String myMovie(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model) {
        List<MovieDto> movieList = movieService.selectById(loginInfo.getId());
        model.addAttribute("MovieList", movieList);
        model.addAttribute("loginInfo", loginInfo);
        log.info("loginInfo: {}" , loginInfo);

        return "/member/myMovie";
    }
}
